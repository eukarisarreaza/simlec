package ve.gob.fundelec.simlec.Recorrido;

/**
 * Created by fundelec on 01/08/17.
 */

public class RecorridoInteractorImpl implements RecorridoInteractor {
    private RecorridoRepository repository;

    public RecorridoInteractorImpl(RecorridoRepository repository) {
        this.repository = repository;
    }
}
