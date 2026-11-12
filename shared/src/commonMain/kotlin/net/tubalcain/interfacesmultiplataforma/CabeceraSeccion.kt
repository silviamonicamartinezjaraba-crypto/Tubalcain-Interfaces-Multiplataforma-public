package net.tubalcain.interfacesmultiplataforma

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
        /**
         * Esto es un componente reutilizable que muestra un título y subtítulo por defecto
         * tanto en la lista como dentro de detalles
         */
fun CabeceraSeccion(
    titulo: String,
    subtitulo: String = "",
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        Text(
            text = titulo,
            color = Color.White
        )
        if (subtitulo.isNotEmpty()){
            Text(
                text = subtitulo,
                color = Color.LightGray
            )
        }
    }
}
