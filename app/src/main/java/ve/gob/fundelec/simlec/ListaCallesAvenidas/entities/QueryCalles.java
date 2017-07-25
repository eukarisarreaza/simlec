package ve.gob.fundelec.simlec.ListaCallesAvenidas.entities;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.QueryModel;

import ve.gob.fundelec.simlec.DataBase.DataBaseSimlec;

/**
 * Created by fundelec on 25/07/17.
 */
@QueryModel(database = DataBaseSimlec.class)
public class QueryCalles {

    @Column
    int id_calle;

    @Column
    String nom_calle;

    @Column
    int id_lector;

    @Column
    int id_dispositivo_movil;

    @Column
    int cant_lect_programadas;

    @Column
    int cant_lect_gestionadasŗ;

    @Column
    int porcentaje_avance;


    public int getId_calle() {
        return id_calle;
    }

    public void setId_calle(int id_calle) {
        this.id_calle = id_calle;
    }

    public String getNom_calle() {
        return nom_calle;
    }

    public void setNom_calle(String nom_calle) {
        this.nom_calle = nom_calle;
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

    public int getCant_lect_gestionadasŗ() {
        return cant_lect_gestionadasŗ;
    }

    public void setCant_lect_gestionadasŗ(int cant_lect_gestionadasŗ) {
        this.cant_lect_gestionadasŗ = cant_lect_gestionadasŗ;
    }

    public int getPorcentaje_avance() {
        return porcentaje_avance;
    }

    public void setPorcentaje_avance(int porcentaje_avance) {
        this.porcentaje_avance = porcentaje_avance;
    }

    public int getCant_lect_progr() {
        return cant_lect_programadas;
    }

    public void setCant_lect_progr(int cant_lect_progr) {
        this.cant_lect_programadas = cant_lect_progr;
    }
}
