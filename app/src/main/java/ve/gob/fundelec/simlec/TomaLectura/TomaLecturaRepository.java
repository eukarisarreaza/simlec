package ve.gob.fundelec.simlec.TomaLectura;

/**
 * Created by fundelec on 10/08/17.
 */

public interface TomaLecturaRepository {
    void getNotasLectura();
    void getInfoRuta();
    void grabarNotaLectura(int pos);
    void grabarLecturaKva(String lectura);
    void grabarLecturaVa(String lectura);
    void actualizarFechaLectura();
    void getParametrosLectura();
}
