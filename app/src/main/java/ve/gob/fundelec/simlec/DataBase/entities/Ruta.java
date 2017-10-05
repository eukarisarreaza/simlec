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
CREATE TABLE ruta
(
  id bigint NOT NULL DEFAULT nextval('ruta_id_seq'::regclass),
  cod_ruta character varying(10) NOT NULL,
  nom_ruta character varying(50) NOT NULL,
  id_edo_ruta bigint NOT NULL,
  id_centro_lectura bigint NOT NULL,
  cod_status character varying(2),
  version bigint,
  accion integer,
  CONSTRAINT pkruta PRIMARY KEY (id),
  CONSTRAINT fk_ruta_centro_lectura FOREIGN KEY (id_centro_lectura)
      REFERENCES centro_lectura (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_ruta_edo_ruta FOREIGN KEY (id_edo_ruta)
      REFERENCES f_ruta (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
 */
@Table(database = DataBaseSimlec.class)
public class Ruta extends BaseModel{
    @Column
    @PrimaryKey
    int id;
    @Column
    int id_edo_ruta;  /** f_ruta (id) */
    @Column
    int id_centro_lectura; /**  centro_lectura (id) */
    @Column
    int id_dispositivo_movil;
    @Column
    String cod_ruta; // limite de 10
    @Column
    String nom_ruta; // limite de 50
    @Column
    String cod_status; // limite de 2
    @Column
    int version;
    @Column
    int accion;

    public Ruta() {
    }

    public Ruta(int id, int id_edo_ruta, int id_centro_lectura, int id_dispositivo_movil,
                String cod_ruta, String nom_ruta, String cod_status, int version, int accion) {
        this.id = id;
        this.id_edo_ruta = id_edo_ruta;
        this.id_centro_lectura = id_centro_lectura;
        this.id_dispositivo_movil = id_dispositivo_movil;
        this.cod_ruta = cod_ruta;
        this.nom_ruta = nom_ruta;
        this.cod_status = cod_status;
        this.version = version;
        this.accion = accion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_edo_ruta() {
        return id_edo_ruta;
    }

    public void setId_edo_ruta(int id_edo_ruta) {
        this.id_edo_ruta = id_edo_ruta;
    }

    public int getId_centro_lectura() {
        return id_centro_lectura;
    }

    public void setId_centro_lectura(int id_centro_lectura) {
        this.id_centro_lectura = id_centro_lectura;
    }

    public int getId_dispositivo_movil() {
        return id_dispositivo_movil;
    }

    public void setId_dispositivo_movil(int id_dispositivo_movil) {
        this.id_dispositivo_movil = id_dispositivo_movil;
    }

    public String getCod_ruta() {
        return cod_ruta;
    }

    public void setCod_ruta(String cod_ruta) {
        this.cod_ruta = cod_ruta;
    }

    public String getNom_ruta() {
        return nom_ruta;
    }

    public void setNom_ruta(String nom_ruta) {
        this.nom_ruta = nom_ruta;
    }

    public String getCod_status() {
        return cod_status;
    }

    public void setCod_status(String cod_status) {
        this.cod_status = cod_status;
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
