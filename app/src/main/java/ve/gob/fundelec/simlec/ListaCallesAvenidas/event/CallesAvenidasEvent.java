package ve.gob.fundelec.simlec.ListaCallesAvenidas.event;

import java.util.List;

import ve.gob.fundelec.simlec.ListaCallesAvenidas.entities.QueryCalles;
import ve.gob.fundelec.simlec.ListaRutasAsignadas.entities.QueryRutas;

/**
 * Created by fundelec on 25/07/17.
 */

public class CallesAvenidasEvent {
    public final static int showInfoRuta= 1;
    public final static int showListCalles = 2;

    private int eventType;
    private QueryRutas ruta;
    private List<QueryCalles> listCallesAv;

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public QueryRutas getRuta() {
        return ruta;
    }

    public void setRuta(QueryRutas ruta) {
        this.ruta = ruta;
    }


    public List<QueryCalles> getListCallesAv() {
        return listCallesAv;
    }

    public void setListCallesAv(List<QueryCalles> listCallesAv) {
        this.listCallesAv = listCallesAv;
    }
}
