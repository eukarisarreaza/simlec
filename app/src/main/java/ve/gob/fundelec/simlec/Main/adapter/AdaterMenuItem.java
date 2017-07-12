package ve.gob.fundelec.simlec.Main.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ve.gob.fundelec.simlec.R;


/**
 * Created by root on 11/04/17.
 */

public class AdaterMenuItem extends ArrayAdapter {

    private Context context;
    private List<ItemMenu> data;

    public AdaterMenuItem(Context context, List<ItemMenu> data) {
        super(context, R.layout.item_menu);
        this.context = context;
        this.data = data;
    }

    @Nullable
    @Override
    public ItemMenu getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    public void setList(List<ItemMenu> list) {
        data.clear();
        data.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemMenu item = data.get(position);
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.item_menu, null, false);

        TextView tittle=(TextView)convertView.findViewById(R.id.tittle);
        ImageView imagen=(ImageView)convertView.findViewById(R.id.imagen);

        tittle.setText(item.getTexto());
        imagen.setImageResource(item.getImagen());
        imagen.setColorFilter(ContextCompat.getColor(context, item.getColor()));

        return convertView;
    }


}
