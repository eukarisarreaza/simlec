package ve.gob.fundelec.simlec.Login.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.piotrek.customspinner.CustomSpinner;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;
import ve.gob.fundelec.simlec.Configuracion;
import ve.gob.fundelec.simlec.Login.LoginPresenter;
import ve.gob.fundelec.simlec.Login.di.LoginComponent;
import ve.gob.fundelec.simlec.Main.ui.MainActivity;
import ve.gob.fundelec.simlec.ProgressDialog;
import ve.gob.fundelec.simlec.R;
import ve.gob.fundelec.simlec.SimlecApplication;

public class LoginActivity extends AppCompatActivity implements LoginView {

    @BindView(R.id.usuario_text)
    EditText usuarioText;
    @BindView(R.id.password_text)
    EditText passwordText;

    @BindView(R.id.iniciar)
    LinearLayout iniciar;
    @BindView(R.id.tipo_user)
    CustomSpinner tipoUser;

    private String tipoUsuario;
    private ProgressDialog dialog;


    @Inject
    LoginPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        setupInject();
        setupTipoUser();
        presenter.onCreate();
        presenter.checkForAuthenticateUser();
        tipoUsuario = Configuracion.TipoUsuario.LECTOR.name();


    }

    private void setupTipoUser() {
        String[] data= getResources().getStringArray(R.array.tipo_user);
        tipoUser.initializeStringValues(data, getString(R.string.spinner_hint));


    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));

    }

    private void setupInject() {
        SimlecApplication application = (SimlecApplication) getApplication();
        LoginComponent component = application.getLoginComponent(this);
        component.inject(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void showNotify(String message) {

    }

    @Override
    public void onSelectLector() {

    }

    @Override
    public void onSelectSupervisor() {

    }

    @Override
    public void onSelectAdministrador() {

    }

    /**
    @OnClick(R.id.lector)
    @Override
    public void onSelectLector() {
        supervisor.setBackgroundResource(R.color.backgroundColor);
        administrador.setBackgroundResource(R.color.backgroundColor);
        lector.setBackgroundResource(R.color.background_2);
        tipoUsuario = Configuracion.TipoUsuario.LECTOR.name();
    }

    @OnClick(R.id.supervisor)
    @Override
    public void onSelectSupervisor() {
        supervisor.setBackgroundResource(R.color.background_2);
        administrador.setBackgroundResource(R.color.backgroundColor);
        lector.setBackgroundResource(R.color.backgroundColor);
        tipoUsuario = Configuracion.TipoUsuario.SUPERVISOR.name();

    }

    @OnClick(R.id.administrador)
    @Override
    public void onSelectAdministrador() {
        supervisor.setBackgroundResource(R.color.backgroundColor);
        administrador.setBackgroundResource(R.color.background_2);
        lector.setBackgroundResource(R.color.backgroundColor);
        tipoUsuario = Configuracion.TipoUsuario.ADMINISTRADOR.name();
    }
**/
    @Override
    public void showProgressDialogo() {
        dialog = ProgressDialog.newInstance();
        dialog.show(getSupportFragmentManager(), "");
    }

    @Override
    public void hideProgressDialogo() {
        if (dialog != null)
            dialog.dismiss();
    }

    @OnClick(R.id.iniciar)
    @Override
    public void iniciar() {
        if (usuarioText.getText().toString().isEmpty()) {
            usuarioText.setError("Id Usuario esta vacio");
            return;
        }
        if (passwordText.getText().toString().isEmpty()) {
            passwordText.setError("Password esta vacio");
            return;
        }
        presenter.login(tipoUsuario, usuarioText.getText().toString(), passwordText.getText().toString());
    }

    @Override
    public void showMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                | Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        startActivity(intent);
    }
}
