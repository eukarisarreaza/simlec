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
CREATE TABLE programacion_calle
(
  id bigint NOT NULL DEFAULT nextval('programacion_ruta_id_seq'::regclass),
  fch_programa date NOT NULL,
  id_lector bigint NOT NULL,
  id_dispositivo_movil bigint,
  fch_asig_diaria date NOT NULL,
  fch_lect_real date,
  lect_visitadas bigint,
  lect_novisitadas bigint,
  lect_noleidas bigint,
  lect_leidas bigint,
  lect_ausentes bigint,
  lect_anomalas bigint,
  lect_modificadas bigint,
  lect_forzadas bigint,
  cant_med_sobrantes bigint,
  id_calle_avenida bigint NOT NULL,
  version bigint,
  accion integer,
  CONSTRAINT pkprogramacion_ruta PRIMARY KEY (id),
  CONSTRAINT fk_programacion_calle_calle_avenida FOREIGN KEY (id_calle_avenida)
      REFERENCES calle_avenida (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_programacion_calle_dispositivo_movil FOREIGN KEY (id_dispositivo_movil)
      REFERENCES dispositivo_movil (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_programacion_calle_lector FOREIGN KEY (id_lector)
      REFERENCES lector (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
 */
@Table(database = DataBaseSimlec.class)
public class ProgramacionCalle extends BaseModel{
    @Column
    @PrimaryKey
    int id;

    @Column
    String fch_programa; // date
    @Column
    int id_lector; /** lector (id) */
    @Column
    int id_dispositivo_movil; /** dispositivo_movil (id)**/
    @Column
    String fch_asig_diaria; // date
    @Column
    String fch_lect_real; // date
    @Column
    int lect_visitadas;
    @Column
    int lect_novisitadas;
    @Column
    int lect_noleidas;
    @Column
    int lect_leidas;
    @Column
    int lect_ausentes;
    @Column
    int lect_anomalas;
    @Column
    int lect_modificadas;
    @Column
    int lect_forzadas;
    @Column
    int cant_med_sobrantes;
    @Column
    int id_calle_avenida; /** calle_avenida (id)*/


    @Column
    int version;
    @Column
    int accion;


    public ProgramacionCalle() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFch_programa() {
        return fch_programa;
    }

    public void setFch_programa(String fch_programa) {
        this.fch_programa = fch_programa;
    }

    public int getId_lector() {
        return id_lector;
    }

    public void setId_lector(int id_lector) {
        this.id_lector = id_lector;
    }

    public int getId_dispositivo_movil() {
        return id_dispositivo_movil;
    }

    public void setId_dispositivo_movil(int id_dispositivo_movil) {
        this.id_dispositivo_movil = id_dispositivo_movil;
    }

    public String getFch_asig_diaria() {
        return fch_asig_diaria;
    }

    public void setFch_asig_diaria(String fch_asig_diaria) {
        this.fch_asig_diaria = fch_asig_diaria;
    }

    public String getFch_lect_real() {
        return fch_lect_real;
    }

    public void setFch_lect_real(String fch_lect_real) {
        this.fch_lect_real = fch_lect_real;
    }

    public int getLect_visitadas() {
        return lect_visitadas;
    }

    public void setLect_visitadas(int lect_visitadas) {
        this.lect_visitadas = lect_visitadas;
    }

    public int getLect_novisitadas() {
        return lect_novisitadas;
    }

    public void setLect_novisitadas(int lect_novisitadas) {
        this.lect_novisitadas = lect_novisitadas;
    }

    public int getLect_noleidas() {
        return lect_noleidas;
    }

    public void setLect_noleidas(int lect_noleidas) {
        this.lect_noleidas = lect_noleidas;
    }

    public int getLect_leidas() {
        return lect_leidas;
    }

    public void setLect_leidas(int lect_leidas) {
        this.lect_leidas = lect_leidas;
    }

    public int getLect_ausentes() {
        return lect_ausentes;
    }

    public void setLect_ausentes(int lect_ausentes) {
        this.lect_ausentes = lect_ausentes;
    }

    public int getLect_anomalas() {
        return lect_anomalas;
    }

    public void setLect_anomalas(int lect_anomalas) {
        this.lect_anomalas = lect_anomalas;
    }

    public int getLect_modificadas() {
        return lect_modificadas;
    }

    public void setLect_modificadas(int lect_modificadas) {
        this.lect_modificadas = lect_modificadas;
    }

    public int getLect_forzadas() {
        return lect_forzadas;
    }

    public void setLect_forzadas(int lect_forzadas) {
        this.lect_forzadas = lect_forzadas;
    }

    public int getCant_med_sobrantes() {
        return cant_med_sobrantes;
    }

    public void setCant_med_sobrantes(int cant_med_sobrantes) {
        this.cant_med_sobrantes = cant_med_sobrantes;
    }

    public int getId_calle_avenida() {
        return id_calle_avenida;
    }

    public void setId_calle_avenida(int id_calle_avenida) {
        this.id_calle_avenida = id_calle_avenida;
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
