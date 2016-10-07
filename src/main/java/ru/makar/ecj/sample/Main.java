package ru.makar.ecj.sample;

import ec.Evolve;

import static ec.Evolve.A_FILE;

public class Main {

    private static final String PARAMS = "src/main/resources/config/params.properties";

    public static void main(String[] args) {
        Evolve.main(new String[] {A_FILE, PARAMS});
    }
}
