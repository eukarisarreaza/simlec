package ve.gob.fundelec.simlec.ListadoCentrosMedicion.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ve.gob.fundelec.simlec.LectorSessionManager;
import ve.gob.fundelec.simlec.ListadoCentrosMedicion.ObjetosConexionInteractor;
import ve.gob.fundelec.simlec.ListadoCentrosMedicion.ObjetosConexionInteractorImpl;
import ve.gob.fundelec.simlec.ListadoCentrosMedicion.ObjetosConexionPressenter;
import ve.gob.fundelec.simlec.ListadoCentrosMedicion.ObjetosConexionPressenterImpl;
import ve.gob.fundelec.simlec.ListadoCentrosMedicion.ObjetosConexionRepository;
import ve.gob.fundelec.simlec.ListadoCentrosMedicion.ObjetosConexionRepositoryImpl;
import ve.gob.fundelec.simlec.ListadoCentrosMedicion.ui.ObjetosConexionView;
import ve.gob.fundelec.simlec.lib.base.EventBus;

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
    ObjetosConexionPressenter providesObjetosConexionPressenter(EventBus eventBus, ObjetosConexionView view, ObjetosConexionInteractor interactor){
        return new ObjetosConexionPressenterImpl(eventBus, view, interactor);
    }

    @Provides
    @Singleton
    ObjetosConexionInteractor providesObjetosConexionInteractor(ObjetosConexionRepository repository){
        return new ObjetosConexionInteractorImpl(repository);
    }

    @Provides
    @Singleton
    ObjetosConexionRepository providesObjetosConexionRepository(LectorSessionManager sessionManager, EventBus eventBus){
        return new ObjetosConexionRepositoryImpl(sessionManager, eventBus);
    }

    @Provides
    @Singleton
    ObjetosConexionView providesObjetosConexionView(){
        return this.view;
    }

}
