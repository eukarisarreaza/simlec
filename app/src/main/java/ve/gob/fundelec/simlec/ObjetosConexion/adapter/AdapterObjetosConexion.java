package ve.gob.fundelec.simlec.ObjetosConexion.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ve.gob.fundelec.simlec.ObjetosConexion.entities.QueryObjetoConexion;
import ve.gob.fundelec.simlec.R;

/**
 * Created by root on 08/04/17.
 */

public class AdapterObjetosConexion extends RecyclerView.Adapter<AdapterObjetosConexion.ObjetoConexionViewHolder>{
    private List<QueryObjetoConexion> datos;
    private OnClickObjetosConexion onItemClickListener;
    private static final String TAG= AdapterObjetosConexion.class.getName();


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

    public void setList(List<QueryObjetoConexion> list){
        datos.clear();
        datos.addAll(list);
        notifyDataSetChanged();
    }

    public void add(QueryObjetoConexion objetoConexion){
        datos.add(0, objetoConexion);
        notifyDataSetChanged();
    }

    public void clear(){
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
        @BindView(R.id.objConexion)
        TextView objConexion;
        @BindView(R.id.identificador)
        TextView identificador;
        @BindView(R.id.status)
        TextView status;

        public ObjetoConexionViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindObjetoConexion(QueryObjetoConexion item, int pos){
            num.setText(String.valueOf(pos+1));

            /*
            if(pos==4){
                status.setText("por leer");
                status.setBackgroundResource(R.color.opcion1_2);
            }
            if(pos==5){
                status.setText("en espera");
                status.setBackgroundResource(R.color.opcion1_5);
            }*/
        }

        public void setOnItemClickListener(final QueryObjetoConexion element, final OnClickObjetosConexion onItemClickListener){
            itemView.setOnClickListener(v -> onItemClickListener.onClickObjetosConexion(element));
        }
    }
}
