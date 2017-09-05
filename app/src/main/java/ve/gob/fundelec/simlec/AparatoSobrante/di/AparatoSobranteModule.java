package ve.gob.fundelec.simlec.AparatoSobrante.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ve.gob.fundelec.simlec.AparatoSobrante.AparatoSobranteInteractor;
import ve.gob.fundelec.simlec.AparatoSobrante.AparatoSobranteInteractorImpl;
import ve.gob.fundelec.simlec.AparatoSobrante.AparatoSobrantePresenter;
import ve.gob.fundelec.simlec.AparatoSobrante.AparatoSobrantePresenterImpl;
import ve.gob.fundelec.simlec.AparatoSobrante.AparatoSobranteRepository;
import ve.gob.fundelec.simlec.AparatoSobrante.AparatoSobranteRepositoryImpl;
import ve.gob.fundelec.simlec.AparatoSobrante.ui.AparatoSobranteView;
import ve.gob.fundelec.simlec.LectorSessionManager;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 14/07/17.
 */
@Module
public class AparatoSobranteModule {
    private AparatoSobranteView view;

    public AparatoSobranteModule(AparatoSobranteView view) {
        this.view = view;
    }

    @Provides
    @Singleton
    AparatoSobrantePresenter providesAparatoSobrantePresenter(EventBus eventBus, AparatoSobranteInteractor interactor, AparatoSobranteView view){
        return new AparatoSobrantePresenterImpl(eventBus, interactor, view);
    }

    @Provides
    @Singleton
    AparatoSobranteInteractor providesAparatoSobranteInteractor(AparatoSobranteRepository repository){
        return new AparatoSobranteInteractorImpl(repository);
    }

    @Provides
    @Singleton
    AparatoSobranteRepository providesAparatoSobranteRepository(EventBus eventBus, LectorSessionManager sessionManager){
        return new AparatoSobranteRepositoryImpl(eventBus, sessionManager);
    }

    @Provides
    @Singleton
    AparatoSobranteView providesAparatoSobranteView(){
        return this.view;
    }

}
