package ve.gob.fundelec.simlec.Main;

import android.icu.util.ValueIterator;

import org.greenrobot.eventbus.Subscribe;

import ve.gob.fundelec.simlec.Configuracion;
import ve.gob.fundelec.simlec.Main.event.MainEvent;
import ve.gob.fundelec.simlec.Main.ui.MainView;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 10/07/17.
 */

public class MainPressenterImpl implements MainPressenter {
    private EventBus eventBus;
    private MainView view;
    private MainIteractor iteractor;

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
                break;
            case MainEvent.onButtonMenu:
                break;
            case MainEvent.onClickPresinto:
                break;
            case MainEvent.onClickSobrante:
                break;
            case MainEvent.onSearch:
                break;
            case MainEvent.showListMenu:
                view.showListOpciones(event.getList());
                break;
            case MainEvent.showFragmentInicio:
                showFragmentInicio(event.getFragment());
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
    public void salir() {
        iteractor.salir();
    }

}
