package ru.makar.ecj.sample.problem;

import ec.EvolutionState;
import ec.Individual;
import ec.Problem;
import ec.simple.SimpleFitness;
import ec.simple.SimpleProblemForm;
import ec.vector.BitVectorIndividual;

public class MaxOnes extends Problem implements SimpleProblemForm {
    @Override
    public void evaluate(EvolutionState state, Individual ind, int subpopulation, int threadnum) {
        if (ind.evaluated) return;
        BitVectorIndividual ind2 = (BitVectorIndividual) ind;
        int sum = 0;
        for (int x = 0; x < ind2.genome.length; x++) {
            sum += (ind2.genome[x] ? 1 : 0);
        }
        ((SimpleFitness) ind2.fitness).setFitness(state, ((double) sum) / ind2.genome.length, sum == ind2.genome.length);
        ind2.evaluated = true;
    }
}
