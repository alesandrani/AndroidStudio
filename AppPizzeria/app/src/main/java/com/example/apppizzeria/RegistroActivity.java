package com.example.apppizzeria;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.apppizzeria.modelo.entidad.Usuario;

public class RegistroActivity extends AppCompatActivity {
    private EditText etNuevoNombre, etNuevoPassword,etNuevaDireccion;
    private Button btnRegistrarUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registro);
        etNuevoNombre = findViewById(R.id.etNuevoNombre);
        etNuevoPassword = findViewById(R.id.etNuevoPassword);
        btnRegistrarUsuario = findViewById(R.id.btnRegistrarUsuario);
        etNuevaDireccion = findViewById(R.id.etNuevaDireccion);
        btnRegistrarUsuario.setOnClickListener(view -> {
            String nuevoNombre = etNuevoNombre.getText().toString();
            String nuevoPassword = etNuevoPassword.getText().toString();
            String nuevaDireccion = etNuevaDireccion.getText().toString();
            if (!nuevoNombre.isEmpty() && !nuevoPassword.isEmpty()) {
                Usuario nuevoUsuario = new Usuario(nuevoPassword,nuevoNombre,nuevaDireccion);

                Intent intent = new Intent(RegistroActivity.this,LoginActivity.class);
                //intent.putExtra("nombre", nuevoNombre);
                //intent.putExtra("password", nuevoPassword);
                intent.putExtra("nuevoUsuario", nuevoUsuario);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        }
}
