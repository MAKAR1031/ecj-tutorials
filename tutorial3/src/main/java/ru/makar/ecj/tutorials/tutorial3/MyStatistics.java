package ru.makar.ecj.tutorials.tutorial3;

import ec.EvolutionState;
import ec.Statistics;
import ec.util.Parameter;
import ec.vector.DoubleVectorIndividual;

import java.io.File;
import java.io.IOException;

public class MyStatistics extends Statistics {
    public static final String P_POPFILE = "pop-file";
    public static final String P_INFOFILE = "info-file";

    public int popLog;
    public int infoLog;

    @Override
    public void setup(EvolutionState state, Parameter base) {
        super.setup(state, base);
        File popFile = state.parameters.getFile(base.push(P_POPFILE), null);
        if (popFile != null) {
            try {
                popLog = state.output.addLog(popFile, true);
            } catch (IOException e) {
                state.output.fatal("An IOException occurred while trying to create the log " + popFile + ":\n" + e);
            }
        }

        File infoFile = state.parameters.getFile(base.push(P_INFOFILE), null);
        if (infoFile != null) {
            try {
                infoLog = state.output.addLog(infoFile, true);
            } catch (IOException e) {
                state.output.fatal("An IOException occurred while trying to create the log " + infoFile + ":\n" + e);
            }
        }
    }

    @Override
    public void postEvaluationStatistics(EvolutionState state) {
        super.postEvaluationStatistics(state);
        state.output.print("-----------------------\nGENERATION " + state.generation + "\n-----------------------", popLog);
        state.population.printPopulation(state, popLog);
        int best = 0;
        double bestValue = ((DoubleVectorIndividual) state.population.subpops[0].individuals[0]).genome[3];
        for (int y = 1; y < state.population.subpops[0].individuals.length; y++) {
            double value = ((DoubleVectorIndividual) state.population.subpops[0].individuals[y]).genome[3];
            if (value > bestValue)  {
                best = y;
                bestValue = value;
            }
        }
        state.population.subpops[0].individuals[best].printIndividualForHumans(state, infoLog);
    }
}
