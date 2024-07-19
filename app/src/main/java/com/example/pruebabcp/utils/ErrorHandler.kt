package com.example.pruebabcp.utils

import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.net.ssl.SSLException

object ErrorHandler {
    fun handle(error: Throwable): String {
        return when (error) {
            is IOException -> {
                when (error) {
                    is SocketTimeoutException -> "La solicitud ha tardado demasiado tiempo en completarse. Inténtalo de nuevo más tarde."
                    is UnknownHostException -> "No hay conexión a Internet. Por favor, revisa la configuración de tu red."
                    is SSLException -> "Se ha producido un error de seguridad. Inténtalo de nuevo más tarde."
                    else -> "Error de red: Por favor, revisa tu conexión a Internet."
                }
            }
            is HttpException -> {
                when (error.code()) {
                    400 -> "Solicitud incorrecta: El servidor no pudo entender la solicitud."
                    401 -> "No autorizado: Por favor, revisa tus credenciales."
                    403 -> "Prohibido: No tienes permiso para acceder a este recurso."
                    404 -> "No encontrado: El recurso solicitado no pudo ser encontrado."
                    500 -> "Error interno del servidor: Se produjo un error en el servidor."
                    503 -> "Servicio no disponible: El servidor no puede manejar la solicitud en este momento."
                    else -> "Error HTTP: ${error.code()}"
                }
            }
            else -> "Error inesperado: ${error.localizedMessage ?: "Se ha producido un error inesperado."}"
        }
    }
}
