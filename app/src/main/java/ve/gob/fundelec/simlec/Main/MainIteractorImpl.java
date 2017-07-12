package ve.gob.fundelec.simlec.Main;

/**
 * Created by fundelec on 10/07/17.
 */

public class MainIteractorImpl implements MainIteractor {
    private MainRepository repository;


    public MainIteractorImpl(MainRepository repository) {
        this.repository = repository;
    }

    @Override
    public void getInicio() {
        this.repository.getInicio();
    }

    @Override
    public void getListMenu() {
        this.repository.getListMenu();
    }
}
