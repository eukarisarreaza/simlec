package ve.gob.fundelec.simlec.ListaCallesAvenidas.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ve.gob.fundelec.simlec.ListaCallesAvenidas.entities.QueryCalles;
import ve.gob.fundelec.simlec.R;

/**
 * Created by root on 08/04/17.
 */

public class AdapterCallesAvenidas extends RecyclerView.Adapter<AdapterCallesAvenidas.CallesAvenidasViewHolder> {
    private List<QueryCalles> datos;
    private OnClickCallesAvenidas onItemClickListener;
    private int posSeleccionado;

    public AdapterCallesAvenidas(List<QueryCalles> datos, OnClickCallesAvenidas onItemClickListener) {
        this.datos = datos;
        this.onItemClickListener = onItemClickListener;
        this.posSeleccionado = -1;
    }

    @Override
    public CallesAvenidasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_calles_avenidas, parent, false);
        CallesAvenidasViewHolder pvh = new CallesAvenidasViewHolder(itemView);
        return pvh;
    }

    @Override
    public void onBindViewHolder(CallesAvenidasViewHolder holder, int position) {
        QueryCalles item = datos.get(position);
        holder.bindUnidadLectura(item);
        holder.setOnItemClickListener(item, onItemClickListener, position);
    }

    public void setList(List<QueryCalles> list) {
        datos.clear();
        datos.addAll(list);
        notifyDataSetChanged();
    }

    public void add(QueryCalles unidadLectura) {
        datos.add(0, unidadLectura);
        notifyDataSetChanged();
    }

    public void clear() {
        datos.clear();
        notifyDataSetChanged();
    }

    public int getPosSeleccionado() {
        return posSeleccionado;
    }

    public QueryCalles getItem(int position){
        return datos.get(position);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }


    public class CallesAvenidasViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.nom_calle)
        TextView nomCalle;
        @BindView(R.id.avance)
        TextView avance;
        @BindView(R.id.progressso)
        TextView progressso;
        @BindView(R.id.progressBar)
        ProgressBar progressBar;
        private View item;

        public CallesAvenidasViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.item = itemView;
        }

        public void bindUnidadLectura(QueryCalles unidadLectura) {
            nomCalle.setText(unidadLectura.getNom_calle());
            avance.setText(unidadLectura.getCant_lect_gestionadasŗ()+"/"+unidadLectura.getCant_lect_programadas());
            float div=(unidadLectura.getCant_lect_gestionadasŗ()*100)/unidadLectura.getCant_lect_programadas();
            progressso.setText(div+"%");
            progressBar.setProgress((int)div);
        }

        public void setOnItemClickListener(final QueryCalles element, final OnClickCallesAvenidas onItemClickListener, final int position) {
            itemView.setOnClickListener(v -> {


                LinearLayout myBackground = (LinearLayout) v.findViewById(R.id.content);
                if (posSeleccionado != -1 && !(position == posSeleccionado)) {
                    return;
                }
                if (posSeleccionado == position) {
                    myBackground.setBackgroundResource(android.R.color.white);
                    posSeleccionado = -1;
                } else {
                    myBackground.setBackgroundResource(android.R.color.darker_gray);
                    posSeleccionado = position;
                }
                onItemClickListener.onClickUnidadLectura(element);


            });
        }


    }
}
