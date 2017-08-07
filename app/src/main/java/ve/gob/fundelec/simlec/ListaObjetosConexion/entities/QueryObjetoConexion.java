package ve.gob.fundelec.simlec.ListaObjetosConexion.entities;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.QueryModel;

import java.util.List;

import ve.gob.fundelec.simlec.DataBase.DataBaseSimlec;
import ve.gob.fundelec.simlec.DataBase.entities.Medidores;

/**
 * Created by fundelec on 26/07/17.
 */
@QueryModel(database = DataBaseSimlec.class)
public class QueryObjetoConexion {

    @Column
    int id_objeto_conexion;
    @Column
    String cod_obj_conex;
    @Column
    String nom_obj_conex;
    @Column
    int ord_obj_conex;
    @Column
    int cant_lect_ejecutadas;
    @Column
    List<Medidores> medidoresList;



    public int getId_objeto_conexion() {
        return id_objeto_conexion;
    }

    public void setId_objeto_conexion(int id_objeto_conexion) {
        this.id_objeto_conexion = id_objeto_conexion;
    }

    public String getCod_obj_conex() {
        return cod_obj_conex;
    }

    public void setCod_obj_conex(String cod_obj_conex) {
        this.cod_obj_conex = cod_obj_conex;
    }

    public String getNom_obj_conex() {
        return nom_obj_conex;
    }

    public void setNom_obj_conex(String nom_obj_conex) {
        this.nom_obj_conex = nom_obj_conex;
    }

    public int getOrd_obj_conex() {
        return ord_obj_conex;
    }

    public void setOrd_obj_conex(int ord_obj_conex) {
        this.ord_obj_conex = ord_obj_conex;
    }

    public int getCant_lect_ejecutadas() {
        return cant_lect_ejecutadas;
    }

    public void setCant_lect_ejecutadas(int cant_lect_ejecutadas) {
        this.cant_lect_ejecutadas = cant_lect_ejecutadas;
    }

    public List<Medidores> getMedidoresList() {
        return medidoresList;
    }

    public void setMedidoresList(List<Medidores> medidoresList) {
        this.medidoresList = medidoresList;
    }
}
