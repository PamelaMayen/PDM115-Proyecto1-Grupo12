package com.example.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AgregarTipoProducto extends Activity {

    ControlBD helper;
    EditText editNombreTipo;
    EditText editTipoCate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_tipo_producto);
        helper = new ControlBD(this);
        editNombreTipo=(EditText)findViewById(R.id.editNombreTipo);
        editTipoCate=(EditText)findViewById(R.id.editTipoCate);
    }

    public void insertar(View v){
        String nom=editNombreTipo.getText().toString();
        Integer tipo=Integer.parseInt(editTipoCate.getText().toString());
        String regInsertados;
        TipoProducto tipoProducto= new TipoProducto();
        tipoProducto.setTipoProductoId(0);
        tipoProducto.setNombreTipoProducto(nom);
        tipoProducto.setCategoriaId(tipo);
        helper.abrir();
        regInsertados=helper.insertar(tipoProducto);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editNombreTipo.setText("");
        editTipoCate.setText("");
    }
    public void regresar (View view){
        Intent regresar = new Intent(this, ActivityMenu.class);
        startActivity(regresar);

    }

}