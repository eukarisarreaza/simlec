package ve.gob.fundelec.simlec.Campaña.event;

/**
 * Created by fundelec on 07/09/17.
 */

public class CampanaEvent {
    public static final int showListMedidores=1;

    private int eventType;

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }
}
