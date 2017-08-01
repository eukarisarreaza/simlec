package ve.gob.fundelec.simlec.Recorrido.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ve.gob.fundelec.simlec.LectorSessionManager;
import ve.gob.fundelec.simlec.Recorrido.RecorridoInteractor;
import ve.gob.fundelec.simlec.Recorrido.RecorridoInteractorImpl;
import ve.gob.fundelec.simlec.Recorrido.RecorridoPressenter;
import ve.gob.fundelec.simlec.Recorrido.RecorridoPressenterImpl;
import ve.gob.fundelec.simlec.Recorrido.RecorridoRepository;
import ve.gob.fundelec.simlec.Recorrido.RecorridoRepositoryImpl;
import ve.gob.fundelec.simlec.Recorrido.ui.RecorridoView;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 01/08/17.
 */
@Module
public class RecorridoModule {
    private RecorridoView view;

    public RecorridoModule(RecorridoView view) {
        this.view = view;
    }

    @Provides
    @Singleton
    RecorridoPressenter providesRecorridoPressenter(EventBus eventBus, RecorridoView view, RecorridoInteractor interactor){
        return new RecorridoPressenterImpl(eventBus, view, interactor);
    }

    @Provides
    @Singleton
    RecorridoInteractor providesRecorridoInteractor(RecorridoRepository repository){
        return new RecorridoInteractorImpl(repository);
    }

    @Provides
    @Singleton
    RecorridoRepository providesRecorridoRepository(EventBus eventBus, LectorSessionManager sessionManager){
        return new RecorridoRepositoryImpl(eventBus, sessionManager);
    }

    @Provides
    @Singleton
    RecorridoView providesRecorridoView(){
        return this.view;
    }
}
