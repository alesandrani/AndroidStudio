package com.example.apppizzeria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.apppizzeria.modelo.dao.DaoUsuarioArray;
import com.example.apppizzeria.modelo.entidad.Usuario;
import com.example.apppizzeria.modelo.negocio.GestorUsuario;

public class LoginActivity extends AppCompatActivity {
    private EditText etNombre, etPassword;
    private TextView tvError;
    private Button btnValidar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        GestorUsuario gu = new GestorUsuario();

        etNombre = findViewById(R.id.nombreUsuario);
        etPassword = findViewById(R.id.passwordUsuario);
        tvError = findViewById(R.id.tvError);
        btnValidar = findViewById(R.id.botonValidar);

        btnValidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = etNombre.getText().toString();
                String password = etPassword.getText().toString();

                Usuario usuarioAValidar = new Usuario(nombre,password);

                Usuario usuarioValidado = gu.validar(usuarioAValidar);

                if (usuarioValidado != null) {
                    Intent intent = new Intent(LoginActivity.this, PizzaActivity.class);
                    intent.putExtra("usuario", usuarioValidado);
                    startActivity(intent);
                } else {
                    tvError.setVisibility(View.VISIBLE);
                    tvError.setText("Usuario o contraseña incorrectos");
                }
            }
        });
    }
}








