package ve.gob.fundelec.simlec.ListaRutasAsignadas.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ve.gob.fundelec.simlec.LectorSessionManager;
import ve.gob.fundelec.simlec.ListaRutasAsignadas.entities.QueryRutas;
import ve.gob.fundelec.simlec.R;

/**
 * Created by root on 08/04/17.
 */

public class AdapterRutasAsignadas extends RecyclerView.Adapter<AdapterRutasAsignadas.RutasViewHolder>{
    private List<QueryRutas> datos;
    private OnItemClickListener onItemClickListener;
    private LectorSessionManager sessionManager;

    public AdapterRutasAsignadas(List<QueryRutas> datos, OnItemClickListener onItemClickListener, LectorSessionManager sessionManager) {
        this.datos = datos;
        this.onItemClickListener = onItemClickListener;
        this.sessionManager = sessionManager;
    }

    @Override
    public RutasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_ruta, parent, false);
        RutasViewHolder pvh = new RutasViewHolder(itemView);
        return pvh;
    }

    @Override
    public void onBindViewHolder(RutasViewHolder holder, int position) {
        QueryRutas item = datos.get(position);
        holder.bindRuta(item);
        holder.setOnItemClickListener(item, onItemClickListener);
    }

        public void setList(List<QueryRutas> rutasList) {
        datos.clear();
        datos.addAll(rutasList);
        notifyDataSetChanged();
    }


    public void add(QueryRutas route){
        datos.add(0, route);
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

    public class RutasViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.area)
        TextView area;
        @BindView(R.id.route)
        TextView route;
        @BindView(R.id.lector)
        TextView lector;

        public RutasViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindRuta(QueryRutas item){

            switch (sessionManager.getUser().getRol_operador()){
                case 1: //LECTOR
                    lector.setVisibility(View.GONE);
                    break;
                case 2: //SUPERVISOR
                    lector.setVisibility(View.VISIBLE);
                    break;
                case 3: // ADMINISTRADOR
                    lector.setVisibility(View.VISIBLE);
                    break;
            }
        }

        public void setOnItemClickListener(final QueryRutas element, final OnItemClickListener onItemClickListener){
            itemView.setOnClickListener(v -> {
                LinearLayout myBackground=(LinearLayout)v.findViewById(R.id.content);
                myBackground.setSelected(true);
                onItemClickListener.onClickRuta(element);
            });
        }
    }
}
