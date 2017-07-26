package ve.gob.fundelec.simlec.ObjetosConexion.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ve.gob.fundelec.simlec.ObjetosConexion.ui.ObjetosConexionView;

/**
 * Created by fundelec on 26/07/17.
 */
@Module
public class ObjetosConexionModule {
    private ObjetosConexionView view;

    public ObjetosConexionModule(ObjetosConexionView view) {
        this.view = view;
    }







    @Provides
    @Singleton
    ObjetosConexionView providesObjetosConexionView(){
        return this.view;
    }

}
