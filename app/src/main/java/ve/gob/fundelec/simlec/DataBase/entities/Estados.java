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
public class Estados extends BaseModel{

    @Column
    @PrimaryKey
    int id_estado;

    @Column
    String estado;
    @Column
    String iso_3166_2;
    @Column
    int version;
    @Column
    int accion;

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIso_3166_2() {
        return iso_3166_2;
    }

    public void setIso_3166_2(String iso_3166_2) {
        this.iso_3166_2 = iso_3166_2;
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
