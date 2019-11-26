package com.andreveryman.converter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Andrej Russkikh on 23.11.2019.
 */
public enum Conversion {
    //Заполнены значения для первых нескольких величин
    SURFACE  (R.string.surface, Arrays.asList(Unit.SQ_KILOMETRES, Unit.SQ_METRES, Unit.SQ_CENTIMETRES, Unit.HECTARE)),
    CURRENCY(R.string.currency,Arrays.asList(Unit.DOLLAR_US, Unit.RUBLE, Unit.EURO)),
    SPEED(R.string.speed, Arrays.asList(Unit.KPH, Unit.MPH, Unit.METERPS)),
    LENGTH(R.string.length, Arrays.asList(Unit.KILOMETRE, Unit.METRE, Unit.CENTIMETRE,Unit.MILLIMETRE, Unit.MICROMETRE, Unit.MILE)),
    WEIGHT   (R.string.weight,Arrays.asList(Unit.KG, Unit.TONNE, Unit.GRAMM, Unit.MG)),


    TEMPERATURE(R.string.temperature, Collections.<Unit>emptyList()),
    TIME(R.string.time, Collections.<Unit>emptyList()),
    VOLUME(R.string.volume, Collections.<Unit>emptyList()),
    PRESSURE(R.string.pressure,Collections.<Unit>emptyList()),
    ENERGY(R.string.energy, Collections.<Unit>emptyList()),
    FUEL(R.string.fuel, Collections.<Unit>emptyList()),
    POWER(R.string.power, Collections.<Unit>emptyList())
    ;


    public final int stringResLabel;
    public final List<Unit> units;


    Conversion(int label, List<Unit> units) {
        this.stringResLabel = label;
        this.units = units;

    }

    public static List<Conversion> createList(){
        return Arrays.asList(values());
    }



}