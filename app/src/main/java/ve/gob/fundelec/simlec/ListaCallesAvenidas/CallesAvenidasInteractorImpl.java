package ve.gob.fundelec.simlec.ListaCallesAvenidas;

import ve.gob.fundelec.simlec.ListaCallesAvenidas.entities.QueryCalles;

/**
 * Created by fundelec on 25/07/17.
 */

public class CallesAvenidasInteractorImpl implements CallesAvenidasInteractor{
    private CallesAvenidasRepository repository;

    public CallesAvenidasInteractorImpl(CallesAvenidasRepository repository) {
        this.repository = repository;
    }

    @Override
    public void getListCalles() {
        this.repository.registerHistory();
        this.repository.getListCalles();
    }

    @Override
    public void onClickCalle(QueryCalles item) {
        repository.onClickCalle(item);
    }

    @Override
    public void getInfoRuta() {
        repository.getInfoRuta();



    }
}
