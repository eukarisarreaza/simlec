package ve.gob.fundelec.simlec.Campaña;

/**
 * Created by fundelec on 14/07/17.
 */

public class CampanaInteractorImpl implements CampanaInteractor{
    private CampanaRepository repository;

    public CampanaInteractorImpl(CampanaRepository repository) {
        this.repository = repository;
    }


    @Override
    public void getListMedidores(String codigo) {
        repository.getListMedidores(codigo);
    }
}
