package br.edu.ifsp.dmo1.conversortemperatura.model

interface ConversorTemperatura {
    fun converterParaCelsius(temperatura: Double):Double
    fun converterParaFahrenheit(temperatura: Double):Double
    fun converterParaKelvin(temperatura: Double):Double

    fun getScale():String

}