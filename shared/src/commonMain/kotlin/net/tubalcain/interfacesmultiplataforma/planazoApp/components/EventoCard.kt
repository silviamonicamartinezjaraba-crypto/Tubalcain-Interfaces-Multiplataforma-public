package net.tubalcain.interfacesmultiplataforma.planazoApp.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingToolbarDefaults.animationSpec
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
<<<<<<< HEAD
import androidx.compose.ui.text.LinkAnnotation
=======
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
>>>>>>> main
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.tubalcain.interfacesmultiplataforma.planazoApp.model.Evento

/**
 * Muestra una tarjeta con la información de un evento.
 *
 * Permite personalizar los colores y mostrar
 * u ocultar la descripción del evento.
 *
 * @param evento Evento que se mostrará.
 * @param onClick Acción al pulsar la tarjeta.
 * @param modifier Modificadores de Compose.
 * @param mostrarDescripcion Indica si se muestra la descripción.
 * @param colorFondo Color de fondo de la tarjeta.
 * @param colorCategoria Color del texto de la categoría.
 */

@Composable
fun EventoCard(
    evento: Evento,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    mostrarDescripcion: Boolean = false,
    modoCompacto: Boolean = false,
    esFavorito: Boolean = false,
    favoritoClick: () -> Unit = {},
    colorFondo: Color = Color(0xFF252535),
    colorCategoria: Color = Color(0xFFB5A2FF)
) {
    val morado = MaterialTheme.colorScheme.primary
    val colorFondoAnimado by animateColorAsState(
        targetValue = if (esFavorito) Color(0xFF4A3500) else colorFondo,
    )

    Card(
        modifier = modifier
            .widthIn(max = 850.dp)
            .fillMaxWidth()
<<<<<<< HEAD
            .animateContentSize(
                animationSpec = tween(1000)
            ),
=======
            .semantics {
                stateDescription =
                    "Evento: ${evento.nombre}, " +
                            "categoría: ${evento.categoria}"
            },
>>>>>>> main
        onClick = onClick,
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorFondoAnimado
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
                fontSize = 36.sp,
                modifier = Modifier.semantics {
                    contentDescription =
                        "Evento de categoría ${evento.categoria}"
                }
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = evento.nombre,
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                if (!modoCompacto){
                    Text(
                        text = evento.categoria,
                        color = colorCategoria
                    )
                    Text(
                        text = evento.fecha,
                        color = Color.LightGray
                    )
                }

                AnimatedVisibility(
                    visible = mostrarDescripcion
                ) {
                    Text(
                        text = evento.descripcion,
                        color = Color.LightGray,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
                androidx.compose.material3.TextButton(
                    onClick = favoritoClick,
                ) {
                    Text(
                        text = if (esFavorito) "★" else "☆",
                        color = if (esFavorito) Color.Magenta else Color.White,
                        fontSize = 26.sp
                    )
                }
            }

            Text(
                text = "›",
                color = morado,
                fontSize = 30.sp
            )
        }
    }
}
