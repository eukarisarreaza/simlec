package ve.gob.fundelec.simlec.Main;

import android.util.Log;

import org.greenrobot.eventbus.Subscribe;

import ve.gob.fundelec.simlec.Configuracion;
import ve.gob.fundelec.simlec.Main.event.MainEvent;
import ve.gob.fundelec.simlec.Main.event.RecorridoEvent;
import ve.gob.fundelec.simlec.Main.ui.MainView;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 10/07/17.
 */

public class MainPressenterImpl implements MainPressenter {
    private EventBus eventBus;
    private MainView view;
    private MainIteractor iteractor;
    private static final String TAG= MainPressenterImpl.class.getName();


    public MainPressenterImpl(EventBus eventBus, MainView view, MainIteractor interactor) {
        this.eventBus = eventBus;
        this.view = view;
        this.iteractor = interactor;
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        eventBus.unregister(this);
        view=null;
    }

    @Subscribe
    @Override
    public void onEventMainThread(MainEvent event) {
        switch (event.getEventType()){
            case MainEvent.onBackPress:
                if(view!=null)
                    view.onBackPress();
                break;
            case MainEvent.onButtonMenu:
                if(view!=null)
                    view.onButtonMenu();
                break;
            case MainEvent.onClickSobrante:
                if(view!=null)
                    view.aparatoSobrante();
                break;
            case MainEvent.onSearch:
                if(view!=null)
                    view.onSearch();
                break;
            case MainEvent.showListMenu:
                if(view!=null)
                    view.showListOpciones(event.getList());
                break;
            case MainEvent.showFragmentInicio:
                if(view!=null)
                    showFragmentInicio(event.getFragment());
                break;
        }
    }

    @Subscribe
    @Override
    public void onEventRecorrido(RecorridoEvent event) {

        switch (event.getEventType()){
            case RecorridoEvent.onClickCalleAv:
                Log.e(TAG, "onClickCalleAv");
                view.listaObjetosConexion();
                break;

            case RecorridoEvent.onClickRuta:
                Log.e(TAG, "onClickRuta");
                view.listaCallesAvenidas();
                break;

            case RecorridoEvent.onClickObjetoConexion:
                Log.e(TAG, "onClickObjetoConexion");
                view.lecturaGestionar();
                break;
        }
    }


    private void showFragmentInicio(String ruta_fragment){
        if(ruta_fragment.equals(Configuracion.PantallasRecorridoRutas.LISTA_RUTAS_ASIGNADAS.name())){
            view.listaRutasAsignadas();
        }else
        if(ruta_fragment.equals(Configuracion.PantallasRecorridoRutas.LISTA_CALLES_AVENIDAS.name())){
            view.listaCallesAvenidas();
        }else
        if(ruta_fragment.equals(Configuracion.PantallasRecorridoRutas.LISTA_CENTROS_MEDICION.name())){
            view.listaObjetosConexion(); /** LISTA DE OBJETOS DE CONEXION O CENTROS DE MEDICION */
        }else
        if(ruta_fragment.equals(Configuracion.PantallasRecorridoRutas.LECTURA_GESTIONAR.name())){
            view.lecturaGestionar();
        }
    }

    @Override
    public void getListItenMenu() {
        iteractor.getListMenu();
    }

    @Override
    public void getInicio() {
        iteractor.getInicio();
    }

    @Override
    public void onBackPress() {
        iteractor.onBackPress();
    }

    @Override
    public void salir() {
        iteractor.salir();
    }

}
