package ve.gob.fundelec.simlec.ListMedidores;

import org.greenrobot.eventbus.Subscribe;

import ve.gob.fundelec.simlec.ListMedidores.event.LecturasEvent;
import ve.gob.fundelec.simlec.ListMedidores.ui.RecorridoView;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 01/08/17.
 */

public class RecorridoPressenterImpl implements RecorridoPressenter{
    private static final String TAG= RecorridoPressenterImpl.class.getName();
    private EventBus eventBus;
    private RecorridoView view;
    private RecorridoInteractor interactor;


    public RecorridoPressenterImpl(EventBus eventBus, RecorridoView view, RecorridoInteractor interactor) {
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
    public void onEventMainThread(LecturasEvent event) {
        switch (event.getEventType()){
            case LecturasEvent.showNombreObjetoConexion:
                view.showNombreObjConexion(event.getNom_medidor());
                break;
            case LecturasEvent.showUnidadLecturaGestionar:
                view.lecturaGestionar();
                break;
            case LecturasEvent.valorLectura:
                view.valorLectura();
                break;

        }
    }


    @Override
    public void getFragmentInicio() {
        interactor.getFragmentInicio();
    }

    @Override
    public void registrarFragment() {
        interactor.registrarFragment();
    }
}
