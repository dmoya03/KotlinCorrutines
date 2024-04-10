package com.example.kotlincorrutinesmvvm.Model
// Repository.kt
import kotlinx.coroutines.delay

class Repository {
    suspend fun fetchData(): DataModel {
        // Simulación de una solicitud de red que toma tiempo
        delay(2000)
        return DataModel("Datos obtenidos correctamente")
    }
}
