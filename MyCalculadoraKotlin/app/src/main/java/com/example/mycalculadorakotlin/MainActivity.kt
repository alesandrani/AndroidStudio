package com.example.mycalculadorakotlin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val bSuma = findViewById<Button>(R.id.sumar);
        val bResta = findViewById<Button>(R.id.restar);
        val bBorrar =findViewById<Button>(R.id.borrar);
        val bpPotencia =findViewById<Button>(R.id.potencia);
        val bDividir = findViewById<Button>(R.id.dividir);
        val bMultipl = findViewById<Button>(R.id.multiply);
        val textoNumero1 = findViewById<EditText>(R.id.editText1);
        val textoNumero2 = findViewById<EditText>(R.id.editText2);
        val resultadoCasilla = findViewById<TextView>(R.id.textViewResultado);


        bSuma.setOnClickListener {
            val s1 = textoNumero1.text.toString()
            val n1 = if (s1.isNotEmpty()) s1.toDouble() else 0.0

            val s2 = textoNumero2.text.toString()
            val n2 = if (s2.isNotEmpty()) s2.toDouble() else 0.0

            val resultado = n1 + n2
            resultadoCasilla.text = resultado.toString()
        }
        bResta.setOnClickListener{
            val s1 = textoNumero1.text.toString()
            val n1 = if (s1.isNotEmpty()) s1.toDouble() else 0.0

            val s2 = textoNumero2.text.toString()
            val n2 = if (s2.isNotEmpty()) s2.toDouble() else 0.0

            val resultado = n1 - n2
            resultadoCasilla.text = resultado.toString()
        }
        bMultipl.setOnClickListener{
            val s1 = textoNumero1.text.toString()
            val n1 = if (s1.isNotEmpty()) s1.toDouble() else 0.0

            val s2 = textoNumero2.text.toString()
            val n2 = if (s2.isNotEmpty()) s2.toDouble() else 0.0

            val resultado = n1 * n2
            resultadoCasilla.text = resultado.toString()
        }
        bDividir.setOnClickListener{
            val s1 = textoNumero1.text.toString()
            val n1 = if (s1.isNotEmpty()) s1.toDouble() else 0.0

            val s2 = textoNumero2.text.toString()
            val n2 = if (s2.isNotEmpty()) s2.toDouble() else 0.0

            val resultado = n1 / n2
            resultadoCasilla.text = resultado.toString()
        }
        bpPotencia.setOnClickListener{
            val s1 = textoNumero1.text.toString()
            val n1 = if (s1.isNotEmpty()) s1.toDouble() else 0.0

            val s2 = textoNumero2.text.toString()
            val n2 = if (s2.isNotEmpty()) s2.toDouble() else 0.0

            val resultado = n1.pow(n2)
            resultadoCasilla.text = resultado.toString()
        }
        bBorrar.setOnClickListener{
            textoNumero1.text.clear()
            textoNumero2.text.clear()
            resultadoCasilla.text = ""
        }
        }
    }
