package ve.gob.fundelec.simlec.ObjetosConexion;

/**
 * Created by fundelec on 26/07/17.
 */

public class ObjetosConexionInteractorImpl implements ObjetosConexionInteractor{
    private ObjetosConexionRepository repository;

    public ObjetosConexionInteractorImpl(ObjetosConexionRepository repository) {
        this.repository = repository;
    }
}
