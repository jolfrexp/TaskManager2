package com.example.administradordetareas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InicioSesion extends AppCompatActivity {

    private EditText name,password;
    private Button btnInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inicio_sesion);


        name = findViewById(R.id.inputNameInit);
        password = findViewById(R.id.inputPasswordInit);
        btnInicio = findViewById(R.id.btnLogin);

        SharedPreferences sharedPreferences = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
        String savedUsername = sharedPreferences.getString("username", "");
        String savedPassword = sharedPreferences.getString("password", "");
        String nombre = name.getText().toString();
        String contrase = password.getText().toString();

        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = name.getText().toString();
                String contrase = password.getText().toString();
                if(nombre.equals(savedUsername) && contrase.equals(savedPassword)) {
                    Toast.makeText(InicioSesion.this, "Ingreso exitoso", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(InicioSesion.this,Home.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(InicioSesion.this, "Las credenciales no coinciden", Toast.LENGTH_SHORT).show();
                    Toast.makeText(InicioSesion.this, nombre, Toast.LENGTH_SHORT).show();
                    Toast.makeText(InicioSesion.this, savedUsername, Toast.LENGTH_SHORT).show();


                }
            }
        });




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}