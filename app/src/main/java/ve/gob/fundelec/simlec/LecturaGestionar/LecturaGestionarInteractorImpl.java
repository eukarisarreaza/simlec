package ve.gob.fundelec.simlec.LecturaGestionar;

/**
 * Created by fundelec on 10/08/17.
 */

public class LecturaGestionarInteractorImpl implements LecturaGestionarInteractor{
    private LecturaGestionarRepository repository;

    public LecturaGestionarInteractorImpl(LecturaGestionarRepository repository) {
        this.repository = repository;
    }

    @Override
    public void getListNotasLectura() {
        repository.getNotasLectura();

        repository.getInfoRuta();

    }

    @Override
    public void grabarNotaLectura(int pos) {
        repository.grabarNotaUnidadLectura(pos);
    }

    @Override
    public void onSelectObjeto() {
        repository.onSelectObjeto();
    }
}
