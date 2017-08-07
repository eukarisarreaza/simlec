package ve.gob.fundelec.simlec.Recorrido;

import android.util.Log;

import ve.gob.fundelec.simlec.Configuracion;
import ve.gob.fundelec.simlec.LectorSessionManager;
import ve.gob.fundelec.simlec.Recorrido.event.LecturasEvent;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 01/08/17.
 */

public class RecorridoRepositoryImpl implements RecorridoRepository {
    private static final String TAG= RecorridoRepositoryImpl.class.getName();
    private EventBus eventBus;
    private LectorSessionManager sessionManager;

    public RecorridoRepositoryImpl(EventBus eventBus, LectorSessionManager sessionManager) {
        this.eventBus = eventBus;
        this.sessionManager = sessionManager;
    }

    @Override
    public void registerHistory() {
        sessionManager.setRecorrido(Configuracion.PantallasRecorridoRutas.LECTURA_GESTIONAR);
    }

    @Override
    public void getMedidorInicio() {

    }

    @Override
    public void getNombreObjetoConexionSeleccionado() {
        Log.e(TAG, "OBEJETO "+sessionManager.getObjetConexion().getNom_obj_conex());
        postEventNomMedidor(LecturasEvent.showNombreObjetoConexion, sessionManager.getObjetConexion().getNom_obj_conex());
    }


    @Override
    public void getProximoMedidor() {

    }

    @Override
    public void getPrevioMedidor() {

    }

    @Override
    public void añadirSobrante() {

    }

    @Override
    public void actualizarPresinto() {

    }

    private void postEventNomMedidor(int eventType, String message) {
        LecturasEvent event= new LecturasEvent();
        event.setEventType(eventType);
        event.setNom_medidor(message);
        eventBus.post(event);
    }
}
