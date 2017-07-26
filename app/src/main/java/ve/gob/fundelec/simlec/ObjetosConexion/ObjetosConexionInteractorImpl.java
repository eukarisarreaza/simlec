package ve.gob.fundelec.simlec.ObjetosConexion;

import ve.gob.fundelec.simlec.ObjetosConexion.entities.QueryObjetoConexion;

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
        repository.getRuta();
        repository.getInfoCalle();
    }

    @Override
    public void onSelectObjeto(QueryObjetoConexion objeto) {
        repository.onSelectObjeto(objeto);
    }
}
