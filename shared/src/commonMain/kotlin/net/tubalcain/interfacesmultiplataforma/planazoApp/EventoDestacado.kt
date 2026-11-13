package net.tubalcain.interfacesmultiplataforma.planazoApp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
/**
 * Esto es un componente reutilizable que muestra un evento destacado
 * mediante un botón con onClick que comunica con PlanazoApp
 * */
fun EventoDestacado(
    evento: Evento,
    onClick: () -> Unit,
    textoBoton: String = "Ver evento",
    modifier: Modifier = Modifier
) {
    val tarjeta = Color(0xFF261500)
    val naranja = Color(0xFFFF9900)

    Card(
        modifier = modifier
            .widthIn(max = 800.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(
            containerColor = tarjeta
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = evento.emoji,
                fontSize = 36.sp
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = evento.nombre,
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = evento.fecha,
                    color = Color.LightGray
                )

                Text(
                    text = evento.descripcion,
                    color = naranja
                )
            }
        }
        // Botón que comunica con PlanazoApp y muestra el evento destacado
        Button(
            onClick = {
                onClick()
            },
            enabled = true,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = textoBoton,
                fontSize = 18.sp
            )
        }
    }

}

