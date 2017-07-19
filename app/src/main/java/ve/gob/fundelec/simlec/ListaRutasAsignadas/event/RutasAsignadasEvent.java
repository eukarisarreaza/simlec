package ve.gob.fundelec.simlec.ListaRutasAsignadas.event;

/**
 * Created by fundelec on 19/07/17.
 */

public class RutasAsignadasEvent {
    public final static int showListRutasEnCurso= 1;
    public final static int showListRutasBloquedas= 2;
    public final static int showInfoUser = 3;

    private int eventType;
    private String errorMessage;


    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
