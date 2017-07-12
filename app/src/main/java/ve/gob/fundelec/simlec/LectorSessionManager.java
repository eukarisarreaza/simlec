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



}
