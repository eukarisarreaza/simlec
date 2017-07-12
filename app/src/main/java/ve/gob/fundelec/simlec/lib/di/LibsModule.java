package ve.gob.fundelec.simlec.lib.di;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ve.gob.fundelec.simlec.lib.GreenRobotEventBus;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by Eukaris on 24/04/2017.
 */
@Module
public class LibsModule {

    public LibsModule() {
    }

    @Provides
    @Singleton
    EventBus providesEventBus(org.greenrobot.eventbus.EventBus eventBus){
        return new GreenRobotEventBus(eventBus);
    }

    @Provides
    @Singleton
    org.greenrobot.eventbus.EventBus providesLibraryEventBus(){
        return new org.greenrobot.eventbus.EventBus().getDefault();
    }

}
