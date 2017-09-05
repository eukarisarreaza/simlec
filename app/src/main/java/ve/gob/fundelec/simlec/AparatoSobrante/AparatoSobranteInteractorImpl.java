package ve.gob.fundelec.simlec.AparatoSobrante;

/**
 * Created by fundelec on 22/08/17.
 */

public class AparatoSobranteInteractorImpl implements AparatoSobranteInteractor{
    private AparatoSobranteRepository repository;

    public AparatoSobranteInteractorImpl(AparatoSobranteRepository repository) {
        this.repository = repository;
    }
}
