package ve.gob.fundelec.simlec.TomaLectura;

/**
 * Created by fundelec on 10/08/17.
 */

public interface TomaLecturaInteractor {
    void getNotasLectura();
    void getInfoRuta();
    void grabarNotaLectura(int pos);
    void grabarLectura(String lectura1, String lectura2);
    void getParametrosLectura();
}
