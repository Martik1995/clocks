package com.mmg.clocks.shared.utils

import android.annotation.SuppressLint

const val SEC = 1000L

@SuppressLint("DefaultLocale")
fun bindTimerText(h: Long, m: Long, s: Long): String {
    return String.format("%02d:%02d:%02d", h, m, s)
}

@SuppressLint("DefaultLocale")
fun addSecondToTimer(timer: String): String {
    val (h, m, s) = timer.split(":").map { it.toInt() }

    var newH = h
    var newM = m
    var newS = s + 1

    if (newS == 60) {
        newS = 0
        newM++
    }

    if (newM == 60) {
        newM = 0
        newH++
    }

    if (newH == 25) {
        newH = 0
    }

    return String.format("%02d:%02d:%02d", newH, newM, newS)
}