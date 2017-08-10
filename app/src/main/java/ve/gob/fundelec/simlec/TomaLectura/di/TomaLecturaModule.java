package ve.gob.fundelec.simlec.TomaLectura.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ve.gob.fundelec.simlec.LectorSessionManager;
import ve.gob.fundelec.simlec.TomaLectura.TomaLecturaInteractor;
import ve.gob.fundelec.simlec.TomaLectura.TomaLecturaInteractorImpl;
import ve.gob.fundelec.simlec.TomaLectura.TomaLecturaPresenter;
import ve.gob.fundelec.simlec.TomaLectura.TomaLecturaPresenterImpl;
import ve.gob.fundelec.simlec.TomaLectura.TomaLecturaRepository;
import ve.gob.fundelec.simlec.TomaLectura.TomaLecturaRepositoryImpl;
import ve.gob.fundelec.simlec.TomaLectura.ui.TomaLecturaView;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 10/08/17.
 */
@Module
public class TomaLecturaModule {
    private TomaLecturaView view;

    public TomaLecturaModule(TomaLecturaView view) {
        this.view = view;
    }

    @Provides
    @Singleton
    TomaLecturaPresenter providesTomaLecturaPresenter(EventBus eventBus, TomaLecturaView view, TomaLecturaInteractor interactor){
        return new TomaLecturaPresenterImpl(eventBus, view, interactor);
    }

    @Provides
    @Singleton
    TomaLecturaInteractor providesTomaLecturaInteractor(TomaLecturaRepository repository){
        return new TomaLecturaInteractorImpl(repository);
    }

    @Provides
    @Singleton
    TomaLecturaRepository providesTomaLecturaRepository(EventBus eventBus, LectorSessionManager sessionManager){
        return new TomaLecturaRepositoryImpl(eventBus, sessionManager);
    }

    @Provides
    @Singleton
    TomaLecturaView providesTomaLecturaView(){
        return this.view;
    }

}
