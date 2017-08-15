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
    public void getInfoRuta() {
        repository.getInfoRuta();
    }

    @Override
    public void grabarNotaLectura(int pos) {
        this.repository.grabarNotaLectura(pos);
    }

    @Override
    public void grabarLectura(String kva, String va) {
        this.repository.grabarLecturaKva(kva);
        this.repository.grabarLecturaVa(va);
    }

    @Override
    public void getParametrosLectura() {
        repository.getParametrosLectura();
    }
}
