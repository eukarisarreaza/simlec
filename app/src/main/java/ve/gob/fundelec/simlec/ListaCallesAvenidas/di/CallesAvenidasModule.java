package ve.gob.fundelec.simlec.ListaCallesAvenidas.di;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ve.gob.fundelec.simlec.LectorSessionManager;
import ve.gob.fundelec.simlec.ListaCallesAvenidas.CallesAvenidasInteractor;
import ve.gob.fundelec.simlec.ListaCallesAvenidas.CallesAvenidasInteractorImpl;
import ve.gob.fundelec.simlec.ListaCallesAvenidas.CallesAvenidasPressenter;
import ve.gob.fundelec.simlec.ListaCallesAvenidas.CallesAvenidasPressenterImpl;
import ve.gob.fundelec.simlec.ListaCallesAvenidas.CallesAvenidasRepository;
import ve.gob.fundelec.simlec.ListaCallesAvenidas.CallesAvenidasRepositoryImpl;
import ve.gob.fundelec.simlec.ListaCallesAvenidas.adapter.AdapterCallesAvenidas;
import ve.gob.fundelec.simlec.ListaCallesAvenidas.adapter.OnClickCallesAvenidas;
import ve.gob.fundelec.simlec.ListaCallesAvenidas.entities.QueryCalles;
import ve.gob.fundelec.simlec.ListaCallesAvenidas.ui.CallesAvenidasView;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 25/07/17.
 */

@Module
public class CallesAvenidasModule {
    private CallesAvenidasView view;
    private OnClickCallesAvenidas listener;

    public CallesAvenidasModule(CallesAvenidasView view, OnClickCallesAvenidas listener) {
        this.view = view;
        this.listener = listener;
    }

    @Provides
    @Singleton
    CallesAvenidasPressenter providesCallesAvenidasPressenter(EventBus eventBus, CallesAvenidasView view, CallesAvenidasInteractor interactor){
        return new CallesAvenidasPressenterImpl(eventBus, view, interactor);
    }

    @Provides
    @Singleton
    CallesAvenidasInteractor providesCallesAvenidasInteractor(CallesAvenidasRepository repository){
        return new CallesAvenidasInteractorImpl(repository);
    }

    @Provides
    @Singleton
    CallesAvenidasRepository providesCallesAvenidasRepository(LectorSessionManager sessionManager, EventBus eventBus){
        return new CallesAvenidasRepositoryImpl(sessionManager, eventBus);
    }

    @Provides
    @Singleton
    AdapterCallesAvenidas providesAdapterCallesAvenidas(List<QueryCalles> datos, OnClickCallesAvenidas onItemClickListener){
        return new AdapterCallesAvenidas(datos, onItemClickListener);
    }

    @Provides
    @Singleton
    OnClickCallesAvenidas providesOnClickCallesAvenidas(){
        return this.listener;
    }

    @Provides
    @Singleton
    List<QueryCalles> providesQueryCallesList(){
        return new ArrayList<QueryCalles>();
    }
    @Provides
    @Singleton
    CallesAvenidasView providesCallesAvenidasView(){
        return this.view;
    }
}
