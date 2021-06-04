package com.example.proyecto1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class ControlBD{

    private static final String[]camposDocumento = new String[] {
            "escritoId","isbn","edicion", "editorial","titulo"};
    private static final String[]camposAutor = new String[] {"autorId","nomAutor","apeAutor"};
    private static final String[]camposIdioma = new String[] {"idiomaId","idiomaNombre"};
    private static final String[]camposUsuario = new String[] {
            "usuario","contrasena","nombreUsuario"};
    private static final String[]camposAccesoUsuario = new String[]{};
    private static final String[]camposOpcionCrud = new String[] {"opcionId","desOpcion","numCrud"};
    private static final String[]camposTipoProducto = new String[] {
            "tipoProductoId", "nombreTipoProducto", "categoriaId"};
    private static final String[]camposCategoria = new String[] {"categoriaId", "categoriaNombre"};
    private static final String[]camposDocente = new String[] {"docenteId", "docenteNombre"};
    private static final String[] camposCatalogoEquipo = new String[]{
            "equipoGenericoId","modeloEquipoGenerico","Memoria","cantidadEquipo"};
    private static final String[] camposEstadoEquipo = new String[] {"estadoEquipoId","estado"};
    private static final String[] camposEquipoInformatico = new String[] {
            "equipoId", "equipoGenericoId","docenteId","estadoEquipoId", "usuario","horaId", "codigoEquipo", "fechaAdquisicion"};
    private static final String[] camposUbicacion = new String[] {"ubicacionId","ubicacionNombre"};
    private static final String[] camposDescargo = new String[] {"descargoId","descargoFecha"};
    private static final String[] camposdetalleDescargo = new String[] {"detalleDescargoId"};
    private static final String[] camposHoraClase = new String[] {"horaId","horaInicio","horaFin"};
    private static final String[] camposSalon = new String[] {"salonId","nombreSalon"};
    private static final String[] camposMovimientoInventario = new String[] {"numMov",
            "desMov","movFechaIni","MovFechaFin"};
    private static final String[] camposDia = new String[] {"diaId","diaNombre"};
    private static final String[] camposCiclo = new String[] {"cicloId","cicloDesde","cicloHasta"};
    private static final String[] camposHorario = new String[] {"horarioId"};

    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;


    public ControlBD(Context ctx) {
        this.context=ctx;
        DBHelper= new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper{

        private static final String BASE_DATOS= "proyectoPdm.s3db";
        private static final int VERSION=1;
        public DatabaseHelper(Context context){
            super(context,BASE_DATOS, null, VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try{
                db.execSQL("CREATE TABLE TIPOPRODUCTO  (\n" +
                        "   TIPOPRODUCTOID       NUMBER(6)                       not null,\n" +
                        "   CATEGORIAID          INTEGER                         not null,\n" +
                        "   NOMBRETIPOPRODUCTO   VARCHAR2(50)                    not null,\n" +
                        "   constraint PK_TIPOPRODUCTO primary key (TIPOPRODUCTOID)\n" +
                        ")");
                db.execSQL("CREATE TABLE DOCUMENTO  (\n" +
                        "   ESCRITOID            NUMBER(6)                       not null,\n" +
                        "   TIPOPRODUCTOID       INTEGER                         not null,\n" +
                        "   AUTORID              CHAR(7),\n" +
                        "   IDIOMAID             INTEGER,\n" +
                        "   ISBN                 VARCHAR2(50),\n" +
                        "   EDICION              VARCHAR2(50),\n" +
                        "   EDITORIAL            VARCHAR2(50),\n" +
                        "   TITULO               VARCHAR2(75)                    not null,\n" +
                        "   constraint PK_DOCUMENTO primary key (ESCRITOID))");
                db.execSQL("CREATE TABLE AUTOR  (\n" +
                        "   AUTORID              CHAR(7)                         not null,\n" +
                        "   NOMAUTOR             VARCHAR2(30)                    not null,\n" +
                        "   APEAUTOR             VARCHAR2(30)                    not null,\n" +
                        "   constraint PK_AUTOR primary key (AUTORID)\n" +
                        ") ");
                db.execSQL("CREATE TABLE IDIOMA  (\n" +
                        "   IDIOMAID             NUMBER(6)                       not null,\n" +
                        "   IDIOMANOMBRE         VARCHAR2(15)                    not null,\n" +
                        "   constraint PK_IDIOMA primary key (IDIOMAID)\n" +
                        ") ");
                db.execSQL("CREATE TABLE  USUARIO  (\n" +
                        "   USUARIO              VARCHAR2(7)                     not null,\n" +
                        "   CONTRASENA           VARCHAR2(10)                    not null,\n" +
                        "   NOMBREUSUARIO        VARCHAR2(256)                   not null,\n" +
                        "   constraint PK_USUARIO primary key (USUARIO)\n" +
                        ")");
                db.execSQL("CREATE TABLE OPCIONCRUD  (\n" +
                        "   OPCIONID             CHAR(3)                         not null,\n" +
                        "   DESOPCION            VARCHAR2(30)                    not null,\n" +
                        "   NUMCRUD              INTEGER                         not null,\n" +
                        "   constraint PK_OPCIONCRUD primary key (OPCIONID)\n" +
                        ")");
                db.execSQL("CREATE TABLE  ACCESOUSUARIO  (\n" +
                        "   USUARIO              VARCHAR2(7)                     not null,\n" +
                        "   OPCIONID             CHAR(3)                         not null\n" +
                        ")");
                db.execSQL("CREATE INDEX ACCESO_FK on ACCESOUSUARIO (\n" +
                        "   USUARIO ASC\n" +
                        ")");
                db.execSQL("CREATE INDEX GESTIONA_FK on ACCESOUSUARIO (\n" +
                        "   OPCIONID ASC\n" +
                        ")");
                db.execSQL("CREATE TABLE CATEGORIA  (\n" +
                        "   CATEGORIAID          NUMBER(6)                       not null,\n" +
                        "   CATEGORIANOMBRE      VARCHAR2(50)                    not null,\n" +
                        "   constraint PK_CATEGORIA primary key (CATEGORIAID)\n" +
                        ")");
                db.execSQL("CREATE TABLE DOCENTE  (\n" +
                        "   DOCENTEID          NUMBER(6)                       not null,\n" +
                        "   DOCENTENOMBRE      VARCHAR2(50)                    not null,\n" +
                        "   constraint PK_DOCENTE primary key (DOCENTEID)\n" +
                        ")");
                db.execSQL("CREATE TABLE MOVIMIENTOINVENTARIO  (\n" +
                        "   NUMMOV          NUMBER(6)                       not null,\n" +
                        "   DESMOV      VARCHAR2(50)                    not null,\n" +
                        "   MOVFECHAINI      VARCHAR(50)                    not null,\n" +
                        "   MOVFECHAFIN      VARCHAR(50)                    not null,\n" +
                        "   constraint PK_MOVIMIENTOINVENTARIO primary key (NUMMOV)\n" +
                        ")");
                db.execSQL("CREATE TABLE DIA  (\n" +
                        "   DIAID          NUMBER(6)                       not null,\n" +
                        "   DIANOMBRE      VARCHAR2(50)                    not null,\n" +
                        "   constraint PK_DIA primary key (DIAID)\n" +
                        ")");
                db.execSQL("CREATE TABLE CICLO  (\n" +
                        "   CICLOID         VARCHAR2(7)                       not null,\n" +
                        "   CICLODESDE      VARCHAR2(50)                    not null,\n" +
                        "   CICLOHASTA      VARCHAR2(50)                    not null,\n" +
                        "   constraint PK_CICLO primary key (CICLOID)\n" +
                        ")");
                db.execSQL("CREATE TABLE HORARIO  (\n" +
                        "   HORARIOID          NUMBER(6)                       not null,\n" +
                        "   constraint PK_HORARIO primary key (HORARIOID)\n" +
                        ")");
                db.execSQL("CREATE TABLE CATALOGOEQUIPO  (\n" +
                        "   TIPOPRODUCTOID       VARCHAR2(6)                       not null,\n" +
                        "   CATEGORIAID          INTEGER                         not null,\n" +
                        "   NOMBRETIPOPRODUCTO   VARCHAR2(50)                    not null,\n" +
                        "   constraint PK_TIPOPRODUCTO primary key (TIPOPRODUCTOID)\n" +
                        ")");
                db.execSQL("CREATE TABLE ESTADOEQUIPO  (\n" +
                        "   ESTADOEQUIPOID          NUMBER(6)                       not null,\n" +
                        "   ESTADO      VARCHAR2(50)                    not null,\n" +
                        "   constraint PK_ESTADOEQUIPO primary key (ESTADOEQUIPOID)\n" +
                        ")");
                db.execSQL("CREATE TABLE DETALLEDESCARGO  (\n" +
                        "   DETALLEDESCARGOID          NUMBER(6)                       not null,\n" +
                        "   constraint PK_DETALLEDESCARGO primary key (DETALLEDESCARGOID)\n" +
                        ")");
                db.execSQL("CREATE TABLE DESCARGO  (\n" +
                        "   DESCARGOID          NUMBER(6)                       not null,\n" +
                        "   DESCARGOFECHA      VARCHAR2(50)                    not null,\n" +
                        "   constraint PK_DESCARGO primary key (DESCARGOID)\n" +
                        ")");
                db.execSQL("CREATE TABLE UBICACION  (\n" +
                        "   UBICACIONID          NUMBER(6)                       not null,\n" +
                        "   UBICACIONNOMBRE      VARCHAR2(50)                    not null,\n" +
                        "   constraint PK_UBICACION primary key (UBICACIONID)\n" +
                        ")");
                db.execSQL("CREATE TABLE EQUIPOINFORMATICO  (\n" +
                        "   EQUIPOID             NUMBER(6)                       not null,\n" +
                        "   EQUIPOGENERICOID     CHAR(6),\n" +
                        "   DOCENTEID            INTEGER,\n" +
                        "   ESTADOEQUIPOID       INTEGER                         not null,\n" +
                        "   USUARIO              VARCHAR2(7),\n" +
                        "   HORAID               INTEGER,\n" +
                        "   CODIGOEQUIPO         VARCHAR2(30)                    not null,\n" +
                        "   FECHAADQUISICION     VARCHAR2(15)                    not null,\n" +
                        "   constraint PK_EQUIPOINFORMATICO primary key (EQUIPOID)\n" +
                        ")");
            } catch (SQLException e){
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

    public void abrir() throws SQLException{ db=DBHelper.getWritableDatabase(); }

    public void cerrar(){ DBHelper.close(); }

    public Usuario login(String usuario, String contrasena){
        String[] id1 = {usuario};
        String[] id2 = {contrasena};
        Cursor cursor = db.query("usuario", camposUsuario, "nombreUsuario = ?",
                id1, null, null, null);
        Cursor cursor2 = db.query("usuario", camposUsuario, "contrasena = ?",
                id2, null, null, null);
        if(cursor.moveToFirst() && cursor2.moveToFirst()){
            Usuario usuario2 = new Usuario();
            usuario2.setNombreUsuario(cursor.getString(0));
            usuario2.setContrasena(cursor2.getString(1));
            return usuario2;
        }else{
            return null;
        }
    }

    public String insertar(Documento documento){
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        ContentValues doc = new ContentValues();
        doc.put("escritoId", documento.getEscritoId());
        doc.put("tipoProductoId", documento.getTipoProductoId());
        doc.put("autorId", documento.getAutorId());
        doc.put("idiomaId",documento.getIdiomaId());
        doc.put("isbn", documento.getIsbn());
        doc.put("edicion", documento.getEdicion());
        doc.put("editorial", documento.getEditorial());
        doc.put("titulo", documento.getTitulo());
        contador=db.insert("documento", null, doc);
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;

    }

    public String insertar(Autor autor){

        String regInsertados="Registro Insertado N=";
        long contador=0;
        ContentValues au= new ContentValues();
        au.put("autorId",autor.getAutorId());
        au.put("nomAutor",autor.getNomAutor());
        au.put("apeAutor",autor.getApeAutor());
        contador=db.insert("autor",null,au);
        if(contador==-1 || contador==0){
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }

    public String insertar(Idioma idioma){

        String regInsertados="Registro Insertado N=";
        long contador=0;
        ContentValues id= new ContentValues();
        id.put("idiomaId",idioma.getIdiomaId());
        id.put("idiomaNombre",idioma.getIdiomaNombre());
        contador=db.insert("idioma",null,id);
        if(contador==-1 || contador==0){
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }

    public String insertar(TipoProducto tipoProducto){

        String regInsertados="Registro Insertado N=";
        long contador=0;
        ContentValues tip= new ContentValues();
        tip.put("tipoProductoId",tipoProducto.getTipoProductoId());
        tip.put("nombreTipoProducto",tipoProducto.getNombreTipoProducto());
        tip.put("categoriaId", Integer.parseInt(tipoProducto.getCategoriaId().toString()));
        contador=db.insert("tipoProducto",null,tip);
        if(contador==-1 || contador==0){
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }

    public String insertar(Usuario usuario){

        String regInsertados="Registro Insertado N=";
        long contador=0;
        ContentValues us= new ContentValues();
        us.put("usuario",usuario.getUsuario());
        us.put("contrasena", usuario.getContrasena());
        us.put("nombreUsuario",usuario.getNombreUsuario());
        contador=db.insert("usuario",null,us);
        if(contador==-1 || contador==0){
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }

    public String actualizar(Documento documento){
        if(verificarIntegridad(documento, 2)){
            String[] id = {documento.getTitulo()};
            ContentValues cv = new ContentValues();
            cv.put("tipoProductoId", documento.getTipoProductoId());
            cv.put("editorial", documento.getEditorial());
            cv.put("edicion", documento.getEdicion());
            db.update("documento", cv, "titulo = ?", id);
            return "Registro Actualizado Correctamente";
        }else{
            return "Registro con titulo " + documento.getTitulo() + " no existe";
        }
    }

    public String eliminar(Documento documento) {
        String regAfectados="filas afectadas= ";
        int contador=0;
        if (verificarIntegridad(documento,3)) {
            contador+=db.delete("documento", "titulo='"+documento.getTitulo()+"'", null);
        }
        contador+=db.delete("documento", "titulo='"+documento.getTitulo()+"'", null);
        regAfectados+=contador;
        return regAfectados;
    }

    // CRUD Equipos
    public String insertar(Equipo equipo){
        String regInsertados="Registro Insertado N=";
        long contador=0;
        ContentValues eq= new ContentValues();
        eq.put("equipoId",equipo.getEquipoId());
        eq.put("equipoGenericoId", equipo.getEquipoGenericoId());
        eq.put("docenteId",equipo.getDocenteId());
        eq.put("estadoEquipoId", equipo.getEstadoEquipoId());
        eq.put("usuario", equipo.getUsuario());
        eq.put("horaId", equipo.getHoraId());
        eq.put("codigoEquipo", equipo.getCodigoEquipo());
        eq.put("fechaAdquisicion", equipo.getFechaAdquisicion());
        contador=db.insert("equipoInformatico",null,eq);
        if(contador==-1 || contador==0){
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }

    public String actualizar(Equipo equipo){
        if(verificarIntegridad(equipo, 6)){
            String[] id = {equipo.getEquipoGenericoId()};
            ContentValues cv = new ContentValues();
            cv.put("docenteId", equipo.getDocenteId());
            cv.put("estadoEquipoId", equipo.getEstadoEquipoId());
            cv.put("usuario", equipo.getUsuario());
            cv.put("horaId", equipo.getHoraId());
            cv.put("fechaAdquisicion", equipo.getFechaAdquisicion());
            db.update("equipoInformatico", cv, "equipoGenericoId = ?", id);
            return "Registro Actualizado Correctamente";
        }else{
            return "Registro con equipo generico " + equipo.getEquipoGenericoId() + " no existe";
        }
    }

    public String eliminar(Equipo equipo) {
        String regAfectados="filas afectadas= ";
        int contador=0;
        if (verificarIntegridad(equipo,7)) {
            contador+=db.delete("equipoInformatico", "codigoEquipo='"+equipo.getCodigoEquipo()+"'", null);
        }
        contador+=db.delete("equipoInformatico", "codigoEquipo='"+equipo.getCodigoEquipo()+"'", null);
        regAfectados+=contador;
        return regAfectados;
    }

    // CRUD DOCENTES
    public String insertar(Docente docente){

        String regInsertados="Registro Insertado N=";
        long contador=0;
        ContentValues us= new ContentValues();
        us.put("docenteId",docente.getIdDocente());
        us.put("docenteNombre",docente.getNombreDocente());
        contador=db.insert("docente",null,us);
        if(contador==-1 || contador==0){
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }

    public String actualizar(Docente docente){
        if(verificarIntegridad(docente, 2)){
            String[] id = {docente.getNombreDocente()};
            ContentValues cv = new ContentValues();
            cv.put("docenteId", docente.getIdDocente());
            cv.put("docenteNombre", docente.getNombreDocente());
            db.update("docente", cv, "docenteNombre = ?", id);
            return "Registro Actualizado Correctamente";
        }else{
            return "Registro con titulo " + docente.getNombreDocente() + " no existe";
        }
    }

    public String eliminar(Docente docente) {
        String regAfectados="filas afectadas= ";
        int contador=0;
        if (verificarIntegridad(docente,3)) {
            contador+=db.delete("docente", "docenteNombre='"+docente.getNombreDocente()+"'", null);
        }
        contador+=db.delete("docente", "docenteNombre='"+docente.getNombreDocente()+"'", null);
        regAfectados+=contador;
        return regAfectados;
    }

    public String consultar(Documento documento) { return null; }

    private boolean verificarIntegridad(Object dato, int relacion) throws SQLException{
        switch (relacion){
            case 1:
            {
                //Verificar que al insertar un documento exista el tipo producto, idioma, autor
                Documento documento=(Documento)dato;
                String[] id1={documento.getEditorial()};
                String[] id2={documento.getEditorial()};
                String[] id3={documento.getEditorial()};
                //abrir();
                Cursor cursor1=db.query("tipoProducto", null, "tipoProductoId = ?", id1, null, null, null);
                Cursor cursor2=db.query("autor", null, "autorId", id2, null, null, null);
                Cursor cursor3=db.query("idioma", null, "idiomaId", id3, null, null, null);
            }

            case 2:
            {
                //Verificar que al modificar un documento exista autorId, titulo, isbn
                Documento documento1=(Documento)dato;
                String[] id={documento1.getTitulo(), documento1.getIsbn(), documento1.getAutorId()};
                abrir();
                Cursor c = db.query("documento", null, "titulo = ? AND isbn = ? AND autorId = ?", id, null, null, null);
                if(c.moveToFirst()){
                    //Se encontraron datos
                    return true;
                }
                return false;
            }

            case 3:
            {
                Documento documento2 = (Documento)dato;
                Cursor c=db.query(true, "documento", new String[]{"titulo"}, "titulo='"+documento2.getTitulo()+"'", null, null, null, null, null);
                if (c.moveToFirst())
                    return true;
                else
                    return false;
            }

            case 4:
            {
                //Verificar si exite el usuario
                Usuario usuario1 = (Usuario) dato;
                Cursor c=db.query(true, "usuario", new String[]{"nombreUsuario"}, "nombreUsuario='"+usuario1.getNombreUsuario()+"'", null, null, null, null, null);
                if (c.moveToFirst())
                    return true;
                else
                    return false;
            }

            case 5:
            {
                //Verificar si exite la contrasena
                Usuario usuario2 = (Usuario) dato;
                Cursor c=db.query(true, "usuario", new String[]{"contrasena"}, "contrasena='"+usuario2.getContrasena()+"'", null, null, null, null, null);
                if (c.moveToFirst())
                    return true;
                else
                    return false;
            }

            case 6:
            {
                //Verificar que al modificar un equipo exista equipoGenericoId, codigoEquipo
                Equipo equipo=(Equipo) dato;
                String[] id={equipo.getEquipoGenericoId(), equipo.getCodigoEquipo()};
                abrir();
                Cursor c = db.query("equipoInformatico", null, "equipoGenericoId = ? AND codigoEquipo = ?", id, null, null, null);
                if(c.moveToFirst()){
                    //Se encontraron datos
                    return true;
                }
                return false;
            }

            case 7:
            {
                Equipo equipo2 = (Equipo) dato;
                Cursor c=db.query(true, "equipoInformatico", new String[]{"codigoEquipo"}, "codigoEquipo='"+equipo2.getCodigoEquipo()+"'", null, null, null, null, null);
                if (c.moveToFirst())
                    return true;
                else
                    return false;
            }

            default:
                return false;
        }
    }

    public String llenarDBDocumento(){

        final int[] DId = {01, 02, 03, 04, 05};
        final String[] DIsbn = {"967-34-90847-30-5", "349-65-09845-23-6", "456-03-84129-21-9", "873-78-40234-43-1", "987-12-92367-09-1"};
        final String[] DEdicion = {"Quinta", "Primera", "Tercera", "Onceava", "Septima"};
        final String[] DEditorial = {"Caja negra", "Ariel", "Impedimenta", "Circulo rojo", "Lulu"};
        final String[] DTitulo = {"Analisis de estructuras", "Metodos matematicos avanzados", "Principios de electronica", "Estatica","Tesis"};
        final int[] DTipoProducto = {01, 01, 01, 01, 02};
        final String[] DAutorId = {"Autor1", "Autor2", "Autor3", "Autor4", "Autor5"};
        final int[] DIdiomaId = {01, 01, 01, 01, 01};

        final String[] AAutorId = {"Autor1", "Autor2", "Autor3", "Autor4", "Autor5"};
        final String[] ANomAutor = {"Jose", "Luis", "Pamela", "Karen", "Sergio"};
        final String[] AApeAutor = {"Gonzalez", "Martinez", "Ruano", "Ramos", "Elias"};

        final int[] IIdiomaId = {01};
        final String[] IIdiomaNombre = {"Español"};

        final int[] TTipoProdcutoId = {01, 02, 03, 04};
        final String[] TNombreTipoProducto = {"Libro", "Tesis", "Laptop", "Cañon"};
        final Integer[] TCategoriaId = {01, 01, 02, 02};

        final String[] UUsuario = {"01", "02", "03", "04"};
        final String[] UContrasena = {"contra1", "contra2", "contra3", "contra"};
        final String[] UNombreUsuario = {"usuario1", "usuario2", "usuario3", "usuario"};

        final int[] EEQuipoId = {01, 02};
        final String[] EEquipoGenericoId={"01", "01"};
        final int[] EDocenteId={01,01};
        final int[] EEstadoEquipoId={01,01};
        final String[] EUsuario={"usuario1", "usuario2"};
        final int[] EHoraId ={01, 02};
        final String[] ECodigoEquipo={"26","356"};
        final String[] EFechaAdquisicion={"21/5/2021", "25/6/2021"};

        final int[] CCategoriaId = {01,02};
        final String[] CCategoriaNombre= {"Documento","Equipo Informatico"};

        final int[] DDocenteId = {01, 02, 03};
        final String[] DDocenteNombre = {"René Orlando Pocasangre",
                "Mario Mauricio Monge", "Uvuvwevwevwe Ossas"};

        final String[] SSalonId = {"B11","LCOMP1"};
        final String[] SNombre = {"Aula B-11","Laboratio de Computadoras 1"};

        final int[] HHoraClaseId = {01,02,03};
        final String[] HHoraClaseIni = {"6:20","8:05","9:50"};
        final String[] HHoraClaseFin = {"8:00","9:45","11:30"};

        final String[] CCatalogoId = {"EIF001","EIF002","EIF003"};
        final String[] CCatalogoModelo = {"HP","Canon","Sony"};
        final int[] CCatalogoMemoria = {2,4,8};
        final int[] CCatalogoCantidad = {25,15,10};
        final int[] CTipoProducto = {03,04,03};

        final int[] MMovimientoId = {01, 02, 03};
        final String[] MDesMov = {"Préstamo parcial", "Préstamo total", "Mantenimiento"};
        final String[] MMovInicial = {"1/02/2021", "2/03/2021", "3/04/2021"};
        final String[] MMovFinal = {"2/04/2021", "3/05/2021", "4/06/2021"};
        final String[] MMovCiclo ={"02","02","02"};
        final int[] MMovDocentes = {01,01,03};
        final int[] MMovEquipo = {01,02,03};

        final int[] DDiaId = {01, 02, 03};
        final String[] DDiaNombre = {"Lunes", "Miércoles", "Viernes"};

        final String[] CCicloId = {"01", "02", "03"};
        final String[] CCicloDesde = {"2/02/2021", "3/03/2021", "4/04/2021"};
        final String[] CCicloHasta = {"1/04/2021", "2/05/2021", "3/06/2021"};

        final int[] HHorarioId = {01,02,03};
        final int[] HHorarioClase = {01,02,03};
        final int[] HHorarioDia = {03,03,02};

        final int[] EstadoEquipoId = {01, 02, 03};
        final String[] EEstado = {"Disponible", "Ocupado", "Mantenimiento"};

        final int[] DDetalleDescargoId = {01, 02, 03};
        final int[] DDetalleDescargoEq = {01,02,03};
        final int[] DDetalleDescargoDesc = {01,02,03};

        final int[] DDescargoId = {01, 02, 03};
        final String[] DDescargoFecha = {"2/02/2021", "3/03/2021", "4/04/2021"};
        final int[] DDescargoUb = {01,02,03};

        final int[] UUbicacioId = {01, 02, 03};
        final String[] UUbicacionNombre = {"Bodega", "Zona de mantenimiento", "Bodega"};

        abrir();
        db.execSQL("DELETE FROM documento");
        db.execSQL("DELETE FROM autor");
        db.execSQL("DELETE FROM idioma");
        db.execSQL("DELETE FROM tipoProducto");
        db.execSQL("DELETE FROM usuario");
        db.execSQL("DELETE FROM equipoInformatico");
        /*
        db.execSQL("DELETE FROM docente");
        db.execSQL("DELETE FROM catalogoEquipo");
        db.execSQL("DELETE FROM estadoEquipo");
        db.execSQL("DELETE FROM ubicacion");
        db.execSQL("DELETE FROM descargo");
        db.execSQL("DELETE FROM detalleDescargo");
        db.execSQL("DELETE FROM movimientoInventario");
        db.execSQL("DELETE FROM horaClase");
        db.execSQL("DELETE FROM salon");
        db.execSQL("DELETE FROM horario");
        db.execSQL("DELETE FROM dia");
        db.execSQL("DELETE FROM ciclo");*/


        Documento documento=new Documento();
        for(int i=0; i<5;i++){
            documento.setEscritoId(DId[i]);
            documento.setIsbn(DIsbn[i]);
            documento.setEdicion(DEdicion[i]);
            documento.setEditorial(DEditorial[i]);
            documento.setTitulo(DTitulo[i]);
            documento.setTipoProductoId(DTipoProducto[i]);
            documento.setAutorId(DAutorId[i]);
            documento.setIdiomaId(DIdiomaId[i]);
            insertar(documento);
        }

        Autor autor=new Autor();
        for(int i=0; i<5; i++){
            autor.setAutorId(AAutorId[i]);
            autor.setNomAutor(ANomAutor[i]);
            autor.setApeAutor(AApeAutor[i]);
            insertar(autor);
        }

        Idioma idioma = new Idioma();
        for(int i=0; i <1; i++){
            idioma.setIdiomaId(IIdiomaId[i]);
            idioma.setIdiomaNombre(IIdiomaNombre[i]);
            insertar(idioma);
        }

        TipoProducto tipoP = new TipoProducto();
        for(int i =0; i<2; i++){
            tipoP.setTipoProductoId(TTipoProdcutoId[i]);
            tipoP.setNombreTipoProducto(TNombreTipoProducto[i]);
            tipoP.setCategoriaId(TCategoriaId[i]);
            insertar(tipoP);
        }

        Usuario usuario = new Usuario();
        for(int i=0; i<4; i++){
            usuario.setUsuario(UUsuario[i]);
            usuario.setContrasena(UContrasena[i]);
            usuario.setNombreUsuario(UNombreUsuario[i]);
            insertar(usuario);
        }

        Equipo equipo =new Equipo();
        for (int i = 0; i<2;i++){
            equipo.setEquipoId(EEQuipoId[i]);
            equipo.setEquipoGenericoId(EEquipoGenericoId[i]);
            equipo.setDocenteId(EDocenteId[i]);
            equipo.setEstadoEquipoId(EEstadoEquipoId[i]);
            equipo.setUsuario(EUsuario[i]);
            equipo.setHoraId(EHoraId[i]);
            equipo.setCodigoEquipo(ECodigoEquipo[i]);
            equipo.setFechaAdquisicion(EFechaAdquisicion[i]);
            insertar(equipo);
        }

        Docente docente = new Docente();
        for(int i=0; i<3; i++){
            docente.setIdDocente(DDocenteId[i]);
            docente.setNombreDocente(DDocenteNombre[i]);
            //insertar(docente);
            /* Metodo comentado ya que la tabla 'docente' no se crea por
            algun motivo, por lo que el metodo no funciona */
        }

        cerrar();
        return "Guardado correctamente";
    }
}

