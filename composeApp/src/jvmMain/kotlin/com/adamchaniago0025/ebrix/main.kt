package com.adamchaniago0025.ebrix

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Ebrix",
    ) {
        App()
    }
}