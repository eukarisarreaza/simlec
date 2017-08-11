package ve.gob.fundelec.simlec.ListMedidores;

/**
 * Created by fundelec on 01/08/17.
 */

public class RecorridoInteractorImpl implements RecorridoInteractor {
    private RecorridoRepository repository;

    public RecorridoInteractorImpl(RecorridoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void getFragmentInicio() {
        repository.getNombreObjetoConexionSeleccionado();
        repository.getMedidorInicio();
    }

    @Override
    public void registrarFragment() {
        repository.registerHistory();
    }

    @Override
    public void proximoMedidor() {
        repository.getProximoMedidor();
    }

    @Override
    public void anteriorMedidor() {
        repository.getPrevioMedidor();
    }

    @Override
    public void proximoObjetoConexion() {

    }

    @Override
    public void anteriorObjetoConexion() {

    }
}
