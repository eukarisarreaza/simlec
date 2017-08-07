package ve.gob.fundelec.simlec.ListMedidores;

/**
 * Created by fundelec on 01/08/17.
 */

public interface RecorridoRepository {
    void registerHistory();
    void getMedidorInicio();
    void getNombreObjetoConexionSeleccionado();

    void getProximoMedidor();
    void getPrevioMedidor();

    void añadirSobrante();
    void actualizarPresinto();

}
