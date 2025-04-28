package com.cheeruplife.core.resources.icons

import androidx.compose.ui.graphics.vector.ImageVector
import com.cheeruplife.core.resources.icons.myiconpack.EditCalendar
import com.cheeruplife.core.resources.icons.myiconpack.NotificationActive
import kotlin.collections.List as ____KtList

public object MyIconPack

private var __Icons: ____KtList<ImageVector>? = null

public val MyIconPack.Icons: ____KtList<ImageVector>
  get() {
    if (__Icons != null) {
      return __Icons!!
    }
    __Icons= listOf(EditCalendar, NotificationActive)
    return __Icons!!
  }
