package ve.gob.fundelec.simlec.Recorrido.event;

/**
 * Created by fundelec on 01/08/17.
 */

public class LecturasEvent {

    public final static int showNombreObjetoConexion= 1;


    private int eventType;
    private String nom_medidor;


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
}
