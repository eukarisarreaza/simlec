package ve.gob.fundelec.simlec.LecturaGestionar.event;

import ve.gob.fundelec.simlec.ListMedidores.entities.QueryMedidores;
import ve.gob.fundelec.simlec.ListaCallesAvenidas.entities.QueryCalles;
import ve.gob.fundelec.simlec.ListaRutasAsignadas.entities.QueryRutas;
import ve.gob.fundelec.simlec.ListadoCentrosMedicion.entities.QueryObjetoConexion;

/**
 * Created by fundelec on 10/08/17.
 */

public class LecturaGestionarEvent {
    public static final int onSussesGrabarNota=1;
    public static final int onFailedGrabarNota=2;
    public static final int showListNotas=3;
    public static final int showInfoRuta=4;
    public static final int grabarNotaLectura=5;

    private String message;
    private int EventType;
    private String[] notasLectura;
    private QueryRutas ruta;
    private QueryCalles calle;
    private QueryObjetoConexion objetoConexion;
    private QueryMedidores medidor;
    private int posNotaLectura;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getEventType() {
        return EventType;
    }

    public void setEventType(int eventType) {
        EventType = eventType;
    }

    public String[] getNotasLectura() {
        return notasLectura;
    }

    public void setNotasLectura(String[] notasLectura) {
        this.notasLectura = notasLectura;
    }


    public QueryRutas getRuta() {
        return ruta;
    }

    public void setRuta(QueryRutas ruta) {
        this.ruta = ruta;
    }


    public QueryCalles getCalle() {
        return calle;
    }

    public void setCalle(QueryCalles calle) {
        this.calle = calle;
    }

    public QueryObjetoConexion getObjetoConexion() {
        return objetoConexion;
    }

    public void setObjetoConexion(QueryObjetoConexion objetoConexion) {
        this.objetoConexion = objetoConexion;
    }

    public QueryMedidores getMedidor() {
        return medidor;
    }

    public void setMedidor(QueryMedidores medidor) {
        this.medidor = medidor;
    }

    public int getPosNotaLectura() {
        return posNotaLectura;
    }

    public void setPosNotaLectura(int posNotaLectura) {
        this.posNotaLectura = posNotaLectura;
    }
}
