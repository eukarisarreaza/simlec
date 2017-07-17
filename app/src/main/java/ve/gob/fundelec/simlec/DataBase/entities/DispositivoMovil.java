package ve.gob.fundelec.simlec.DataBase.entities;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import ve.gob.fundelec.simlec.DataBase.DataBaseSimlec;

/**
 * Created by fundelec on 17/07/17.
 */
@Table(database = DataBaseSimlec.class)
public class DispositivoMovil extends BaseModel{
    @Column
    @PrimaryKey
    int id;
    @Column
    int id_centro_lectura; /**  centro_lectura (id) */
    @Column
    String token_dmi;
    @Column
    String serial_dmi; // limite de 30
    @Column
    String marca_dmi; // limite de 100
    @Column
    String modelo_dmi; // limite de 100
    @Column
    int edo_dmi;
    @Column
    int version;
    @Column
    int accion;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_centro_lectura() {
        return id_centro_lectura;
    }

    public void setId_centro_lectura(int id_centro_lectura) {
        this.id_centro_lectura = id_centro_lectura;
    }

    public String getToken_dmi() {
        return token_dmi;
    }

    public void setToken_dmi(String token_dmi) {
        this.token_dmi = token_dmi;
    }

    public String getSerial_dmi() {
        return serial_dmi;
    }

    public void setSerial_dmi(String serial_dmi) {
        this.serial_dmi = serial_dmi;
    }

    public String getMarca_dmi() {
        return marca_dmi;
    }

    public void setMarca_dmi(String marca_dmi) {
        this.marca_dmi = marca_dmi;
    }

    public String getModelo_dmi() {
        return modelo_dmi;
    }

    public void setModelo_dmi(String modelo_dmi) {
        this.modelo_dmi = modelo_dmi;
    }

    public int getEdo_dmi() {
        return edo_dmi;
    }

    public void setEdo_dmi(int edo_dmi) {
        this.edo_dmi = edo_dmi;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getAccion() {
        return accion;
    }

    public void setAccion(int accion) {
        this.accion = accion;
    }
}
