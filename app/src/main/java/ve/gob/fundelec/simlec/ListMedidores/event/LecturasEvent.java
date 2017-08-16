package ve.gob.fundelec.simlec.ListMedidores.event;

/**
 * Created by fundelec on 01/08/17.
 */

public class LecturasEvent {

    public final static int showNombreObjetoConexion= 1;
    public final static int showUnidadLecturaGestionar= 2;
    public final static int valorLectura= 3;
    public final static int notifyError= 4;
    public final static int actualizarPresinto= 5;

    private int eventType;
    private String message;
    private String nom_medidor;
    private String retirado, actual;


    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public String getNom_medidor() {
        return nom_medidor;
    }

    public void setNom_medidor(String nom_medidor) {
        this.nom_medidor = nom_medidor;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
}
