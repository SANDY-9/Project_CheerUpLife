package com.cheeruplife.core.network.utils

import android.util.Xml
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody
import org.json.JSONArray
import org.json.JSONObject
import org.xmlpull.v1.XmlPullParser
import retrofit2.Converter
import retrofit2.Retrofit
import java.io.StringReader
import java.lang.reflect.Type
import javax.inject.Inject

class MyXmlToJsonConverterFactory @Inject constructor(
    private val jsonConverterFactory: Converter.Factory,
    private val contentType: MediaType = "application/json".toMediaType(),
): Converter.Factory() {

    private fun parseXmlToJson(xmlString: String): JSONObject {
        val parser = Xml.newPullParser().apply {
            val reader = StringReader(xmlString)
            setInput(reader)
            nextTag()
        }
        val json = parseElement(parser)
        return json
    }

    private fun parseElement(parser: XmlPullParser): JSONObject {
        val result = JSONObject()
        var eventType = parser.eventType
        var currentName: String? = null
        while (eventType != XmlPullParser.END_DOCUMENT) {
            when (eventType) {
                XmlPullParser.START_TAG -> {
                    currentName = parser.name
                    val child = parseTag(parser)
                    if (result.has(currentName)) {
                        val existing = result.get(currentName)
                        if (existing is JSONArray) {
                            existing.put(child)
                        }
                        else {
                            val jsonArray = JSONArray().put(existing).put(child)
                            result.put(currentName, jsonArray)
                        }
                    }
                    else {
                        result.put(currentName, child)
                    }
                }
                XmlPullParser.END_TAG -> return result
            }
            eventType = parser.next()
        }
        return result
    }

    private fun parseTag(parser: XmlPullParser): Any {
        val eventType = parser.next()
        if (eventType == XmlPullParser.TEXT) {
            val text = parser.text.trim()
            return text
        }
        if (eventType == XmlPullParser.END_TAG) {
            return ""
        }
        return parseElement(parser)
    }

    override fun responseBodyConverter(
        type: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): Converter<ResponseBody, *>? {
        val jsonConverter = jsonConverterFactory
            .responseBodyConverter(type, annotations, retrofit) ?: return null
        return Converter<ResponseBody, Any> { body ->
            val xmlString = body.string()
            val jsonObject = parseXmlToJson(xmlString)
            val newBody = jsonObject.toString().toResponseBody(contentType)
            jsonConverter.convert(newBody)
        }
    }
}