package ve.gob.fundelec.simlec.ListaCallesAvenidas.event;

import ve.gob.fundelec.simlec.ListaRutasAsignadas.entities.QueryRutas;

/**
 * Created by fundelec on 25/07/17.
 */

public class CallesAvenidasEvent {
    public final static int showInfoRuta= 1;
    public final static int showLIstCalles= 2;

    private int eventType;
    private QueryRutas ruta;


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
}
