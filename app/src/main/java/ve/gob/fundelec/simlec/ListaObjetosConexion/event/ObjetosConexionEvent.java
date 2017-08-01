package ve.gob.fundelec.simlec.ListaObjetosConexion.event;

import java.util.List;

import ve.gob.fundelec.simlec.ListaCallesAvenidas.entities.QueryCalles;
import ve.gob.fundelec.simlec.ListaRutasAsignadas.entities.QueryRutas;
import ve.gob.fundelec.simlec.ListaObjetosConexion.entities.QueryObjetoConexion;

/**
 * Created by fundelec on 26/07/17.
 */

public class ObjetosConexionEvent {
    public final static int showInfoRuta = 0;
    public final static int showInfoCalle = 1;
    public final static int showListasObjetos = 2;

    private int eventType;
    private QueryRutas ruta;
    private QueryCalles calles;
    private List<QueryObjetoConexion> lista;

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

    public QueryCalles getCalles() {
        return calles;
    }

    public void setCalles(QueryCalles calles) {
        this.calles = calles;
    }

    public List<QueryObjetoConexion> getLista() {
        return lista;
    }

    public void setLista(List<QueryObjetoConexion> lista) {
        this.lista = lista;
    }
}
