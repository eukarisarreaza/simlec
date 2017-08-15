package ve.gob.fundelec.simlec.TomaLectura.event;

import ve.gob.fundelec.simlec.ListMedidores.entities.QueryMedidores;
import ve.gob.fundelec.simlec.ListaRutasAsignadas.entities.QueryRutas;
import ve.gob.fundelec.simlec.ListadoCentrosMedicion.entities.QueryObjetoConexion;

/**
 * Created by fundelec on 10/08/17.
 */

public class TomaLecturaEvent {

    public static final int onSussesGrabarNota=1;
    public static final int onFailedGrabarNota=2;
    public static final int showListNotas=3;
    public static final int showInfoRuta=4;
    public static final int showInfoMedidor=5;

    private int eventType;
    private String message;
    private String[] notasLectura;
    private QueryRutas ruta;
    private QueryObjetoConexion objetoConexion;
    private QueryMedidores medidor;


    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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


    public QueryMedidores getMedidor() {
        return medidor;
    }

    public void setMedidor(QueryMedidores medidor) {
        this.medidor = medidor;
    }

    public QueryObjetoConexion getObjetoConexion() {
        return objetoConexion;
    }

    public void setObjetoConexion(QueryObjetoConexion objetoConexion) {
        this.objetoConexion = objetoConexion;
    }
}
