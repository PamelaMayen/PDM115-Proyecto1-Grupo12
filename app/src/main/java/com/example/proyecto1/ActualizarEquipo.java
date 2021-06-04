package com.example.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@SuppressLint("NewApi")
public class ActualizarEquipo extends Activity {

    ControlBD helper;
    EditText generico;
    EditText docente;
    EditText estado;
    EditText usuario;
    EditText hora;
    EditText codigo;
    EditText fecha;
    ListView listView;
    static List<Equipo> listaEquipo;
    static List<String> lista;
    private final String urlLocal="https://192.168.1.20/Servicios/actualizar_equipo.php";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_equipo);
        helper = new ControlBD(this);
        generico= (EditText) findViewById(R.id.editGenerico);
        docente= (EditText) findViewById(R.id.editDocente);
        estado= (EditText) findViewById(R.id.editEstado);
        usuario= (EditText)findViewById(R.id.editUsuario);
        hora= (EditText)findViewById(R.id.editHora);
        codigo = (EditText)findViewById(R.id.editCodigo);
        fecha = (EditText)findViewById(R.id.editFecha);
        listView = (ListView) findViewById(R.id.listView1);
    }

    public void actualizar(View v){
        Equipo eq = new Equipo();
        eq.setEquipoId(0);
        eq.setEquipoGenericoId(generico.getText().toString());
        eq.setDocenteId(Integer.parseInt(docente.getText().toString()));
        eq.setEstadoEquipoId(Integer.parseInt(estado.getText().toString()));
        eq.setUsuario(usuario.getText().toString());
        eq.setHoraId(Integer.parseInt(hora.getText().toString()));
        eq.setCodigoEquipo(codigo.getText().toString());
        eq.setFechaAdquisicion(fecha.getText().toString());
        helper.abrir();
        String estado = helper.actualizar(eq);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }

    public void servicioPHP(View v) {
        String gene = generico.getText().toString();
        int doc=Integer.parseInt(docente.getText().toString());
        int est=Integer.parseInt(estado.getText().toString());
        String us=usuario.getText().toString();
        int hor=Integer.parseInt(hora.getText().toString());
        String cod = codigo.getText().toString();
        String fech = fecha.getText().toString();
        String url = "";
        switch (v.getId()) {
            case R.id.actualizarPHP:
                // it was the first button
                url = urlLocal + "?EQUIPOGENERICOID="+gene+"?DOCENTEID="+doc+"?ESTADOEQUIPOID="+est
                        +"?USUARIO="+us +"?HORAID="+hor+"?CODIGOEQUIPO="+cod+"?FECHAADQUISICION="+fech;
                break;
        }
        String equipoLocal = ControlServicio.obtenerRespuestaPeticion(url, this);
        try {

            listaEquipo.addAll(ControlServicio.obtenerEquipoLocal(equipoLocal, this));
            actualizarListView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void actualizarListView() {
        String dato = " ";
        lista.clear();
        for (int i = 0; i < listaEquipo.size(); i++) {
            dato = listaEquipo.get(i).getEquipoGenericoId()+" "+ listaEquipo.get(i).getDocenteId()+" "+
                    listaEquipo.get(i).getEstadoEquipoId()+" "+listaEquipo.get(i).getUsuario()+" " +
                    listaEquipo.get(i).getHoraId() + " " + listaEquipo.get(i).getCodigoEquipo()+" "+
                    listaEquipo.get(i).getFechaAdquisicion();
            lista.add(dato);
        }
        eliminarElementosDuplicados();
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, lista);
        listView.setAdapter(adaptador);
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
        generico.setText("");
        docente.setText("");
        estado.setText("");
        usuario.setText("");
        hora.setText("");
        codigo.setText("");
        fecha.setText("");
    }
    public void regresar (View view){
        Intent regresar = new Intent(this, CrudEquipo.class);
        startActivity(regresar);

    }
}