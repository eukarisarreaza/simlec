package ve.gob.fundelec.simlec.Login.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ve.gob.fundelec.simlec.Configuracion;
import ve.gob.fundelec.simlec.Login.LoginPresenter;
import ve.gob.fundelec.simlec.Login.di.LoginComponent;
import ve.gob.fundelec.simlec.R;
import ve.gob.fundelec.simlec.SimlecApplication;

public class LoginActivity extends AppCompatActivity implements LoginView{

    @BindView(R.id.usuario_text)
    EditText usuarioText;
    @BindView(R.id.password_text)
    EditText passwordText;
    @BindView(R.id.lector)
    TextView lector;
    @BindView(R.id.supervisor)
    TextView supervisor;
    @BindView(R.id.administrador)
    TextView administrador;
    @BindView(R.id.iniciar)
    Button iniciar;

    private String tipoUsuario;
    @Inject
    private LoginPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        setupInject();
        presenter.onCreate();
    }

    private void setupInject() {
        SimlecApplication application= (SimlecApplication) getApplication();
        LoginComponent component= application.getLoginComponent(this);
        component.inject(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @OnClick(R.id.lector)
    @Override
    public void onSelectLector() {
        supervisor.setBackgroundResource(R.color.backgroundColor);
        administrador.setBackgroundResource(R.color.backgroundColor);
        lector.setBackgroundResource(R.color.background);
        tipoUsuario= Configuracion.TipoUsuario.LECTOR.name();
    }

    @OnClick(R.id.supervisor)
    @Override
    public void onSelectSupervisor() {
        supervisor.setBackgroundResource(R.color.background);
        administrador.setBackgroundResource(R.color.backgroundColor);
        lector.setBackgroundResource(R.color.backgroundColor);
        tipoUsuario= Configuracion.TipoUsuario.SUPERVISOR.name();

    }

    @OnClick(R.id.administrador)
    @Override
    public void onSelectAdministrador() {
        supervisor.setBackgroundResource(R.color.backgroundColor);
        administrador.setBackgroundResource(R.color.background);
        lector.setBackgroundResource(R.color.backgroundColor);
        tipoUsuario= Configuracion.TipoUsuario.ADMINISTRADOR.name();
    }

    @OnClick(R.id.iniciar)
    @Override
    public void iniciar() {
        presenter.login(tipoUsuario, usuarioText.getText().toString(), passwordText.getText().toString());
    }
}
