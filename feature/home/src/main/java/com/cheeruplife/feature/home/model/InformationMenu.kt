package com.cheeruplife.feature.home.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.cheeruplife.core.resources.icons.MyIconPack
import com.cheeruplife.core.resources.icons.myiconpack.Communication
import com.cheeruplife.core.resources.icons.myiconpack.Education
import com.cheeruplife.core.resources.icons.myiconpack.Event
import com.cheeruplife.core.resources.icons.myiconpack.Link

internal enum class InformationMenu(
    val label: String = "",
    val imageVector: ImageVector = Icons.Rounded.Home,
) {
    역량강화(
        label = "역량강화",
        imageVector = MyIconPack.Education,
    ),
    행사정보(
        label = "행사정보",
        imageVector = MyIconPack.Event,
    ),
    일자리카페(
        label = "일자리카페",
        imageVector = MyIconPack.Communication,
    ),
    유용한사이트(
        label = "유용한사이트",
        imageVector = MyIconPack.Link,
    ),
}