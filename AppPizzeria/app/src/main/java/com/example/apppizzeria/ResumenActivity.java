package com.example.apppizzeria;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.apppizzeria.modelo.entidad.Pizza;
import com.example.apppizzeria.modelo.entidad.Usuario;

public class ResumenActivity extends AppCompatActivity {
    private TextView textViewResumen;
    private TextView textViewPedidoProcesado;
    private TextView textViewUsuario;
    private TextView textViewResumen1;
    private TextView precioTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);
        textViewPedidoProcesado = findViewById(R.id.textViewResumen);
        textViewResumen1 = findViewById(R.id.textViewResumen1);
        textViewUsuario = findViewById(R.id.textViewUsuario);


        Usuario usuario = (Usuario)getIntent().getSerializableExtra("usuario");
        Log.d("ResumenActivity","Usuario: " + usuario);
        textViewResumen = findViewById(R.id.textViewResumen);
        textViewUsuario.setText("Usuario: " + usuario.getNombre());
        textViewResumen1.setText("Resumen del pedido: " + usuario.getPizza());


        Log.d("ResumenActivity", "Usuario: " + usuario + ", Pizza: " + usuario.getPizza()  );

    }
}