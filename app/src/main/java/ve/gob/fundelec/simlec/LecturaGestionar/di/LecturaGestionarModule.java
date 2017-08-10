package ve.gob.fundelec.simlec.LecturaGestionar.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ve.gob.fundelec.simlec.LectorSessionManager;
import ve.gob.fundelec.simlec.LecturaGestionar.LecturaGestionarInteractor;
import ve.gob.fundelec.simlec.LecturaGestionar.LecturaGestionarInteractorImpl;
import ve.gob.fundelec.simlec.LecturaGestionar.LecturaGestionarPresenter;
import ve.gob.fundelec.simlec.LecturaGestionar.LecturaGestionarPresenterImpl;
import ve.gob.fundelec.simlec.LecturaGestionar.LecturaGestionarRepository;
import ve.gob.fundelec.simlec.LecturaGestionar.LecturaGestionarRepositoryImpl;
import ve.gob.fundelec.simlec.LecturaGestionar.ui.LecturaGestionarView;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 10/08/17.
 */
@Module
public class LecturaGestionarModule {
    private LecturaGestionarView view;

    public LecturaGestionarModule(LecturaGestionarView view) {
        this.view = view;
    }

    @Provides
    @Singleton
    LecturaGestionarPresenter providesLecturaGestionarPresenter(EventBus eventBus, LecturaGestionarView view, LecturaGestionarInteractor interactor){
        return new LecturaGestionarPresenterImpl(eventBus, view, interactor);
    }


    @Provides
    @Singleton
    LecturaGestionarInteractor providesLecturaGestionarInteractor(LecturaGestionarRepository repository){
        return new LecturaGestionarInteractorImpl(repository);
    }



    @Provides
    @Singleton
    LecturaGestionarRepository providesLecturaGestionarRepository(EventBus eventBus, LectorSessionManager sessionManager){
        return new LecturaGestionarRepositoryImpl(eventBus, sessionManager);
    }

    @Provides
    @Singleton
    LecturaGestionarView providesLecturaGestionarView(){
        return this.view;
    }
}
