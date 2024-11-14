package br.edu.ifsp.dmo1.conversortemperatura.model

object CelsiusStrategy: ConversorTemperatura {
    override fun converterParaCelsius(temperatura: Double): Double {
        return temperatura
    }

    override fun converterParaFahrenheit(temperatura: Double): Double {
        return (temperatura - 32)/1.8
    }

    override fun converterParaKelvin(temperatura: Double): Double {
        return temperatura + 273.15
    }

    override fun getScale(): String {
        return "ºC"
    }
}