package ve.gob.fundelec.simlec.Login.ui;

/**
 * Created by fundelec on 12/07/17.
 */

public interface LoginView {
    void onSelectLector();
    void onSelectSupervisor();
    void onSelectAdministrador();

    void showProgressDialogo();
    void hideProgressDialogo();

    void iniciar();
    void showMainActivity();
}
