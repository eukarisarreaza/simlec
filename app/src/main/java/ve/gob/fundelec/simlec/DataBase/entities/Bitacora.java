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
public class Bitacora extends BaseModel{
    @Column
    @PrimaryKey
    int id;

    @Column
    int id_lector;
    @Column
    int tip_registro;
    @Column
    int tip_modulo;
    @Column
    String desc_registro;
    @Column
    String fch_registro; // timestamp

    @Column
    int version;
    @Column
    int accion;

    public Bitacora() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_lector() {
        return id_lector;
    }

    public void setId_lector(int id_lector) {
        this.id_lector = id_lector;
    }

    public int getTip_registro() {
        return tip_registro;
    }

    public void setTip_registro(int tip_registro) {
        this.tip_registro = tip_registro;
    }

    public int getTip_modulo() {
        return tip_modulo;
    }

    public void setTip_modulo(int tip_modulo) {
        this.tip_modulo = tip_modulo;
    }

    public String getDesc_registro() {
        return desc_registro;
    }

    public void setDesc_registro(String desc_registro) {
        this.desc_registro = desc_registro;
    }

    public String getFch_registro() {
        return fch_registro;
    }

    public void setFch_registro(String fch_registro) {
        this.fch_registro = fch_registro;
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
