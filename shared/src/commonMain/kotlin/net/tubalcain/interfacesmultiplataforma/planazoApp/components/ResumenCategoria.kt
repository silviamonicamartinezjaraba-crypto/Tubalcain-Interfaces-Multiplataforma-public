package net.tubalcain.interfacesmultiplataforma.planazoApp.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.tubalcain.interfacesmultiplataforma.planazoApp.theme.PlanazoTheme

/**
 * Muestra una tarjeta interactiva de resumen para una categoría de eventos.
 *
 * Presenta el nombre de la categoría, un texto auxiliar que indica si está
 * seleccionada y un contador con la cantidad de eventos disponibles. Utiliza los
 * colores de [MaterialTheme.colorScheme] para diferenciar visualmente el estado
 * seleccionado del no seleccionado e incluye semántica de accesibilidad para
 * lectores de pantalla.
 *
 * @param categoria Nombre de la categoría mostrada en el resumen.
 * @param cantidad Número total de eventos asociados a la categoría.
 * @param seleccionada Indica si la categoría corresponde al filtro activo.
 * @param onClick Acción que se ejecuta al pulsar la tarjeta para aplicar el filtro.
 * @param modifier Modificador de Compose aplicado al contenedor del componente.
 */
@Composable
fun ResumenCategoria(
    categoria: String,
    cantidad: Int,
    seleccionada: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val colorFondo by animateColorAsState(
        targetValue = if (seleccionada) {
            MaterialTheme.colorScheme.primaryContainer
        } else {
            MaterialTheme.colorScheme.background
        },
        label = "resumenCategoriaFondo"
    )

    val colorBorde by animateColorAsState(
        targetValue = if (seleccionada) {
            MaterialTheme.colorScheme.primary
        } else {
            MaterialTheme.colorScheme.outline.copy(alpha = 0.4f)
        },
        label = "resumenCategoriaBorde"
    )

    val grosorBorde = if (seleccionada) 2.dp else 1.dp

    val colorTitulo = if (seleccionada) {
        MaterialTheme.colorScheme.onPrimaryContainer
    } else {
        MaterialTheme.colorScheme.onSurface
    }

    val colorSubtitulo = if (seleccionada) {
        MaterialTheme.colorScheme.primary
    } else {
        MaterialTheme.colorScheme.onSurfaceVariant
    }

    val colorFondoContador = if (seleccionada) {
        MaterialTheme.colorScheme.primary
    } else {
        MaterialTheme.colorScheme.surface
    }

    val colorTextoContador = if (seleccionada) {
        MaterialTheme.colorScheme.onPrimary
    } else {
        MaterialTheme.colorScheme.onSurface
    }

    val textoEventos = if (cantidad == 1) "evento" else "eventos"

    Card(
        onClick = onClick,
        modifier = modifier
            .defaultMinSize(minHeight = 64.dp)
            .semantics(mergeDescendants = true) {
                selected = seleccionada
                stateDescription = if (seleccionada) {
                    "Categoría seleccionada"
                } else {
                    "Categoría no seleccionada"
                }
                contentDescription = "$categoria, $cantidad $textoEventos"
            },
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(grosorBorde, colorBorde),
        colors = CardDefaults.cardColors(
            containerColor = colorFondo
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(
                    text = categoria,
                    color = colorTitulo,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = if (seleccionada) {
                        "categoría seleccionada"
                    } else {
                        "ver eventos"
                    },
                    color = colorSubtitulo,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Box(
                modifier = Modifier
                    .defaultMinSize(minWidth = 32.dp, minHeight = 32.dp)
                    .background(
                        color = colorFondoContador,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = cantidad.toString(),
                    color = colorTextoContador,
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview
@Composable
fun ResumenCategoriaPreview() {
    PlanazoTheme {
        Surface {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                ResumenCategoria(
                    categoria = "Todos",
                    cantidad = 5,
                    seleccionada = true,
                    onClick = {},
                    modifier = Modifier.weight(1f)
                )

                ResumenCategoria(
                    categoria = "Música",
                    cantidad = 2,
                    seleccionada = false,
                    onClick = {},
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}
