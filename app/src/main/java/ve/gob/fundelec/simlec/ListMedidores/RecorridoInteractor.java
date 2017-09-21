package ve.gob.fundelec.simlec.ListMedidores;

/**
 * Created by fundelec on 01/08/17.
 */

public interface RecorridoInteractor {
    void getFragmentInicio();
    void onSelectObjetoConexion();
    void registrarFragment();
    void proximoMedidor();
    void anteriorMedidor();
    void proximoObjetoConexion();
    void anteriorObjetoConexion();
    void actualizarPresinto(String retirado, String actual);
    void saveLectura();
    void selectLetterP();
}
