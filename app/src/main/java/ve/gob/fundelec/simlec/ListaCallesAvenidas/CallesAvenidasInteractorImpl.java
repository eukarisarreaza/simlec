package ve.gob.fundelec.simlec.ListaCallesAvenidas;

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
        this.repository.getListCalles();
    }
}
