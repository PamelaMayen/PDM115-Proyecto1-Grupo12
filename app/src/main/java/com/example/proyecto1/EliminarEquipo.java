package com.example.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.HashSet;
import java.util.List;

@SuppressLint("NewApi")
public class EliminarEquipo extends AppCompatActivity {

    ControlBD helper;
    EditText editCodigo;
    ListView listView;
    static List<Equipo> listaEquipo;
    static List<String> lista;
    private final String urlLocal="https://192.168.1.20/Servicios/eliminar_equipo.php";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_equipo);
        helper =new ControlBD(this);
        editCodigo=(EditText) findViewById(R.id.editCodigo);
        listView = (ListView) findViewById(R.id.listView1);
    }

    public void eliminarEquipo(View v){
        String regEliminadas;
        Equipo eq = new Equipo();
        eq.setCodigoEquipo(editCodigo.getText().toString());
        helper.abrir();
        regEliminadas=helper.eliminar(eq);
        helper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }

    public void servicioPHP(View v) {
        String codigo = editCodigo.getText().toString();
        String url = "";
        switch (v.getId()) {
            case R.id.eliminarPHP:
                // it was the first button
                url = urlLocal + "?CODIGOEQUIPO="+codigo;
                break;
        }
        String equipoLocal = ControlServicio.obtenerRespuestaPeticion(url, this);
        try {

            listaEquipo.addAll(ControlServicio.obtenerEquipoLocal(equipoLocal, this));
            eliminarElementosDuplicados();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void eliminarElementosDuplicados() {
        HashSet<Equipo> conjuntoEquipo = new HashSet<Equipo>();
        conjuntoEquipo.addAll(listaEquipo);
        listaEquipo.clear();
        listaEquipo.addAll(conjuntoEquipo);
        HashSet<String> conjunto = new HashSet<String>();
        conjunto.addAll(lista);
        lista.clear();
        lista.addAll(conjunto);
    }

    public void limpiarTexto(View v) {
        editCodigo.setText("");
    }

    public void regresar (View view){
        Intent regresar = new Intent(this, CrudLibro.class);
        startActivity(regresar);

    }
}