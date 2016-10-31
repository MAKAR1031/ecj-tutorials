package ru.makar.ecj.tutorials.tutorial4;

import ec.gp.GPData;

public class DoubleData extends GPData {
    public double x;

    @Override
    public void copyTo(GPData gpd) {
        ((DoubleData) gpd).x = x;
    }
}
