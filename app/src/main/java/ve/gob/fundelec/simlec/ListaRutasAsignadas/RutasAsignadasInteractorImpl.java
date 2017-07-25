package ve.gob.fundelec.simlec.ListaRutasAsignadas;

import ve.gob.fundelec.simlec.ListaRutasAsignadas.entities.QueryRutas;

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

    @Override
    public void onClickRuta(QueryRutas ruta) {
        this.repository.onClickRuta(ruta);
    }

    @Override
    public void registerHistory() {
        repository.registerHistory();
    }
}
