
package net.tubalcain.interfacesmultiplataforma.planazoApp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DatoRapidoHorizontal(
    etiqueta: String,
    valor: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = etiqueta,
            color = Color.White,
            style = MaterialTheme.typography.labelMedium
        )

        Text(
            text = valor,
            color = Color.White,
            style = MaterialTheme.typography.labelMedium
        )
    }
}
