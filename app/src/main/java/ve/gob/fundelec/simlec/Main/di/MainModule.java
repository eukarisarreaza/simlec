package ve.gob.fundelec.simlec.Main.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ve.gob.fundelec.simlec.Main.MainIteractor;
import ve.gob.fundelec.simlec.Main.MainIteractorImpl;
import ve.gob.fundelec.simlec.Main.MainPressenter;
import ve.gob.fundelec.simlec.Main.MainPressenterImpl;
import ve.gob.fundelec.simlec.Main.MainRepository;
import ve.gob.fundelec.simlec.Main.MainRepositoryImpl;
import ve.gob.fundelec.simlec.Main.ui.MainView;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 10/07/17.
 */
@Module
public class MainModule {
    private MainView view;

    public MainModule(MainView view) {
        this.view = view;
    }

    @Provides
    @Singleton
    MainPressenter providesMainPressenter(EventBus eventBus, MainView view, MainIteractor interactor){
        return new MainPressenterImpl(eventBus, view, interactor);
    }

    @Provides
    @Singleton
    MainIteractor providesMainIteractor(MainRepository repository){
        return new MainIteractorImpl(repository);
    }

    @Provides
    @Singleton
    MainRepository providesMainRepository(){
        return new MainRepositoryImpl();
    }


    @Provides
    @Singleton
    MainView providesMainView(){
        return this.view;
    }


}
