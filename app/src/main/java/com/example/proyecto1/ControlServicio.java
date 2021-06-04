package com.example.proyecto1;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class ControlServicio {
    public static String obtenerRespuestaPeticion(String url, Context ctx) {
        String respuesta = " ";
        HttpParams parametros = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(parametros, 3000);
        HttpConnectionParams.setSoTimeout(parametros, 5000);
        // Creando objetos de conexion
        HttpClient cliente = new DefaultHttpClient(parametros);
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse httpRespuesta = cliente.execute(httpGet);
            StatusLine estado = httpRespuesta.getStatusLine();
            int codigoEstado = estado.getStatusCode();
            if (codigoEstado == 200) {
                HttpEntity entidad = httpRespuesta.getEntity();
                respuesta = EntityUtils.toString(entidad);
            }
        } catch (Exception e) {
            Toast.makeText(ctx, "Error en la conexion", Toast.LENGTH_LONG).show();
            // Desplegando el error en el LogCat
            Log.v("Error de Conexion", e.toString());
        }
        return respuesta;
    }

    public static String obtenerRespuestaPost(String url, JSONObject obj, Context ctx) {
        String respuesta = " ";
        try {
            HttpParams parametros = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(parametros, 3000);
            HttpConnectionParams.setSoTimeout(parametros, 5000);
            HttpClient cliente = new DefaultHttpClient(parametros);
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("content-type", "application/json");
            StringEntity nuevaEntidad = new StringEntity(obj.toString());
            httpPost.setEntity(nuevaEntidad);
            Log.v("Peticion",url);
            Log.v("POST", httpPost.toString());
            HttpResponse httpRespuesta = cliente.execute(httpPost);
            StatusLine estado = httpRespuesta.getStatusLine();
            int codigoEstado = estado.getStatusCode();
            if (codigoEstado == 200) {
                respuesta = Integer.toString(codigoEstado);
                Log.v("respuesta",respuesta);
            }
            else{
                Log.v("respuesta",Integer.toString(codigoEstado));
            }
        } catch (Exception e) {
            Toast.makeText(ctx, "Error en la conexion", Toast.LENGTH_LONG)
                    .show();
            // Desplegando el error en el LogCat
            Log.v("Error de Conexion", e.toString());
        }
        return respuesta;
    }

    public static List<Documento> obtenerDocumentoLocal(String json, Context ctx) {
        List<Documento> listaDocumento = new ArrayList<Documento>();
        try {
            JSONArray documentoJSON = new JSONArray(json);
            for (int i = 0; i < documentoJSON.length(); i++) {
                JSONObject obj = documentoJSON.getJSONObject(i);
                Documento documento = new Documento();
                documento.setEscritoId(Integer.parseInt(obj.getString("escritoId")));
                documento.setIsbn(obj.getString("isbn"));
                documento.setEdicion(obj.getString("edicion"));
                documento.setEditorial(obj.getString("editorial"));
                documento.setTitulo(obj.getString("titulo"));
                documento.setTipoProductoId(Integer.parseInt(obj.getString("tipoProductoId")));
                documento.setAutorId(obj.getString("autorId"));
                documento.setIdiomaId(Integer.parseInt(obj.getString("idiomaId")));
                listaDocumento.add(documento);
            }
            return listaDocumento;
        } catch (Exception e) {
            Toast.makeText(ctx, "Error en parseO de JSON", Toast.LENGTH_LONG)
                    .show();
            return null;
        }
    }

    public static List<Equipo> obtenerEquipoLocal(String json, Context ctx) {
        List<Equipo> listaEquipo = new ArrayList<Equipo>();
        try {
            JSONArray equipoJSON = new JSONArray(json);
            for (int i = 0; i < equipoJSON.length(); i++) {
                JSONObject obj = equipoJSON.getJSONObject(i);
                Equipo equipo = new Equipo();
                equipo.setEquipoId(Integer.parseInt(obj.getString("ESCRITOID")));
                equipo.setEquipoGenericoId(obj.getString("EQUIPOGENERICOID"));
                equipo.setDocenteId(Integer.parseInt(obj.getString("DOCENTEID")));
                equipo.setEstadoEquipoId(Integer.parseInt(obj.getString("ESTADOEQUIPOID")));
                equipo.setUsuario(obj.getString("USUARIO"));
                equipo.setHoraId(Integer.parseInt(obj.getString("HORAID")));
                equipo.setCodigoEquipo(obj.getString("CODIGOEQUIPO"));
                equipo.setFechaAdquisicion(obj.getString("FECHAADQUISICION"));
                listaEquipo.add(equipo);
            }
            return listaEquipo;
        } catch (Exception e) {
            Toast.makeText(ctx, "Error en parseO de JSON", Toast.LENGTH_LONG)
                    .show();
            return null;
        }
    }

    public static void insertarDocumentoLocal(String peticion, Context ctx) {

        String json = obtenerRespuestaPeticion(peticion, ctx);
        try {
            JSONObject resultado = new JSONObject(json);

            Toast.makeText(ctx, "Registro ingresado"+ resultado.getJSONArray("resultado").toString(), Toast.LENGTH_LONG).show();
            int respuesta = resultado.getInt("resultado");
            if (respuesta == 1)
                Toast.makeText(ctx, "Registro ingresado", Toast.LENGTH_LONG)
                        .show();
            else
                Toast.makeText(ctx, "Error registro duplicado",
                        Toast.LENGTH_LONG).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void insertarEquipoLocal(String peticion, Context ctx) {

        String json = obtenerRespuestaPeticion(peticion, ctx);
        try {
            JSONObject resultado = new JSONObject(json);

            Toast.makeText(ctx, "Registro ingresado"+ resultado.getJSONArray("resultado").toString(), Toast.LENGTH_LONG).show();
            int respuesta = resultado.getInt("resultado");
            if (respuesta == 1)
                Toast.makeText(ctx, "Registro ingresado", Toast.LENGTH_LONG)
                        .show();
            else
                Toast.makeText(ctx, "Error registro duplicado",
                        Toast.LENGTH_LONG).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static List<Usuario> obtenerUsuario(String json, Context ctx)
    {
        List<Usuario> listaUsuario = new ArrayList<Usuario>();
        try {
            JSONArray usuarioJSON = new JSONArray(json);
            for (int i = 0; i < usuarioJSON.length(); i++) {
                JSONObject obj = usuarioJSON.getJSONObject(i);
                Usuario usuario = new Usuario();
                usuario.setUsuario(obj.getString("USUARIO"));
                usuario.setContrasena(obj.getString("CONTRASENA"));
                listaUsuario.add(usuario);
            }
            return listaUsuario;
        } catch (Exception e) {
            Toast.makeText(ctx, "Error en parseOO de JSON", Toast.LENGTH_LONG).show();
            return null;
        }
    }

}
