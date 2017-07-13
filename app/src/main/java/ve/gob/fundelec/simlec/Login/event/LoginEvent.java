package ve.gob.fundelec.simlec.Login.event;

/**
 * Created by fundelec on 12/07/17.
 */

public class LoginEvent {
    public final static int onLoginError = 0;
    public final static int onLoginSuccess = 1;
    private int eventType;
    private String errorMessage;

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }


    public String getErrosMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errosMessage) {
        this.errorMessage = errosMessage;
    }
}
