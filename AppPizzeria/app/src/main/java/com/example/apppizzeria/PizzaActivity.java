package com.example.apppizzeria;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.apppizzeria.modelo.entidad.Pizza;
import com.example.apppizzeria.modelo.entidad.Usuario;
import com.example.apppizzeria.modelo.negocio.GestorPizza;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

public class PizzaActivity extends AppCompatActivity {
    private RadioGroup radioGroupTamano;
    private CheckBox checkBoxPepperoni, checkBoxJamon, checkBoxAceitunas, checkBoxQueso;
    private Button botonCalcularPrecio;
    private RadioButton tamanoPeque;
    private RadioButton tamanoMedio;
    private RadioButton tamanoGrande;
    private TextView error;
    private EditText userName,direccion;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzza);
        Usuario usuario = (Usuario) getIntent().getSerializableExtra("usuario");
        Log.d("PizzaActivity", "Usuario: " + usuario);

        GestorPizza gp = new GestorPizza();

        radioGroupTamano = findViewById(R.id.tamano);
        checkBoxPepperoni = findViewById(R.id.pepperoni);
        checkBoxAceitunas = findViewById(R.id.aceitunas);
        checkBoxJamon = findViewById(R.id.jamon);
        checkBoxQueso = findViewById(R.id.queso);
        botonCalcularPrecio = findViewById(R.id.precio);
        tamanoPeque = findViewById(R.id.pequena);
        tamanoMedio = findViewById(R.id.mediana);
        tamanoGrande = findViewById(R.id.grande);
        error = findViewById(R.id.textViewError);
        userName = findViewById((R.id.userName));
        direccion = findViewById((R.id.direccion));

        userName.setText(usuario.getNombre());
        direccion.setText((usuario.getDireccion()));

        botonCalcularPrecio.setOnClickListener(view -> {
            String tamanio = null;
            if (tamanoPeque.isChecked()) {
                tamanio = "pequeña";
            } else if (tamanoMedio.isChecked()) {
                tamanio = "mediano";
            } else if (tamanoGrande.isChecked()) {
                tamanio = "grande";
            }

            if (tamanio == null) {
                error.setText("Por favor, selecciona un tamaño.");
                return;
            }

            List<String> listaIngredientes = new ArrayList<>();
            if (checkBoxAceitunas.isChecked()) {
                listaIngredientes.add("Aceitunas");
            }

            if (checkBoxJamon.isChecked()) {
                listaIngredientes.add("Jamon");
            }

            if (checkBoxPepperoni.isChecked()) {
                listaIngredientes.add("Pepperoni");
            }

            if (checkBoxQueso.isChecked()) {
                listaIngredientes.add("Queso");
            }

            if (listaIngredientes.size() == 0) {
                error.setText("Por favor, selecciona ingredientes");
                return;

            }

            Pizza pizza = gp.crearPizza(tamanio, listaIngredientes);
            usuario.setPizza(pizza);
            Log.i("PizzaActivity", "Pizza: " + pizza);
            Intent intent = new Intent(PizzaActivity.this,ResumenActivity.class);
            intent.putExtra("usuario",usuario);
            startActivity(intent);

        });

    }
}


