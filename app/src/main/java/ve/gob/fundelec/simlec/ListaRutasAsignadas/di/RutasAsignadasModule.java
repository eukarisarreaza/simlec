package ve.gob.fundelec.simlec.ListaRutasAsignadas.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ve.gob.fundelec.simlec.LectorSessionManager;
import ve.gob.fundelec.simlec.ListaRutasAsignadas.RutasAsignadasInteractor;
import ve.gob.fundelec.simlec.ListaRutasAsignadas.RutasAsignadasInteractorImpl;
import ve.gob.fundelec.simlec.ListaRutasAsignadas.RutasAsignadasPresenter;
import ve.gob.fundelec.simlec.ListaRutasAsignadas.RutasAsignadasPresenterImpl;
import ve.gob.fundelec.simlec.ListaRutasAsignadas.RutasAsignadasRepository;
import ve.gob.fundelec.simlec.ListaRutasAsignadas.RutasAsignadasRepositoryImpl;
import ve.gob.fundelec.simlec.ListaRutasAsignadas.ui.RutasAsignadasView;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 19/07/17.
 */

@Module
public class RutasAsignadasModule {
    private RutasAsignadasView view;

    public RutasAsignadasModule(RutasAsignadasView view) {
        this.view = view;
    }

    @Provides
    @Singleton
    RutasAsignadasPresenter providesRutasAsignadasPresenter(EventBus eventBus, RutasAsignadasView view, RutasAsignadasInteractor interactor){
        return new RutasAsignadasPresenterImpl(eventBus, view, interactor);
    }

    @Provides
    @Singleton
    RutasAsignadasInteractor providesRutasAsignadasInteractor(RutasAsignadasRepository repository){
        return new RutasAsignadasInteractorImpl(repository);
    }

    @Provides
    @Singleton
    RutasAsignadasRepository providesRutasAsignadasRepository(EventBus eventBus, LectorSessionManager sessionManager){
        return new RutasAsignadasRepositoryImpl(eventBus, sessionManager);
    }

    @Provides
    @Singleton
    RutasAsignadasView providesRutasAsignadasView(){
        return this.view;
    }
}
