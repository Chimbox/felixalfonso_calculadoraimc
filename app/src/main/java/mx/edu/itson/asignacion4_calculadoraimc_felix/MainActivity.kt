package mx.edu.itson.asignacion4_calculadoraimc_felix

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var peso: Float = 0f
    var altura: Float = 0f

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etPeso: EditText = findViewById(R.id.etPeso)
        val etAltura: EditText = findViewById(R.id.etAltura)
        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        val tvImc: TextView = findViewById(R.id.tvImc)
        val tvRange: TextView = findViewById(R.id.tvRange)

        btnCalcular.setOnClickListener {
            peso = etPeso.text.toString().toFloat()
            altura = etAltura.text.toString().toFloat()

            var imc: Float = peso / (altura * altura)

            tvImc.setText(imc.toString())

            if (imc < 18.5) {
                tvRange.setText("Bajo peso")
                tvRange.setBackgroundResource(R.color.colorYellow)
            } else if (imc < 25) {
                tvRange.setText("Normal")
                tvRange.setBackgroundResource(R.color.colorGreen)
            } else if (imc < 30) {
                tvRange.setText("Sobrepeso")
                tvRange.setBackgroundResource(R.color.colorGreenish)
            } else if (imc < 35) {
                tvRange.setText("Obesidad grado 1")
                tvRange.setBackgroundResource(R.color.colorOrange)
            } else if (imc < 40) {
                tvRange.setText("Obesidad grado 2")
                tvRange.setBackgroundResource(R.color.colorRed)
                tvRange.setTextColor(Color.WHITE)
            } else {
                tvRange.setText("Obesidad grado 3")
                tvRange.setBackgroundResource(R.color.colorBrown)
                tvRange.setTextColor(Color.WHITE)
            }
        }
    }
}