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

import java.util.Date;
import java.util.List;

@SuppressLint("NewApi")
public class AgregarEquipo extends Activity {

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
    private final String urlLocal="https://192.168.1.20/Servicios/agregar_equipo.php";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_equipo);
        helper = new ControlBD(this);
        generico= (EditText) findViewById(R.id.editGenerico);
        docente= (EditText) findViewById(R.id.editDocente);
        estado= (EditText) findViewById(R.id.editEstado);
        usuario= (EditText) findViewById(R.id.editUsuario);
        hora= (EditText) findViewById(R.id.editHora);
        codigo = (EditText) findViewById(R.id.editCodigo);
        fecha = (EditText) findViewById(R.id.editFecha);
        listView = (ListView) findViewById(R.id.listView1);
    }

    public void insertar(View v){
        String gene=generico.getText().toString();
        int doc=Integer.parseInt(docente.getText().toString());
        int est=Integer.parseInt(estado.getText().toString());
        String us=usuario.getText().toString();
        int hor=Integer.parseInt(hora.getText().toString());
        String cod=codigo.getText().toString();
        String fech=fecha.getText().toString();
        String regInsertados;
        Equipo eq = new Equipo();
        eq.setEquipoId(0);
        eq.setEquipoGenericoId(gene);
        eq.setDocenteId(doc);
        eq.setEstadoEquipoId(est);
        eq.setUsuario(us);
        eq.setHoraId(hor);
        eq.setCodigoEquipo(cod);
        eq.setFechaAdquisicion(fech);
        helper.abrir();
        regInsertados=helper.insertar(eq);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
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
            case R.id.agregarPHP:
                // it was the first button
                url = urlLocal + "?EQUIPOGENERICOID="+gene+"?DOCENTEID="+doc+"?ESTADOEQUIPOID="+est
                        +"?USUARIO="+us +"?HORAID="+hor+"?CODIGOEQUIPO="+cod+"?FECHAADQUISICION="+fech;
                ControlServicio.insertarEquipoLocal(url, this);
                break;
        }
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