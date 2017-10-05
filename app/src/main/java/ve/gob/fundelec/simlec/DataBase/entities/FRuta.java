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
CREATE TABLE f_ruta
(
  id bigint NOT NULL DEFAULT nextval('edo_ruta_id_seq'::regclass),
  cod_edo_ruta character varying(3) NOT NULL,
  nom_edo_ruta character varying(40) NOT NULL,
  version bigint,
  accion integer,
  desc_edo_ruta text,
  CONSTRAINT pkedo_ruta PRIMARY KEY (id)
)
 */
@Table(database = DataBaseSimlec.class)
public class FRuta extends BaseModel{
    @Column
    @PrimaryKey
    int id;
    @Column
    String cod_edo_ruta; // limite de 3
    @Column
    String nom_edo_ruta; // limite de 40
    @Column
    String desc_edo_ruta;
    @Column
    int version;
    @Column
    int accion;


    public FRuta() {
    }

    public FRuta(int id, String cod_edo_ruta, String nom_edo_ruta, int version, int accion, String desc_edo_ruta) {
        this.id = id;
        this.cod_edo_ruta = cod_edo_ruta;
        this.nom_edo_ruta = nom_edo_ruta;
        this.desc_edo_ruta = desc_edo_ruta;
        this.version = version;
        this.accion = accion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCod_edo_ruta() {
        return cod_edo_ruta;
    }

    public void setCod_edo_ruta(String cod_edo_ruta) {
        this.cod_edo_ruta = cod_edo_ruta;
    }

    public String getNom_edo_ruta() {
        return nom_edo_ruta;
    }

    public void setNom_edo_ruta(String nom_edo_ruta) {
        this.nom_edo_ruta = nom_edo_ruta;
    }

    public String getDesc_edo_ruta() {
        return desc_edo_ruta;
    }

    public void setDesc_edo_ruta(String desc_edo_ruta) {
        this.desc_edo_ruta = desc_edo_ruta;
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
