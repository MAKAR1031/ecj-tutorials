package ru.makar.ecj.tutorials.tutorial4;

import ec.Evolve;

import static ec.Evolve.A_FILE;

public class Main {
    private static final String PARAMS = "tutorial4/src/main/resources/params.properties";

    public static void main(String[] args) {
        Evolve.main(new String[]{A_FILE, PARAMS});
    }
}
