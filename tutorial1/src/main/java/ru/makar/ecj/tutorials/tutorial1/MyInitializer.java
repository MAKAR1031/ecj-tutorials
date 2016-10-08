package ru.makar.ecj.tutorials.tutorial1;

import ec.EvolutionState;
import ec.Initializer;
import ec.Population;
import ec.simple.SimpleInitializer;
import ec.util.Parameter;
import org.apache.log4j.Logger;

public class MyInitializer extends Initializer {

    private final static Logger LOG = Logger.getLogger(MyInitializer.class);

    private SimpleInitializer initializer;

    public MyInitializer() {
        initializer = new SimpleInitializer();
    }

    @Override
    public void setup(EvolutionState state, Parameter base) {
        LOG.info("");
        initializer.setup(state, base);
    }

    @Override
    public Population initialPopulation(EvolutionState state, int thread) {
        LOG.info("");
        return initializer.initialPopulation(state, thread);
    }

    @Override
    public Population setupPopulation(EvolutionState state, int thread) {
        LOG.info("");
        return initializer.setupPopulation(state, thread);
    }
}
