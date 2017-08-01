package ve.gob.fundelec.simlec.ListaObjetosConexion;

import ve.gob.fundelec.simlec.ListaObjetosConexion.entities.QueryObjetoConexion;

/**
 * Created by fundelec on 26/07/17.
 */

public class ObjetosConexionInteractorImpl implements ObjetosConexionInteractor{
    private ObjetosConexionRepository repository;

    public ObjetosConexionInteractorImpl(ObjetosConexionRepository repository) {
        this.repository = repository;
    }

    @Override
    public void getInfoRuta() {
        repository.registerHistory();
        repository.getRuta();
        repository.getInfoCalle();
    }

    @Override
    public void getListObjetosConexion() {
        repository.getListObjetosConexion();
    }

    @Override
    public void onSelectObjeto(QueryObjetoConexion objeto) {
        repository.onSelectObjeto(objeto);
    }
}
