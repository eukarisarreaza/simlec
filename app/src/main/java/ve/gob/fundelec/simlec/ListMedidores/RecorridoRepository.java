package ve.gob.fundelec.simlec.ListMedidores;

/**
 * Created by fundelec on 01/08/17.
 */

public interface RecorridoRepository {
    void registerHistory();
    void getValorDeLectura();
    void getMedidorInicio();
    void getProximoMedidor();
    void getPrevioMedidor();
    void getProximoObjetoConexion();
    void getPrevioObjetoConexion();
    void actualizarPresinto(String retirado, String actual);
    void saveLectura();
    void saveNotaLectura();

    void selecLetterP();

}
