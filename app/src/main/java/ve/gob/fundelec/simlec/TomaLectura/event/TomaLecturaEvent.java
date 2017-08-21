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
    public static final int showInfoIndicadorLectura=6;

    public static final int saveLectura=7;
    public static final int onSussesGrabarLectura=8;
    public static final int onFailedGrabarLcetura=9;

    private int eventType;
    private String message;
    private String[] notasLectura;
    private QueryRutas ruta;
    private QueryObjetoConexion objetoConexion;
    private QueryMedidores medidor;
    private String kva;
    private String va;

    private String retirado;
    private String actual;


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

    public String getRetirado() {
        return retirado;
    }

    public void setRetirado(String retirado) {
        this.retirado = retirado;
    }

    public String getActual() {
        return actual;
    }

    public void setActual(String actual) {
        this.actual = actual;
    }

    public String getKva() {
        return kva;
    }

    public void setKva(String kva) {
        this.kva = kva;
    }

    public String getVa() {
        return va;
    }

    public void setVa(String va) {
        this.va = va;
    }
}
