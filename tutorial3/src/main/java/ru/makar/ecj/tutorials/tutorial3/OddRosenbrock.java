package ru.makar.ecj.tutorials.tutorial3;

import ec.EvolutionState;
import ec.Individual;
import ec.Problem;
import ec.simple.SimpleFitness;
import ec.simple.SimpleProblemForm;
import ec.util.Parameter;
import ec.vector.DoubleVectorIndividual;

import static java.lang.Math.pow;

public class OddRosenbrock extends Problem implements SimpleProblemForm {

    @Override
    public void setup(EvolutionState state, Parameter base) {

    }

    @Override
    public void evaluate(EvolutionState state, Individual ind, int subpopulation, int threadnum) {
        double[] genome = ((DoubleVectorIndividual) ind).genome;
        int length = genome.length;
        double value = 0;

        for (int i = 1; i < length; i++) {
            value += pow((1 - genome[i - 1]), 2) +
                    100 * pow((pow(genome[i - 1], 2) - genome[i]), 2) ;
        }

        value = 1.0 / (1.0 + value);
        ((SimpleFitness) (ind.fitness)).setFitness(state, value, value == 1.0);
        ind.evaluated = true;
    }
}
