package ve.gob.fundelec.simlec.DataBase.entities;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import ve.gob.fundelec.simlec.DataBase.DataBaseSimlec;

/**
 * Created by fundelec on 11/07/17.
 */
/**
CREATE TABLE centro_lectura
(
  id bigint NOT NULL DEFAULT nextval('centro_lectura_id_seq'::regclass),
  cod_ctro_lectura character varying(3) NOT NULL,
  nom_ctro_lectura character varying(70) NOT NULL,
  version bigint,
  accion integer,
  CONSTRAINT pkcentro_lectura PRIMARY KEY (id)
)
 */
@Table(database = DataBaseSimlec.class)
public class CentroLectura extends BaseModel {
    @Column
    @PrimaryKey
    int id;

    @Column
    int id_municipio;
    @Column
    String cod_ctro_lectura;
    @Column
    String nom_ctro_lectura;
    @Column
    int version;
    @Column
    int accion;

    public CentroLectura() {
    }

    public CentroLectura(int id, String cod_ctro_lectura, String nom_ctro_lectura, int version, int accion, int id_municipio) {
        this.id = id;
        this.id_municipio = id_municipio;
        this.cod_ctro_lectura = cod_ctro_lectura;
        this.nom_ctro_lectura = nom_ctro_lectura;
        this.version = version;
        this.accion = accion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(int id_municipio) {
        this.id_municipio = id_municipio;
    }

    public String getCod_ctro_lectura() {
        return cod_ctro_lectura;
    }

    public void setCod_ctro_lectura(String cod_ctro_lectura) {
        this.cod_ctro_lectura = cod_ctro_lectura;
    }

    public String getNom_ctro_lectura() {
        return nom_ctro_lectura;
    }

    public void setNom_ctro_lectura(String nom_ctro_lectura) {
        this.nom_ctro_lectura = nom_ctro_lectura;
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
