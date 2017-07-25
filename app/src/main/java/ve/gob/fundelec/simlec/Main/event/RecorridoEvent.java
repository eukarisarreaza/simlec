package ve.gob.fundelec.simlec.Main.event;


/**
 * Created by fundelec on 25/07/17.
 */

public class RecorridoEvent {
    public final static int onClickRuta = 3;
    public final static int onClickCalleAv = 4;

    private int eventType;


    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

}
