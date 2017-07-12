package ve.gob.fundelec.simlec.Login.di;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ve.gob.fundelec.simlec.LectorSessionManager;

/**
 * Created by Eukaris on 26/04/2017.
 */
@Module
public class SesionModule {

    public SesionModule() {
    }

    @Provides
    @Singleton
    LectorSessionManager providesUserSessionManager(SharedPreferences sharedPreferences){
        return new LectorSessionManager(sharedPreferences);
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
}
