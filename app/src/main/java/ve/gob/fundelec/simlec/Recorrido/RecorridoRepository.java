package ve.gob.fundelec.simlec.Recorrido;

/**
 * Created by fundelec on 01/08/17.
 */

public interface RecorridoRepository {
    void registerHistory();
    void getMedidorInicio();


    void getProximoMedidor();
    void getPrevioMedidor();

    void añadirSobrante();
    void actualizarPresinto();

}
