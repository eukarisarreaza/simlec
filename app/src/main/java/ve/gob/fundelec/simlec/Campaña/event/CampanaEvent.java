package ve.gob.fundelec.simlec.Campaña.event;

import java.util.List;

import ve.gob.fundelec.simlec.DataBase.entities.Medidores;

/**
 * Created by fundelec on 07/09/17.
 */

public class CampanaEvent {
    public static final int showListMedidores=1;

    private int eventType;
    List<Medidores> listMedidores;

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }


    public List<Medidores> getListMedidores() {
        return listMedidores;
    }

    public void setListMedidores(List<Medidores> listMedidores) {
        this.listMedidores = listMedidores;
    }
}
