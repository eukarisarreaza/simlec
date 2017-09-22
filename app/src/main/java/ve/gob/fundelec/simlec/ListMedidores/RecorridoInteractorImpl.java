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
        repository.getValorDeLectura();
    }

    @Override
    public void onSelectObjetoConexion() {
        repository.getMedidorInicio();
    }

    @Override
    public void mostrarObjetoConexion() {
        repository.getValorDeLectura();
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
        repository.getProximoObjetoConexion();
    }

    @Override
    public void anteriorObjetoConexion() {
        repository.getPrevioObjetoConexion();
    }

    @Override
    public void actualizarPresinto(String retirado, String actual) {
        repository.actualizarPresinto(retirado, actual);
    }

    @Override
    public void saveLectura() {
        repository.saveLectura();
    }

    @Override
    public void saveNotaLectura() {
        repository.saveNotaLectura();
    }

    @Override
    public void selectLetterP() {
        repository.selecLetterP();
    }
}
