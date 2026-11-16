package net.tubalcain.interfacesmultiplataforma

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import net.tubalcain.interfacesmultiplataforma.planazoApp.screens.PlanazoApp

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport {
        PlanazoApp()
    }
}