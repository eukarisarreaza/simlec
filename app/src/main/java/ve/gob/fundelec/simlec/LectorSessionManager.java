package ve.gob.fundelec.simlec;

import android.content.SharedPreferences;

import com.google.gson.Gson;

import ve.gob.fundelec.simlec.DataBase.entities.Lector;
import ve.gob.fundelec.simlec.ListaCallesAvenidas.entities.QueryCalles;
import ve.gob.fundelec.simlec.ListaRutasAsignadas.entities.QueryRutas;
import ve.gob.fundelec.simlec.ListaObjetosConexion.entities.QueryObjetoConexion;

/**
 * Created by fundelec on 11/07/17.
 */

public class LectorSessionManager {

    private static final String KEY_USER = "key_user";
    private static final String KEY_LOGGED = "key_logged";
    private static final String KEY_RECORRIDO = "key_recorrido"; // almacenar el ultimo fragment que utilizo en la opcion Rutas Asignadas

    private static final String KEY_RUTA = "key_ruta";
    private static final String KEY_CALLE = "key_calle";
    private static final String KEY_CENTROS_MEDICION = "key_centros_medicion";


    private SharedPreferences settings;

    public LectorSessionManager(SharedPreferences settings) {
        this.settings = settings;
    }


    public void setLector(Lector user){
        Gson gson = new Gson();
        String jsonString = gson.toJson(user);
        SharedPreferences.Editor editor= settings.edit();
        editor.putString(KEY_USER, jsonString);
        editor.apply();
    }

    public Lector getUser(){
        String json_user= settings.getString(KEY_USER, null);
        if(json_user==null)
            return null;
        else {
            Gson gson = new Gson();
            Lector lector = gson.fromJson(json_user, Lector.class);
            return lector;
        }
    }

    public boolean getLogged(){
        return settings.getBoolean(KEY_LOGGED, false);
    }

    public void setLogged(){
        SharedPreferences.Editor editor= settings.edit();
        editor.putBoolean(KEY_LOGGED, true);
        editor.apply();
    }

    public void logout(){
        SharedPreferences.Editor editor= settings.edit();
        editor.putBoolean(KEY_LOGGED, false);
        editor.apply();
    }

    public String getKeyRuta() {
        return settings.getString(KEY_RECORRIDO, Configuracion.PantallasRecorridoRutas.LISTA_RUTAS_ASIGNADAS.name() );
    }

    public void setRecorrido(Configuracion.PantallasRecorridoRutas fragment){
        SharedPreferences.Editor editor= settings.edit();
        editor.putString(KEY_RECORRIDO, fragment.name());
        editor.apply();
    }

    public void setRuta(QueryRutas ruta){
        Gson gson = new Gson();
        String jsonString = gson.toJson(ruta);
        SharedPreferences.Editor editor= settings.edit();
        editor.putString(KEY_RUTA, jsonString);
        editor.apply();
    }

    public QueryRutas getRuta(){
        String json_ruta= settings.getString(KEY_RUTA, null);
        if(json_ruta==null)
            return null;
        else {
            Gson gson = new Gson();
            QueryRutas ruta = gson.fromJson(json_ruta, QueryRutas.class);
            return ruta;
        }
    }

    public void setCalle(QueryCalles calle){
        Gson gson = new Gson();
        String jsonString = gson.toJson(calle);
        SharedPreferences.Editor editor= settings.edit();
        editor.putString(KEY_CALLE, jsonString);
        editor.apply();
    }

    public QueryCalles getCalle(){
        String json= settings.getString(KEY_CALLE, null);
        if(json==null)
            return null;
        else {
            Gson gson = new Gson();
            QueryCalles calle = gson.fromJson(json, QueryCalles.class);
            return calle;
        }
    }

    public void setObjetoConexion(QueryObjetoConexion objetoConexion){
        Gson gson = new Gson();
        String jsonString = gson.toJson(objetoConexion);
        SharedPreferences.Editor editor= settings.edit();
        editor.putString(KEY_CENTROS_MEDICION, jsonString);
        editor.apply();
    }

    public QueryObjetoConexion getObjetConexion(){
        String json= settings.getString(KEY_CENTROS_MEDICION, null);
        if(json==null)
            return null;
        else {
            Gson gson = new Gson();
            QueryObjetoConexion centro= gson.fromJson(json, QueryObjetoConexion.class);
            return centro;
        }
    }


}
