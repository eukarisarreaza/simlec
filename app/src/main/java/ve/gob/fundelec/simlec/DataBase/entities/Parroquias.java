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
public class Parroquias extends BaseModel{
    @Column
    @PrimaryKey
    int id_parroquia;

    @Column
    int id_municipio;
    @Column
    String parroquia;

    @Column
    int version;
    @Column
    int accion;

    public Parroquias() {
    }

    public Parroquias(String id_parroquia, int id_municipio, String parroquia, int version, int accion) {
        this.id_parroquia = Integer.valueOf(id_parroquia);
        this.id_municipio = id_municipio;
        this.parroquia = parroquia;
        this.version = version;
        this.accion = accion;
    }

    public int getId_parroquia() {
        return id_parroquia;
    }

    public void setId_parroquia(int id_parroquia) {
        this.id_parroquia = id_parroquia;
    }

    public int getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(int id_municipio) {
        this.id_municipio = id_municipio;
    }

    public String getParroquia() {
        return parroquia;
    }

    public void setParroquia(String parroquia) {
        this.parroquia = parroquia;
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
