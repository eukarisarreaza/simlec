package ve.gob.fundelec.simlec.ListaRutasAsignadas.entities;

import com.google.gson.Gson;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.QueryModel;

import ve.gob.fundelec.simlec.DataBase.DataBaseSimlec;

/**
 * Created by fundelec on 20/07/17.
 */
@QueryModel(database = DataBaseSimlec.class)
public class QueryRutas {


    @Column
    int id_programacion_calle;
    @Column
    int id_calle_avenida;
    @Column
    String fch_programa; // date
    @Column
    int id_lector; /** lector (id) */
    @Column
    int id_dispositivo_movil; /** dispositivo_movil (id)**/
    @Column
    String fch_asig_diaria; // date


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
    String cod_ruta; // limite de 10
    @Column
    String nom_ruta; // limite de 50

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

    public int getId_programacion_calle() {
        return id_programacion_calle;
    }

    public void setId_programacion_calle(int id_programacion_calle) {
        this.id_programacion_calle = id_programacion_calle;
    }

    public int getId_calle_avenida() {
        return id_calle_avenida;
    }

    public void setId_calle_avenida(int id_calle_avenida) {
        this.id_calle_avenida = id_calle_avenida;
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

    public int getId_ruta() {
        return id_ruta;
    }

    public void setId_ruta(int id_ruta_tabla) {
        this.id_ruta = id_ruta_tabla;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        String jsonString = gson.toJson(this);
        return jsonString;
    }
}
