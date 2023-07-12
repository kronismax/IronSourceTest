package com.ironsource.bootcounter.presentation.utils

import com.ironsource.bootcounter.data.model.BootTime

fun List<BootTime>.createTextForUi() = if (isEmpty()) {
    "No boots detected"
} else {
    withIndex().joinToString {
        "${it.index} - ${it.value}\n"
    }.removeSuffix("\n")
}

fun List<BootTime>.createTextForNotification() = if (isEmpty()) {
    "No boots detected"
} else {
    "todo"
}