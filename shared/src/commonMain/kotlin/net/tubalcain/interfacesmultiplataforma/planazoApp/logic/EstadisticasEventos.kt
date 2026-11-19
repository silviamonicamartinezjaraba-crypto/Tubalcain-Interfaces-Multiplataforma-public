package net.tubalcain.interfacesmultiplataforma.planazoApp.logic

import net.tubalcain.interfacesmultiplataforma.planazoApp.model.Evento

/**
 * Cuenta cuántos eventos pertenecen a una categoría determinada.
 *
 * Si la categoría indicada es `"Todos"`, devuelve el número total de eventos
 * de la lista. Para cualquier otra categoría, devuelve únicamente el número de
 * eventos cuya propiedad [Evento.categoria] coincide con [categoria].
 *
 * @param eventos Lista de eventos sobre la que se realiza el conteo.
 * @param categoria Nombre de la categoría a consultar, o `"Todos"` para contar todos los eventos.
 * @return Cantidad de eventos correspondientes a la categoría solicitada.
 */
fun contarEventosPorCategoria(
    eventos: List<Evento>,
    categoria: String
): Int {
    return if (categoria == "Todos") {
        eventos.size
    } else {
        eventos.count { evento ->
            evento.categoria == categoria
        }
    }
}
