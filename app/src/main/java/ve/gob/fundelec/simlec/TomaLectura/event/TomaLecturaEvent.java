package ve.gob.fundelec.simlec.TomaLectura.event;

/**
 * Created by fundelec on 10/08/17.
 */

public class TomaLecturaEvent {


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
