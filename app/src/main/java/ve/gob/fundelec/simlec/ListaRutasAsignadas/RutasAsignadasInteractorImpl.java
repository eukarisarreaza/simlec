package ve.gob.fundelec.simlec.ListaRutasAsignadas;

/**
 * Created by fundelec on 19/07/17.
 */

public class RutasAsignadasInteractorImpl implements RutasAsignadasInteractor {
    private RutasAsignadasRepository repository;

    public RutasAsignadasInteractorImpl(RutasAsignadasRepository repository) {
        this.repository = repository;
    }
}
