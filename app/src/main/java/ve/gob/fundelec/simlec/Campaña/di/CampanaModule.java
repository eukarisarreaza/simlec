package ve.gob.fundelec.simlec.Campaña.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ve.gob.fundelec.simlec.Campaña.CampanaInteractor;
import ve.gob.fundelec.simlec.Campaña.CampanaInteractorImpl;
import ve.gob.fundelec.simlec.Campaña.CampanaPresenter;
import ve.gob.fundelec.simlec.Campaña.CampanaPresenterImpl;
import ve.gob.fundelec.simlec.Campaña.CampanaRepository;
import ve.gob.fundelec.simlec.Campaña.CampanaRepositoryImpl;
import ve.gob.fundelec.simlec.Campaña.ui.CampanaView;
import ve.gob.fundelec.simlec.LectorSessionManager;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 14/07/17.
 */
@Module
public class CampanaModule {
    private CampanaView view;

    public CampanaModule(CampanaView view) {
        this.view = view;
    }

    @Provides
    @Singleton
    CampanaPresenter providesCampanaPresenter(EventBus eventBus, CampanaInteractor interactor, CampanaView view){
        return new CampanaPresenterImpl(eventBus, interactor, view);
    }

    @Provides
    @Singleton
    CampanaInteractor providesCampanaInteractor(CampanaRepository repository){
        return new CampanaInteractorImpl(repository);
    }

    @Provides
    @Singleton
    CampanaRepository providesCampanaRepository(EventBus eventBus, LectorSessionManager sessionManager){
        return new CampanaRepositoryImpl(eventBus, sessionManager);
    }

    @Provides
    @Singleton
    CampanaView providesCampanaView(){
        return this.view;
    }

}
