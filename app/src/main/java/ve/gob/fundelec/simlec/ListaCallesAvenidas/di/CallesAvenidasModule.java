package ve.gob.fundelec.simlec.ListaCallesAvenidas.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ve.gob.fundelec.simlec.ListaCallesAvenidas.ui.CallesAvenidasView;

/**
 * Created by fundelec on 25/07/17.
 */

@Module
public class CallesAvenidasModule {
    private CallesAvenidasView view;


    public CallesAvenidasModule(CallesAvenidasView view) {
        this.view = view;
    }



    @Provides
    @Singleton
    CallesAvenidasView providesCallesAvenidasView(){
        return this.view;
    }
}
