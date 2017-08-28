package ve.gob.fundelec.simlec.Reporte.event;

/**
 * Created by fundelec on 28/08/17.
 */

public class ReportEvent {
    public static final int showListRutas=1;

    public static final int onError=2;

    private int eventType;
    private String message;

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
}
