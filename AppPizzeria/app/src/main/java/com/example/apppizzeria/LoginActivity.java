package com.example.apppizzeria;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.apppizzeria.modelo.dao.DaoUsuarioArray;
import com.example.apppizzeria.modelo.entidad.Usuario;
import com.example.apppizzeria.modelo.negocio.GestorUsuario;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final String ERROR_KEY = "error_mensaje";
    GestorUsuario gu = new GestorUsuario();
    private EditText etNombre, etPassword;
    private TextView tvError;
    private Button btnValidar;
    private String errorMensaje = "";
    private Button btnRegistrar;

    private final ActivityResultLauncher<Intent> registerLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Intent data = result.getData();

                    // Obtener los datos enviados desde RegisterActivity
                    Usuario nuevoUsuario = (Usuario)data.getSerializableExtra("nuevoUsuario");

                    // Guardar en el array de usuarios
                    boolean ok = gu.registrar(nuevoUsuario);

                    // Mostrar en los EditText
                    if(ok){
                        etNombre.setText(nuevoUsuario.getNombre());
                        etPassword.setText(nuevoUsuario.getPassword());
                    }
                }
            });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Log.d(TAG, "onCreate activo");
       // GestorUsuario gu = new GestorUsuario();

        etNombre = findViewById(R.id.nombreUsuario);
        etPassword = findViewById(R.id.passwordUsuario);
        tvError = findViewById(R.id.tvError);
        btnValidar = findViewById(R.id.botonValidar);
        btnRegistrar = findViewById(R.id.botonRegistrar);

        if (savedInstanceState != null) {
            errorMensaje = savedInstanceState.getString(ERROR_KEY, "");
            if (!errorMensaje.isEmpty()) {
                tvError.setVisibility(View.VISIBLE);
                tvError.setText(errorMensaje);
            }
        }
    }
        @Override
        protected void onStart() {
            super.onStart();
            Log.d(TAG, "onStart activo");

        btnValidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // GestorUsuario gu = new GestorUsuario();
                String nombre = etNombre.getText().toString();
                String password = etPassword.getText().toString();

                Usuario usuarioAValidar = new Usuario(nombre,password);

                Usuario usuarioValidado = gu.validar(usuarioAValidar);

                if (usuarioValidado != null) {
                    Intent intent = new Intent(LoginActivity.this, PizzaActivity.class);
                    intent.putExtra("usuario", usuarioValidado);
                    startActivity(intent);
                } else {
                    errorMensaje = "Usuario o contraseña incorrectos";
                    tvError.setVisibility(View.VISIBLE);
                    tvError.setText(errorMensaje);
                }
            }
        });
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
               registerLauncher.launch(intent);
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume activo");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause activo");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop activo");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy activo");
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState activo");

        // Guardar el mensaje de error
        outState.putString(ERROR_KEY, errorMensaje);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState activo");

        // Restaurar el mensaje de error
        errorMensaje = savedInstanceState.getString(ERROR_KEY, "");
        if (!errorMensaje.isEmpty()) {
            tvError.setVisibility(View.VISIBLE);
            tvError.setText(errorMensaje);
        }
    }
}








