package ve.gob.fundelec.simlec.DataBase.entities;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import ve.gob.fundelec.simlec.DataBase.DataBaseSimlec;

/**
 * Created by fundelec on 11/07/17.
 */
@Table(database = DataBaseSimlec.class)
public class Lector extends BaseModel {

    @Column
    @PrimaryKey
    int id;

    @Column
    String cod_lector;
    @Column
    String nom_lector;
    @Column
    String primer_apell;
    @Column
    String segundo_apell; //date
    @Column
    String cod_lector_alterno;

    @Column
    int rol_operador;
    @Column
    int id_centro_lectura; //clave foranea centro_lectura (id)
    @Column
    int version;
    @Column
    int accion;

    public Lector() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCod_lector() {
        return cod_lector;
    }

    public void setCod_lector(String cod_lector) {
        this.cod_lector = cod_lector;
    }

    public String getNom_lector() {
        return nom_lector;
    }

    public void setNom_lector(String nom_lector) {
        this.nom_lector = nom_lector;
    }

    public String getPrimer_apell() {
        return primer_apell;
    }

    public void setPrimer_apell(String primer_apell) {
        this.primer_apell = primer_apell;
    }

    public String getSegundo_apell() {
        return segundo_apell;
    }

    public void setSegundo_apell(String segundo_apell) {
        this.segundo_apell = segundo_apell;
    }

    public String getCod_lector_alterno() {
        return cod_lector_alterno;
    }

    public void setCod_lector_alterno(String cod_lector_alterno) {
        this.cod_lector_alterno = cod_lector_alterno;
    }

    public int getRol_operador() {
        return rol_operador;
    }

    public void setRol_operador(int rol_operador) {
        this.rol_operador = rol_operador;
    }

    public int getId_centro_lectura() {
        return id_centro_lectura;
    }

    public void setId_centro_lectura(int id_centro_lectura) {
        this.id_centro_lectura = id_centro_lectura;
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
