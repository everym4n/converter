package com.andreveryman.converter.conversiondetail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.andreveryman.converter.R;
import com.andreveryman.converter.Unit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrej Russkikh on 23.11.2019.
 */
public class SpinnerAdapter extends BaseAdapter {

    private List<Unit> units;


    public SpinnerAdapter(List<Unit> units){
        this.units = new ArrayList<>(units);
    }
    @Override
    public int getCount() {
        return units == null ? 0:units.size();
    }

    @Override
    public Object getItem(int position) {
        return units.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_conversion, parent, false);
            SpinnerViewHolder vh = new SpinnerViewHolder(convertView);
            convertView.setTag(vh);
        }
        SpinnerViewHolder viewHolder = (SpinnerViewHolder)convertView.getTag();
        viewHolder.tvUnit.setText(units.get(position).labelResourse);
        return convertView;
    }


    private static class SpinnerViewHolder{
        TextView tvUnit;
        public SpinnerViewHolder(View itemView){
            tvUnit = itemView.findViewById(R.id.tv_name);
        }

    }
}
