package br.edu.ifsp.dmo1.conversortemperatura.model

object KelvinStrategy:ConversorTemperatura {
    override fun converterParaCelsius(temperatura: Double): Double {
        return temperatura - 273.15
    }

    override fun converterParaFahrenheit(temperatura: Double): Double {
        return 1.8 * (temperatura - 273) + 32
    }

    override fun converterParaKelvin(temperatura: Double): Double {
        return temperatura
    }

    override fun getScale(): String {
        return "ºK"
    }
}