package com.andreveryman.converter.conversionlist;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.andreveryman.converter.Conversion;
import com.andreveryman.converter.R;
import com.andreveryman.converter.conversiondetail.ConversionActivity;

public class MainActivity extends AppCompatActivity implements ConverterAdapter.MainItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = findViewById(R.id.rv_conversion);
        ConverterAdapter adapter = new ConverterAdapter(this);
        adapter.setItems(Conversion.createList());

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rv.setLayoutManager(manager);
        rv.addItemDecoration(new DividerItemDecoration(this,RecyclerView.VERTICAL));
        rv.setAdapter(adapter);




    }

    @Override
    public void click(Conversion conversion) {
        startActivity(ConversionActivity.getStartIntent(this, conversion));
    }
}
