package ve.gob.fundelec.simlec;

import android.content.SharedPreferences;

import com.google.gson.Gson;

import ve.gob.fundelec.simlec.DataBase.entities.Lector;

/**
 * Created by fundelec on 11/07/17.
 */

public class LectorSessionManager {

    private static final String KEY_USER = "key_user";
    private static final String KEY_LOGGED = "key_logged";
    private static final String KEY_TYPE_USER = "key_type_user";

    private static final String KEY_INICIO = "key_inicio"; // PARA CREAR DATOS DE INICIO EN LA BASE DE DATOS


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

    public boolean getInicio(){
        return settings.getBoolean(KEY_INICIO, false);
    }

    public void setInicio(){
        SharedPreferences.Editor editor= settings.edit();
        editor.putBoolean(KEY_INICIO, true);
        editor.apply();
    }

    public String getTipoUser(){
        return settings.getString(KEY_TYPE_USER, Configuracion.TipoUsuario.LECTOR.name());
    }

    public void setTipoUser(Configuracion.TipoUsuario tipoUsuario){
        SharedPreferences.Editor editor= settings.edit();
        editor.putString(KEY_TYPE_USER, tipoUsuario.name());
        editor.apply();
    }
}
