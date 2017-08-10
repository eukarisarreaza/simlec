package ve.gob.fundelec.simlec.LecturaGestionar;

/**
 * Created by fundelec on 10/08/17.
 */

public interface LecturaGestionarRepository {
    void getInfoRuta();
    void getNotasLectura();
    void grabarNotaUnidadLectura(int pos);
}
