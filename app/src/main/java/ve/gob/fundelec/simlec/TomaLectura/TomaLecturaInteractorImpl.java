package ve.gob.fundelec.simlec.TomaLectura;

/**
 * Created by fundelec on 10/08/17.
 */

public class TomaLecturaInteractorImpl implements TomaLecturaInteractor {
    private TomaLecturaRepository repository;

    public TomaLecturaInteractorImpl(TomaLecturaRepository repository) {
        this.repository = repository;
    }
}
