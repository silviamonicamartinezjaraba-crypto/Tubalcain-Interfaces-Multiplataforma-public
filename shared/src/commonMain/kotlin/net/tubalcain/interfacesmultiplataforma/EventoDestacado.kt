package net.tubalcain.interfacesmultiplataforma

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

fun EventoDestacado(
    evento: Evento,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val tarjeta = Color(0x261500)
    val naranja = Color(0xFF9900)

    Card(
        modifier = modifier
            .widthIn(max = 800.dp)
            .fillMaxWidth(),
        onClick = onClick,
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

            Text(
                text = "›",
                color = naranja,
                fontSize = 30.sp
            )
        }
        Button(
            onClick = {
                onClick()
            },
            enabled = true,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Ver evento",
                fontSize = 16.sp
            )
        }
    }

}

