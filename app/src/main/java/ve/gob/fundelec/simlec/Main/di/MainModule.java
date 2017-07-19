package ve.gob.fundelec.simlec.Main.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ve.gob.fundelec.simlec.LectorSessionManager;
import ve.gob.fundelec.simlec.Main.MainIteractor;
import ve.gob.fundelec.simlec.Main.MainIteractorImpl;
import ve.gob.fundelec.simlec.Main.MainPressenter;
import ve.gob.fundelec.simlec.Main.MainPressenterImpl;
import ve.gob.fundelec.simlec.Main.MainRepository;
import ve.gob.fundelec.simlec.Main.MainRepositoryImpl;
import ve.gob.fundelec.simlec.Main.UserRepository;
import ve.gob.fundelec.simlec.Main.UserRepositoryImpl;
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
    MainIteractor providesMainIteractor(MainRepository repository, UserRepository userRepository){
        return new MainIteractorImpl(repository, userRepository);
    }

    @Provides
    @Singleton
    UserRepository providesUserRepository(LectorSessionManager sessionManager){
        return new UserRepositoryImpl(sessionManager);
    }

    @Provides
    @Singleton
    MainRepository providesMainRepository(EventBus eventBus, LectorSessionManager sessionManager, Context context){
        return new MainRepositoryImpl(eventBus, sessionManager, context);
    }

    @Provides
    @Singleton
    MainView providesMainView(){
        return this.view;
    }


}
