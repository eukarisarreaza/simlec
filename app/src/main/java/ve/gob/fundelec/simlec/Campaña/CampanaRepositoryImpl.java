package ve.gob.fundelec.simlec.Campaña;

import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.ArrayList;
import java.util.List;

import ve.gob.fundelec.simlec.Campaña.event.CampanaEvent;
import ve.gob.fundelec.simlec.DataBase.entities.Medidores;
import ve.gob.fundelec.simlec.LectorSessionManager;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 14/07/17.
 */

public class CampanaRepositoryImpl implements CampanaRepository {
    private EventBus eventBus;
    private LectorSessionManager sessionManager;
    List<Medidores> medidoresList;

    public CampanaRepositoryImpl(EventBus eventBus, LectorSessionManager sessionManager) {
        this.eventBus = eventBus;
        this.sessionManager = sessionManager;

        setListMedidores();
    }

    private void setListMedidores() {
        medidoresList = new Select()
                .from(Medidores.class)
                .queryList();
    }

    @Override
    public void getListMedidores(String codigo) {
        List<Medidores> list = new ArrayList<>();

        for (Medidores medidores : medidoresList) {
            if (medidores.getNumero().contains(codigo)) {
                list.add(medidores);
            }
        }
        postEvent(CampanaEvent.showListMedidores, list);

    }

    private void postEvent(int enventType, List<Medidores> list){
        CampanaEvent event= new CampanaEvent();
        event.setEventType(enventType);
        event.setListMedidores(list);
        eventBus.post(event);
    }



}
