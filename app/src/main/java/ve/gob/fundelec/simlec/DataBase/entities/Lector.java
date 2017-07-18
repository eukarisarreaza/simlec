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
CREATE TABLE lector
(
  id bigint NOT NULL DEFAULT nextval('lector_id_seq'::regclass),
  cod_lector character varying(3) NOT NULL,
  nom_lector character varying(50) NOT NULL,
  primer_apell character varying(50),
  segundo_apell character varying(50),
  cod_lector_alterno character varying(3),
  rol_operador integer NOT NULL,
  id_centro_lectura bigint NOT NULL,
  version bigint,
  accion integer,
  CONSTRAINT pklector PRIMARY KEY (id),
  CONSTRAINT fk_lector_centro_lectura FOREIGN KEY (id_centro_lectura)
      REFERENCES centro_lectura (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
 */
@Table(database = DataBaseSimlec.class)
public class Lector extends BaseModel {
    @Column
    @PrimaryKey
    int id;
    @Column
    String cod_lector; // limite de 3
    @Column
    String nom_lector; // limite de 50
    @Column
    String primer_apell; // limite de 50
    @Column
    String segundo_apell; // limite de 50
    @Column
    String cod_lector_alterno; // limite de 3
    @Column
    int rol_operador;
    @Column
    int id_centro_lectura; /** clave foranea centro_lectura (id)**/
    @Column
    int version;
    @Column
    int accion;


    public Lector() {
    }

    public Lector(int id, String cod_lector, String nom_lector, String primer_apell, String segundo_apell,
                  String cod_lector_alterno, int rol_operador, int id_centro_lectura, int version, int accion) {
        this.id = id;
        this.cod_lector = cod_lector;
        this.nom_lector = nom_lector;
        this.primer_apell = primer_apell;
        this.segundo_apell = segundo_apell;
        this.cod_lector_alterno = cod_lector_alterno;
        this.rol_operador = rol_operador;
        this.id_centro_lectura = id_centro_lectura;
        this.version = version;
        this.accion = accion;
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
