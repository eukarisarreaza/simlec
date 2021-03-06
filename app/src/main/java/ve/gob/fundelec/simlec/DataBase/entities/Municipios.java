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
public class Municipios extends BaseModel{

    @Column
    @PrimaryKey
    int id_municipio;

    @Column
    int id_estado;
    @Column
    String municipio;

    @Column
    int version;
    @Column
    int accion;

    public Municipios() {
    }

    public Municipios(String id_municipio, int id_estado, String municipio, int version, int accion) {
        this.id_municipio = Integer.valueOf(id_municipio);
        this.id_estado = id_estado;
        this.municipio = municipio;
        this.version = version;
        this.accion = accion;
    }

    public int getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(int id_municipio) {
        this.id_municipio = id_municipio;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
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
