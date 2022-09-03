package com.holovenko.smart_devices_simulator.util

import kotlin.random.Random

fun getRandomNumberInRange(range: IntRange): Int {
    return Random.nextInt(range.first, range.last)
}