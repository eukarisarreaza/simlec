package ve.gob.fundelec.simlec.TomaLectura;

/**
 * Created by fundelec on 10/08/17.
 */

public class TomaLecturaInteractorImpl implements TomaLecturaInteractor {
    private TomaLecturaRepository repository;

    public TomaLecturaInteractorImpl(TomaLecturaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void getNotasLectura() {
        this.repository.getNotasLectura();
    }

    @Override
    public void grabarNotaLectura(int pos) {
        this.grabarNotaLectura(pos);
    }

    @Override
    public void grabarLectura(String lectura) {
        this.repository.grabarLectura(lectura);
    }
}
