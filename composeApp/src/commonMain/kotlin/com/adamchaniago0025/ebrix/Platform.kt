package com.adamchaniago0025.ebrix

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform