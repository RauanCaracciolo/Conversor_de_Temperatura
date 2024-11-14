package br.edu.ifsp.dmo1.conversortemperatura.model

object FahrenheitStrategy: ConversorTemperatura {


    override fun converterParaCelsius(temperatura: Double): Double {
        return 1.8 * temperatura + 32
    }

    override fun converterParaFahrenheit(temperatura: Double): Double {
        return temperatura
    }

    override fun converterParaKelvin(temperatura: Double): Double {
       return (temperatura + 459.67) / 1.8
    }

    override fun getScale(): String {
        return "ºF"
    }
}