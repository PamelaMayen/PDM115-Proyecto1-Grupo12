package com.example.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.http.RequestQueue;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.annotation.SuppressLint;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("NewApi")
public class ActivityLogin extends AppCompatActivity {

    ControlBD helper;
    private EditText editUsuario, editContrasena;
    static List<Usuario> listaUsuario;
    private final String urlLocal="https://192.168.1.20/Servicios/login.php";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        helper = new ControlBD(this);
        listaUsuario=new ArrayList<Usuario>();
        editUsuario=(EditText) findViewById(R.id.editUsuario);
        editContrasena=(EditText) findViewById(R.id.editContrasena);
    }

    public void login(View v) {
        helper.abrir();
        Usuario usuario = helper.login(editUsuario.getText().toString(), editContrasena.getText().toString());
        if (usuario == null) {
            Toast.makeText(this, "Usuario " +
                    editUsuario.getText().toString() +
                    " no encontrado", Toast.LENGTH_LONG).show();
        } else {
            // Toast.makeText(this, "Usuario " +editUsuario.getText().toString() +" encontrado", Toast.LENGTH_LONG).show();
            Intent regresar = new Intent(this, ActivityMenu.class);
            startActivity(regresar);
        }
        helper.cerrar();

    }

    public void servicioPHP(View v){
        String usuario=editUsuario.getText().toString();
        String contra=editContrasena.getText().toString();
        String url = "";
        switch (v.getId()){
            case R.id.editIniciarPhp:
                url = urlLocal+"?USUARIO="+usuario+"?CONTRASENA="+contra;
                break;
        }
        String usuarioExterna = ControlServicio.obtenerRespuestaPeticion(url, this);
        try {
            listaUsuario.addAll(ControlServicio.obtenerUsuario(usuarioExterna, this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}