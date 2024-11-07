package com.example.mycalculadora;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

        Button bSuma = findViewById(R.id.sumar);
        Button bResta = findViewById(R.id.restar);
        Button bBorrar = findViewById(R.id.borrar);
        Button bpPotencia = findViewById(R.id.potencia);
        Button bDividir = findViewById(R.id.dividir);
        Button bMultipl = findViewById(R.id.multiply);
        EditText textoNumero1 = findViewById(R.id.editText1);
        EditText textoNumero2 = findViewById(R.id.editText2);
        TextView resultadoCasilla = findViewById(R.id.textViewResultado);

        //Boton sumar
        bSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = textoNumero1.getText().toString();
                double n1 = 0;
                double n2 = 0;
                if(!s1.isEmpty()){
                    n1 = Double.parseDouble(s1);
                }
                String s2 = textoNumero2.getText().toString();
                if(!s2.isEmpty()){
                    n2 = Double.parseDouble(s2);
                }
                double resultado = n1 + n2;
               resultadoCasilla.setText(String.valueOf(resultado));
            }
        });

        //Boton resta
        bResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = textoNumero1.getText().toString();
                double n1 = 0;
                double n2 = 0;
                if(!s1.isEmpty()){
                    n1 = Double.parseDouble(s1);
                }
                String s2 = textoNumero2.getText().toString();
                if(!s2.isEmpty()){
                    n2 = Double.parseDouble(s2);
                }
                double resultado = n1 - n2;
                resultadoCasilla.setText(String.valueOf(resultado));
            }
        });
        //Boton multiplicacion
        bMultipl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = textoNumero1.getText().toString();
                double n1 = 0;
                double n2 = 0;
                if(!s1.isEmpty()){
                    n1 = Double.parseDouble(s1);
                }
                String s2 = textoNumero2.getText().toString();
                if(!s2.isEmpty()){
                    n2 = Double.parseDouble(s2);
                }
                double resultado = n1 * n2;
                resultadoCasilla.setText(String.valueOf(resultado));
            }
        });
        //Boton division
        bDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = textoNumero1.getText().toString();
                double n1 = 0;
                double n2 = 0;
                if(!s1.isEmpty()){
                    n1 = Double.parseDouble(s1);
                }
                String s2 = textoNumero2.getText().toString();
                if(!s2.isEmpty()){
                    n2 = Double.parseDouble(s2);
                }
                double resultado = n1 / n2;
                resultadoCasilla.setText(String.valueOf(resultado));
            }
        });
        //Boton potencia
        bpPotencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = textoNumero1.getText().toString();
                double n1 = 0;
                double n2 = 0;
                if(!s1.isEmpty()){
                    n1 = Double.parseDouble(s1);
                }
                String s2 = textoNumero2.getText().toString();
                if(!s2.isEmpty()){
                    n2 = Double.parseDouble(s2);
                }
                double resultado =Math.pow(n1, n2);
                resultadoCasilla.setText(String.valueOf(resultado));
            }
        });
        //Borrar
        bBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textoNumero1.setText("");
                textoNumero2.setText("");
                resultadoCasilla.setText("");
            }
        });




    }
}