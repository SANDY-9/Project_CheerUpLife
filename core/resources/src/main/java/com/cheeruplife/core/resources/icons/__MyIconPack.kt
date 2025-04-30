package com.cheeruplife.core.resources.icons

import androidx.compose.ui.graphics.vector.ImageVector
import com.cheeruplife.core.resources.icons.myiconpack.Communication
import com.cheeruplife.core.resources.icons.myiconpack.Education
import com.cheeruplife.core.resources.icons.myiconpack.Event
import com.cheeruplife.core.resources.icons.myiconpack.Link
import kotlin.collections.List as ____KtList

public object MyIconPack

private var __MyIconPack: ____KtList<ImageVector>? = null

public val MyIconPack.MyIconPack: ____KtList<ImageVector>
  get() {
    if (__MyIconPack != null) {
      return __MyIconPack!!
    }
    __MyIconPack= listOf(Communication, Education, Event, Link)
    return __MyIconPack!!
  }
