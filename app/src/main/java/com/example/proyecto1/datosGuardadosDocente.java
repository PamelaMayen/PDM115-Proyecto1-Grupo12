package com.example.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class datosGuardadosDocente extends AppCompatActivity {

    TextView txtView;
    Button btnRegresar, btnActualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_guardados_docente);
        txtView = findViewById(R.id.txtDatosGuardadosDocente);

        String datos = getIntent().getStringExtra("txtNombre");
        txtView.setText(datos);
        Toast.makeText(datosGuardadosDocente.this, "Datos agregados exitósamente.", Toast.LENGTH_LONG).show();
        btnRegresar = findViewById(R.id.btnRegresarDatosDocente);
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(datosGuardadosDocente.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnActualizar = findViewById(R.id.btnActualizarDatosGuardados);
        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(datosGuardadosDocente.this, actualizarDocente.class);
                intent.putExtra("txtNombre", txtView.getText().toString());
                startActivity(intent);
            }
        });
    }
}