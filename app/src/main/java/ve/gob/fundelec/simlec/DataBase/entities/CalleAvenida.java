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
CREATE TABLE calle_avenida
(
  id bigint NOT NULL DEFAULT nextval('calle_avenida_id_seq'::regclass),
  nom_calle character varying(50) NOT NULL,
  id_ruta bigint NOT NULL,
  secuencia text,
  version bigint,
  accion integer,
  id_parroquia bigint NOT NULL,
  sector character varying(255) NOT NULL,
  cod_calle bigint NOT NULL,
  CONSTRAINT pkcalle_avenida PRIMARY KEY (id),
  CONSTRAINT fk_calle_avenida_parroquias FOREIGN KEY (id_parroquia)
      REFERENCES parroquias (id_parroquia) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_calle_avenida_ruta FOREIGN KEY (id_ruta)
      REFERENCES ruta (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
 */
@Table(database = DataBaseSimlec.class)
public class CalleAvenida extends BaseModel{
    @Column
    @PrimaryKey
    int id;
    @Column
    int id_ruta;
    @Column
    int id_parroquia;
    @Column
    int cod_calle;
    @Column
    String nom_calle; // limite de 50
    @Column
    String secuencia;
    @Column
    String sector; // limite de 255
    @Column
    int version;
    @Column
    int accion;

    public CalleAvenida() {
    }

    public CalleAvenida(int id, String nom_calle, int id_ruta, String secuencia, int version, int accion, int id_parroquia, String sector, int cod_calle) {
        this.id = id;
        this.id_ruta = id_ruta;
        this.id_parroquia = id_parroquia;
        this.cod_calle = cod_calle;
        this.nom_calle = nom_calle;
        this.secuencia = secuencia;
        this.sector = sector;
        this.version = version;
        this.accion = accion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_ruta() {
        return id_ruta;
    }

    public void setId_ruta(int id_ruta) {
        this.id_ruta = id_ruta;
    }

    public int getId_parroquia() {
        return id_parroquia;
    }

    public void setId_parroquia(int id_parroquia) {
        this.id_parroquia = id_parroquia;
    }

    public int getCod_calle() {
        return cod_calle;
    }

    public void setCod_calle(int cod_calle) {
        this.cod_calle = cod_calle;
    }

    public String getNom_calle() {
        return nom_calle;
    }

    public void setNom_calle(String nom_calle) {
        this.nom_calle = nom_calle;
    }

    public String getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(String secuencia) {
        this.secuencia = secuencia;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
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
