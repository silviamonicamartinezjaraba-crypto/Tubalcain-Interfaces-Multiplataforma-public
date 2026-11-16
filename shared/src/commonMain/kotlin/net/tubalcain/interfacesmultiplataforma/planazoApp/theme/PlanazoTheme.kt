
package net.tubalcain.interfacesmultiplataforma.planazoApp.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val coloresPlanazo = darkColorScheme(
    primary = Color(0xFFB5A2FF),
    background = Color(0xFF101018),
    surface = Color(0xFF252535),
    onBackground = Color.White,
    onSurface = Color.White,
    onSurfaceVariant = Color.LightGray
)

@Composable
fun PlanazoTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = coloresPlanazo,
        content = content
    )
}
