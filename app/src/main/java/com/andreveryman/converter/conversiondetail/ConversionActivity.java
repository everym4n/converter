package com.andreveryman.converter.conversiondetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.andreveryman.converter.Conversion;
import com.andreveryman.converter.R;
import com.andreveryman.converter.Unit;

public class ConversionActivity extends AppCompatActivity {
    public static final String ITEM_EXTRA_KEY = "conversion";

    private  Conversion conversion;
    private Unit fromUnit;
    private Unit toUnit;


    private EditText et_from;
    private EditText et_to;
    private TextView tv_from;
    private TextView tv_to;
    private Spinner spinner_from;
    private Spinner spinner_to;



    public static Intent getStartIntent(Context context, Conversion conversion){
        Intent intent = new Intent(context,ConversionActivity.class);
        intent.putExtra(ITEM_EXTRA_KEY,conversion);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);

        Intent intent = getIntent();
        if(intent!=null){
           Bundle bundle =  intent.getExtras();
           if(bundle!=null){
               conversion = (Conversion) bundle.getSerializable(ITEM_EXTRA_KEY);
           }else{
               return;
           }
        }

        et_from = findViewById(R.id.et_from_input);
        et_to = findViewById(R.id.et_to_input);

        tv_from = findViewById(R.id.tv_from_title);
        tv_to = findViewById(R.id.tv_to_title);
        spinner_from = findViewById(R.id.spinner_from_unit);
        spinner_to = findViewById(R.id.spinner_to_unit);


        initUnits();

        initSpinner();

        initEditText();
    }

    private void initUnits() {
        if(conversion.units.size() == 0)
            return;

        fromUnit = conversion.units.get(0);
        toUnit = conversion.units.get(0);
        tv_to.setText(toUnit.labelResourse);
        tv_from.setText(fromUnit.labelResourse);

    }

    private void initEditText() {
        et_from.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculateToValue(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void calculateToValue(String s) {
        if(TextUtils.isEmpty(s)){
            et_to.setText("");
            return;
        }
        try{
            double fromValue = Double.parseDouble(s);
            double resultValue = fromValue * fromUnit.conversionToBase * toUnit.conversionFromBase;
            et_to.setText(getResources().getString(R.string.result_value,resultValue));

        }catch (Exception e){

        }
    }

    private void initSpinner() {
        if(conversion.units == null || conversion.units.size() == 0){
            spinner_from.setVisibility(View.GONE);
            spinner_to.setVisibility(View.GONE);
            return;
        }
        SpinnerAdapter adapter = new SpinnerAdapter(conversion.units);
        spinner_from.setAdapter(adapter);
        spinner_to.setAdapter(adapter);
        spinner_from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fromUnit = conversion.units.get(position);
                tv_from.setText(fromUnit.labelResourse);
                calculateToValue(et_from.getText().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_to.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                toUnit = conversion.units.get(position);
                tv_to.setText(toUnit.labelResourse);
                calculateToValue(et_from.getText().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }
}
