package ve.gob.fundelec.simlec.ListaRutasAsignadas;

import org.greenrobot.eventbus.Subscribe;

import ve.gob.fundelec.simlec.Configuracion;
import ve.gob.fundelec.simlec.DataBase.entities.Lector;
import ve.gob.fundelec.simlec.ListaRutasAsignadas.event.RutasAsignadasEvent;
import ve.gob.fundelec.simlec.ListaRutasAsignadas.ui.RutasAsignadasView;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 19/07/17.
 */

public class RutasAsignadasPresenterImpl implements RutasAsignadasPresenter{
    private EventBus eventBus;
    private RutasAsignadasView view;
    private RutasAsignadasInteractor interactor;


    public RutasAsignadasPresenterImpl(EventBus eventBus, RutasAsignadasView view, RutasAsignadasInteractor interactor) {
        this.eventBus = eventBus;
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        eventBus.unregister(this);
    }

    @Subscribe
    @Override
    public void onEventMainThread(RutasAsignadasEvent event) {
        switch (event.getEventType()){
            case RutasAsignadasEvent.showInfoUser:
                Lector lector= event.getLector();
                switch (lector.getRol_operador()){
                    case 1:
                        view.showInfoUser(lector.getNom_lector()+" "+lector.getPrimer_apell(), Configuracion.TipoUsuario.LECTOR.name());

                        break;
                    case 2:
                        view.showInfoUser(lector.getNom_lector()+" "+lector.getPrimer_apell(), Configuracion.TipoUsuario.SUPERVISOR.name());
                        break;
                    case 3:
                        view.showInfoUser(lector.getNom_lector()+" "+lector.getPrimer_apell(), Configuracion.TipoUsuario.ADMINISTRADOR.name());
                        break;
                }
                break;
            case RutasAsignadasEvent.showListRutasBloquedas:
                break;
            case RutasAsignadasEvent.showListRutasEnCurso:
                view.showListRutasCurso(event.getListRutas());
                break;
            case RutasAsignadasEvent.showVersionApp:
                view.showVersionName(event.getVersionApp());
                break;
        }
    }

    @Override
    public void getListRutas() {
        interactor.getListRutas();
    }

    @Override
    public void getInfoUser() {
        interactor.getInfoUser();
    }

    @Override
    public void getVersionApp() {
        interactor.getVersionApp();
    }

    @Override
    public void getUltimoInicio() {
        interactor.getUltimoInicio();
    }
}
