package ve.gob.fundelec.simlec.Login.event;

/**
 * Created by fundelec on 12/07/17.
 */

public class LoginEvent {
    public final static int onLoadMovimientosError = 0;
    public final static int onLoadMovimientosSuccess = 1;
    private int eventType;

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }
}
