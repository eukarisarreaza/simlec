package ve.gob.fundelec.simlec.ListMedidores;

import android.util.Log;

import org.greenrobot.eventbus.Subscribe;

import ve.gob.fundelec.simlec.ListMedidores.event.LecturasEvent;
import ve.gob.fundelec.simlec.ListMedidores.ui.RecorridoView;
import ve.gob.fundelec.simlec.TomaLectura.event.TomaLecturaEvent;
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
            case LecturasEvent.showUnidadLecturaGestionar:
                Log.e(TAG, "PROXIMO OBJETO DE CONEXION ");
                if(view!=null)
                    view.lecturaGestionar(event.getPosicionObj());
                break;
            case LecturasEvent.valorLectura:
                Log.e(TAG, "PROXIMO MEDIDOR");
                if(view!=null)
                    view.valorLectura(event.getPosicionMedidor());
                break;
            case LecturasEvent.notifyError:
                if(view!=null)
                    view.showNotify(event.getMessage());
                break;
            case LecturasEvent.actualizarPresinto:
                if(view!=null)
                    view.dialogoActualizarPresinto(event.getRetirado());
                break;

            case LecturasEvent.selectObjetoConexion:
                if(view!=null){
                    view.mostrarBotonesSiguinteMedidor();
                    view.ocultarBotonesSiguienteObjConexion();
                    interactor.onSelectObjetoConexion();
                }
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

    @Override
    public void proximoMedidor() {
        interactor.proximoMedidor();
    }

    @Override
    public void anteriorMedidor() {
        interactor.anteriorMedidor();
    }

    @Override
    public void proximoObjetoConexion() {
        interactor.proximoObjetoConexion();
    }

    @Override
    public void anteriorObjetoConexion() {
        interactor.anteriorObjetoConexion();
    }

    @Override
    public void actualizarPresinto(String retirado, String actual) {
        interactor.actualizarPresinto(retirado, actual);
    }

    @Override
    public void saveLecrura() {
        interactor.saveLectura();
    }

    @Override
    public void selectLetterP() {
        interactor.selectLetterP();
    }
}
