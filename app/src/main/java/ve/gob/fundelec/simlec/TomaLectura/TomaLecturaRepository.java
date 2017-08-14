package ve.gob.fundelec.simlec.TomaLectura;

/**
 * Created by fundelec on 10/08/17.
 */

public interface TomaLecturaRepository {
    void getNotasLectura();
    void getInfoRuta();

    void grabarNotaLectura(int pos);
    void grabarLectura(String lectura);
}
