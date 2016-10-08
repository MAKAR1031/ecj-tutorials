package ru.makar.ecj.tutorials.tutorial2;

import ec.BreedingPipeline;
import ec.EvolutionState;
import ec.Individual;
import ec.util.Parameter;
import ec.vector.IntegerVectorIndividual;
import ec.vector.IntegerVectorSpecies;
import ec.vector.VectorDefaults;

public class OurMutatorPipeline extends BreedingPipeline {

    public static final String P_OUR_MUTATION = "our-mutation";
    public static final int NUM_SOURCES = 1;

    @Override
    public int numSources() {
        return NUM_SOURCES;
    }

    @Override
    public int produce(int min, int max, int start, int subpopulation, Individual[] inds, EvolutionState state, int thread) {
        int n = sources[0].produce(min, max, start, subpopulation, inds, state, thread);
        if (!state.random[thread].nextBoolean(likelihood)) {
            return reproduce(n, start, subpopulation, inds, state, thread, false);
        }
        if (!(sources[0] instanceof BreedingPipeline)) {
            for (int q = start; q < n + start; q++) {
                inds[q] = (Individual) (inds[q].clone());
            }
        }
        if (!(inds[start] instanceof IntegerVectorIndividual)) {
            state.output.fatal("OurMutatorPipeline didn't get an " +
                    "IntegerVectorIndividual.  The offending individual is " +
                    "in subpopulation " + subpopulation + " and it's:" + inds[start]);
        }
        IntegerVectorSpecies species = (IntegerVectorSpecies) inds[start].species;
        for (int q= start; q < n + start; q++) {
            IntegerVectorIndividual i = (IntegerVectorIndividual) inds[q];
            for (int x = 0; x < i.genome.length; x++) {
                if (state.random[thread].nextBoolean(species.mutationProbability(x))) {
                    i.genome[x] = - i.genome[x];
                }
            }
            i.evaluated = false;
        }
        return n;
    }

    @Override
    public Parameter defaultBase() {
        return VectorDefaults.base().push(P_OUR_MUTATION);
    }
}
