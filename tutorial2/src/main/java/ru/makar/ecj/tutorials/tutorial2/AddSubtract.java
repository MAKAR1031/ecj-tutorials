package ru.makar.ecj.tutorials.tutorial2;

import ec.EvolutionState;
import ec.Individual;
import ec.Problem;
import ec.simple.SimpleFitness;
import ec.simple.SimpleProblemForm;
import ec.vector.IntegerVectorIndividual;

public class AddSubtract extends Problem implements SimpleProblemForm {

    @Override
    public void evaluate(EvolutionState state, Individual ind, int subpopulation, int threadnum) {
        if (ind.evaluated) {
            return;
        }
        if (!(ind instanceof IntegerVectorIndividual)) {
            state.output.fatal("Whoa!  It's not a IntegerVectorIndividual!!!", null);
        }
        IntegerVectorIndividual ind2 = (IntegerVectorIndividual) ind;
        int rawFitness = 0;
        for (int x = 0; x < ind2.genome.length; x++) {
            if (x % 2 == 0) {
                rawFitness += ind2.genome[x];
            } else {
                rawFitness -= ind2.genome[x];
            }
            if (rawFitness < 0) {
                rawFitness = -rawFitness;
            }
            if (!(ind2.fitness instanceof SimpleFitness)) {
                state.output.fatal("Whoa!  It's not a SimpleFitness!!!",null);
            }
            ((SimpleFitness) ind2.fitness).setFitness(state, ((double)rawFitness)/ind2.genome.length, false);
            ind2.evaluated = true;
        }
    }
}
