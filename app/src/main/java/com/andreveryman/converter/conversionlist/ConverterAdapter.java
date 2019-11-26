package com.andreveryman.converter.conversionlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.andreveryman.converter.Conversion;
import com.andreveryman.converter.R;

import java.util.List;

/**
 * Created by Andrej Russkikh on 23.11.2019.
 */
public class ConverterAdapter extends RecyclerView.Adapter<ConverterAdapter.UnitViewHolder> {

    private List<Conversion> conversions;
    private MainItemClickListener listener;

    public interface MainItemClickListener{
        void click(Conversion conversion);
    }


    public ConverterAdapter(MainItemClickListener listener){
        this.listener = listener;
    }

    public void setItems(List<Conversion> units){
        this.conversions = units;
    }

    @NonNull
    @Override
    public UnitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_unit,parent,false);

        return new UnitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UnitViewHolder holder, final int position) {
        Conversion unit = conversions.get(position);
        holder.tvName.setText(unit.stringResLabel);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.click( conversions.get(position));
            }
        });


    }

    @Override
    public int getItemCount() {
        return conversions == null ? 0: conversions.size();
    }


    public  class UnitViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;

        public UnitViewHolder(@NonNull final View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);


        }
    }
}
