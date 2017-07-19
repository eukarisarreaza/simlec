package ve.gob.fundelec.simlec.ListaRutasAsignadas;

/**
 * Created by fundelec on 19/07/17.
 */

public class RutasAsignadasInteractorImpl implements RutasAsignadasInteractor {
    private RutasAsignadasRepository repository;

    public RutasAsignadasInteractorImpl(RutasAsignadasRepository repository) {
        this.repository = repository;
    }

    @Override
    public void getInfoUser() {
        this.repository.getInfoUser();
    }

    @Override
    public void getListRutas() {
        this.repository.getListRutasAsignadsas();
        this.repository.getListRutasBloquedas();
    }

    @Override
    public void getUltimoInicio() {
        this.repository.getUltimoInicio();
    }

    @Override
    public void getVersionApp() {
        this.repository.getVersionApp();
    }
}
