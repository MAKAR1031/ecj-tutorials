package ru.makar.ecj.tutorials.tutorial2;

import ec.Evolve;

import static ec.Evolve.A_FILE;

public class Main {

    private static final String PARAMS = "tutorial2/src/main/resources/params.properties";

    public static void main(String[] args) {
        Evolve.main(new String[] {A_FILE, PARAMS, "-p", "print-params=true"});
    }
}
