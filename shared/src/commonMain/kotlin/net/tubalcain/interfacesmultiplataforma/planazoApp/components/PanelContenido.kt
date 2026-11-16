
package net.tubalcain.interfacesmultiplataforma.planazoApp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.tubalcain.interfacesmultiplataforma.planazoApp.theme.PlanazoTheme

@Composable
fun PanelContenido(
    titulo: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = titulo,
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleMedium
        )

        content()
    }
}


@Preview
@Composable
fun PanelContenidoPreview() {
    PlanazoTheme {
        Surface {
            PanelContenido(
                titulo = "Información del evento"
            ) {
                DatoRapidoVertical(
                    etiqueta = "Categoría",
                    valor = "Música"
                )

                DatoRapidoVertical(
                    etiqueta = "Horario",
                    valor = "Sábado · 20:00"
                )
            }
        }
    }
}
