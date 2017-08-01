package ve.gob.fundelec.simlec.Recorrido;

import ve.gob.fundelec.simlec.LectorSessionManager;
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
    public void getMedidorInicio() {

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
}
