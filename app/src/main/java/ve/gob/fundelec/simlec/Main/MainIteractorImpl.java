package ve.gob.fundelec.simlec.Main;

/**
 * Created by fundelec on 10/07/17.
 */

public class MainIteractorImpl implements MainIteractor {
    private MainRepository repository;
    private UserRepository userRepository;

    public MainIteractorImpl(MainRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Override
    public void getInicio() {
        this.repository.getInicio();
    }

    @Override
    public void getListMenu() {
        this.repository.getListMenu();
    }

    @Override
    public void onBackPress() {
        repository.retroceder();
        repository.getInicio();
    }

    @Override
    public void salir() {
        userRepository.logout();
    }
}
