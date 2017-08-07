package ve.gob.fundelec.simlec.ListaObjetosConexion.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ve.gob.fundelec.simlec.Configuracion;
import ve.gob.fundelec.simlec.ListaObjetosConexion.entities.QueryObjetoConexion;
import ve.gob.fundelec.simlec.R;

/**
 * Created by root on 08/04/17.
 */

public class AdapterObjetosConexion extends RecyclerView.Adapter<AdapterObjetosConexion.ObjetoConexionViewHolder> {
    private List<QueryObjetoConexion> datos;
    private OnClickObjetosConexion onItemClickListener;
    private static final String TAG = AdapterObjetosConexion.class.getName();


    public AdapterObjetosConexion(List<QueryObjetoConexion> datos, OnClickObjetosConexion onItemClickListener) {
        this.datos = datos;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ObjetoConexionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_objeto_conexion, parent, false);
        ObjetoConexionViewHolder pvh = new ObjetoConexionViewHolder(itemView);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ObjetoConexionViewHolder holder, int position) {
        QueryObjetoConexion item = datos.get(position);
        holder.bindObjetoConexion(item, position);
        holder.setOnItemClickListener(item, onItemClickListener);
    }

    public void setList(List<QueryObjetoConexion> list) {
        datos.clear();
        datos.addAll(list);
        notifyDataSetChanged();
    }

    public void add(QueryObjetoConexion objetoConexion) {
        datos.add(0, objetoConexion);
        notifyDataSetChanged();
    }

    public void clear() {
        datos.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public class ObjetoConexionViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.num)
        TextView num;
        @BindView(R.id.codigo)
        TextView codigo;
        @BindView(R.id.nombre_objeto)
        TextView nombreObjeto;
        @BindView(R.id.status)
        TextView status;


        public ObjetoConexionViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindObjetoConexion(QueryObjetoConexion item, int pos) {
            num.setText(String.valueOf(pos + 1));
            codigo.setText(item.getCod_obj_conex());
            nombreObjeto.setText(item.getNom_obj_conex());

            if(item.getCant_lect_ejecutadas()==item.getNumMedidores()){
                status.setText(Configuracion.StatusObjetoConexion.LEIDO.name());
                status.setBackgroundColor(Color.GREEN);
                //status.setBackgroundResource(R.color.opcion1_2);
            }else
            if(item.getCant_lect_ejecutadas()==0){
                status.setText(Configuracion.StatusObjetoConexion.EN_ESPERA.name().replace("_", " "));
                status.setBackgroundColor(Color.RED);
            }else {
                status.setText(Configuracion.StatusObjetoConexion.POR_LEER.name().replace("_", " "));
                status.setBackgroundColor(Color.YELLOW);
            }
        }

        public void setOnItemClickListener(final QueryObjetoConexion element, final OnClickObjetosConexion onItemClickListener) {
            itemView.setOnClickListener(v -> onItemClickListener.onClickObjetosConexion(element));
        }
    }
}
