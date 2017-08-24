package ve.gob.fundelec.simlec.Main.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ve.gob.fundelec.simlec.DataBase.entities.Medidores;
import ve.gob.fundelec.simlec.R;

/**
 * Created by fundelec on 24/08/17.
 */

public class AdapterSearch extends RecyclerView.Adapter<AdapterSearch.MedidorViewHolder> {
    private List<Medidores> data;
    private ListenerMedidores listenerMedidores;

    public AdapterSearch(List<Medidores> medidores, ListenerMedidores listenerMedidores) {
        this.data = medidores;
        this.listenerMedidores = listenerMedidores;
    }

    @Override
    public MedidorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_search_medidor, parent, false);
        MedidorViewHolder pvh = new MedidorViewHolder(itemView);
        return pvh;
    }

    @Override
    public void onBindViewHolder(MedidorViewHolder holder, int position) {
        Medidores item = data.get(position);
        holder.bindMedidor(item);
        holder.setOnClickListener(item, listenerMedidores);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setList(List<Medidores> list){
        data.clear();
        data.addAll(list);
        notifyDataSetChanged();
    }

    public void add(Medidores medidor){
        data.add(0, medidor);
        notifyDataSetChanged();
    }

    public void clear(){
        data.clear();
        notifyDataSetChanged();
    }


    public class MedidorViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.titulo)
        TextView titulo;
        View itemView;

        public MedidorViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            ButterKnife.bind(this, itemView);

        }

        public void bindMedidor(Medidores medidor) {
            titulo.setText(medidor.getNumero());
        }

        public void setOnClickListener(Medidores medidor, ListenerMedidores listener) {
            itemView.setOnClickListener(v -> {
                listener.onClickMedidor(medidor);
            });
        }
    }
}
