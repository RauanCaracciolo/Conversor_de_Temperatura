package br.edu.ifsp.dmo1.conversortemperatura.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.ifsp.dmo1.conversortemperatura.R
import br.edu.ifsp.dmo1.conversortemperatura.databinding.ActivityMainBinding
import br.edu.ifsp.dmo1.conversortemperatura.model.CelsiusStrategy
import br.edu.ifsp.dmo1.conversortemperatura.model.ConversorTemperatura
import br.edu.ifsp.dmo1.conversortemperatura.model.FahrenheitStrategy
import br.edu.ifsp.dmo1.conversortemperatura.model.KelvinStrategy
import com.google.android.material.circularreveal.CircularRevealHelper.Strategy

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var converterStrategy: ConversorTemperatura

    private var selectedItem: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
         setClickListener()
         setSpinnerListener()
    }

    private fun setClickListener(){
        binding.btnCelsius.setOnClickListener{
            handleConversion(CelsiusStrategy)
        }
        binding.btnFahrenheit.setOnClickListener{
            handleConversion(FahrenheitStrategy)
        }
        binding.btnKelvin.setOnClickListener{
            handleConversion(KelvinStrategy)
        }
    }
    private fun setSpinnerListener(){
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                selectedItem = parent.getItemAtPosition(position).toString()
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }
        }
    private fun readTemperature(): Double{
        return try{
            binding.edittextTemperature.text.toString().toDouble()
        }catch(e: NumberFormatException){
            throw NumberFormatException("Erro de input")
        }
    }
    @SuppressLint("DefaultLocale")
    private fun handleConversion(strategy: ConversorTemperatura){
        converterStrategy = strategy
        try {
            val inputValue = readTemperature()
            if(selectedItem == "Celsius"){
                binding.textviewResultNumber.text = String.format(
                    "%.2f %s",
                    converterStrategy.converterParaCelsius(inputValue),
                    converterStrategy.getScale()
                )
            }else if(selectedItem == "Fahrenheit"){
                binding.textviewResultNumber.text = String.format(
                    "%.2f %s",
                    converterStrategy.converterParaFahrenheit(inputValue),
                    converterStrategy.getScale()
                )
            }else if(selectedItem == "Kelvin"){
                binding.textviewResultNumber.text = String.format(
                    "%.2f %s",
                    converterStrategy.converterParaKelvin(inputValue),
                    converterStrategy.getScale()
                )
            }
            if(this.converterStrategy is CelsiusStrategy){
                if(selectedItem == "Celsius"){
                binding.textviewResultMessage.text = getString(R.string.msgCtoC)
                }else if(selectedItem == "Fahrenheit"){
                    binding.textviewResultMessage.text = getString(R.string.msgFtoC)
                }else if(selectedItem == "Kelvin"){
                    binding.textviewResultMessage.text = getString(R.string.msgKtoC)
                }
            }else if(this.converterStrategy is FahrenheitStrategy){
                if(selectedItem == "Celsius"){
                    binding.textviewResultMessage.text = getString(R.string.msgCtoF)
                }else if(selectedItem == "Fahrenheit"){
                    binding.textviewResultMessage.text = getString(R.string.msgFtoF)
                }else if(selectedItem == "Kelvin") {
                    binding.textviewResultMessage.text = getString(R.string.msgKtoF)
                }
            }else if(this.converterStrategy is KelvinStrategy){
                if(selectedItem == "Celsius"){
                    binding.textviewResultMessage.text = getString(R.string.msgCtoK)
                }else if(selectedItem == "Fahrenheit"){
                    binding.textviewResultMessage.text = getString(R.string.msgFtoK)
                }else if(selectedItem == "Kelvin") {
                    binding.textviewResultMessage.text = getString(R.string.msgKtoK)
                }
            }
        }catch (e: Exception){
            Toast.makeText(this, getString(R.string.error_popup_notify), Toast.LENGTH_SHORT).show()
            Log.e("APP_DMO", e.stackTraceToString())
        }
    }
}