package com.andreveryman.converter;

import androidx.annotation.StringRes;

public enum Unit {
    SQ_KILOMETRES(R.string.sq_kilometres, 1000000.0,0.000001),
    SQ_METRES(R.string.sq_metres,1.0, 1.0),
    SQ_CENTIMETRES(R.string.sq_centimetres, 0.0001, 10000.0),
    HECTARE(R.string.hectare, 10000.0, 0.0001),


    DOLLAR_US(R.string.usd,63.99,0.0156274417877),
    EURO(R.string.euro,70.43,0.0141984949595),
    RUBLE(R.string.ruble,1,1),


    KPH(R.string.kph,0.277,3.6),
    MPH(R.string.mph,0.44704,2.2369),
    METERPS(R.string.mps,1,1),


    KILOMETRE(R.string.kilometre, 1000.0, 0.001),
    MILE(R.string.mile, 1609.344, 0.00062137),
    METRE(R.string.metre, 1.0, 1.0),
    CENTIMETRE(R.string.centimetre, 0.01, 100),
    MILLIMETRE(R.string.millimetre, 0.001, 1000.0),
    MICROMETRE(R.string.micrometre, 0.000001, 1000000),


    KG(R.string.kg,1.0,1.0),
    GRAMM(R.string.gramm,0.001,1000),
    TONNE(R.string.tonne,1000,0.001),
    MG(R.string.mg, 0.000001, 1000000 );




    Unit(@StringRes  int label, double mConversionToBase, double conversionFromBase){
        labelResourse = label;
        this.conversionToBase = mConversionToBase;
        this.conversionFromBase = conversionFromBase;


    }





    @StringRes
    public int labelResourse;

    public double conversionToBase;
    public double conversionFromBase;




}
