package net.tubalcain.interfacesmultiplataforma.planazoApp.logic

import net.tubalcain.interfacesmultiplataforma.planazoApp.model.Evento
import kotlin.test.Test
import kotlin.test.assertEquals

class EstadisticasEventosTest {

    private val eventos = listOf(
        Evento(
            "Festival Urbano", "Música",
            "Sábado · 20:00", "🎤", "Festival de música urbana."
        ),
        Evento(
            "Torneo EA FC", "Gaming",
            "Viernes · 17:00", "🎮", "Competición de fútbol virtual."
        ),
        Evento(
            "Noche de Streamers", "Creadores",
            "Viernes · 19:30", "📺", "Encuentro de creadores de contenido."
        ),
        Evento(
            "Batalla de DJs", "Música",
            "Sábado · 22:00", "🎧", "Sesión de música y DJs."
        ),
        Evento(
            "Torneo Minecraft", "Gaming",
            "Domingo · 18:00", "🏗️", "Retos de construcción por equipos."
        )
    )

    @Test
    fun contarTodosDevuelveElTotalDeEventos() {
        val total = contarEventosPorCategoria(eventos, "Todos")

        assertEquals(5, total)
    }

    @Test
    fun contarCategoriaConResultados() {
        val cantidadMusica = contarEventosPorCategoria(eventos, "Música")
        val cantidadCreadores = contarEventosPorCategoria(eventos, "Creadores")

        assertEquals(2, cantidadMusica)
        assertEquals(1, cantidadCreadores)
    }

    @Test
    fun contarCategoriaSinResultados() {
        val cantidadDeportes = contarEventosPorCategoria(eventos, "Deportes")

        assertEquals(0, cantidadDeportes)
    }

    @Test
    fun contarEnListaVaciaDevuelveCero() {
        assertEquals(0, contarEventosPorCategoria(emptyList(), "Todos"))
        assertEquals(0, contarEventosPorCategoria(emptyList(), "Música"))
    }
}
