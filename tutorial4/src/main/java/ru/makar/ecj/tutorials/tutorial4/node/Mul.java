package ru.makar.ecj.tutorials.tutorial4.node;

import ec.EvolutionState;
import ec.Problem;
import ec.gp.ADFStack;
import ec.gp.GPData;
import ec.gp.GPIndividual;
import ec.gp.GPNode;
import ec.util.Parameter;
import ru.makar.ecj.tutorials.tutorial4.DoubleData;

public class Mul extends GPNode {
    @Override
    public String toString() {
        return " * ";
    }

    @Override
    public void eval(EvolutionState state, int thread, GPData input, ADFStack stack, GPIndividual individual, Problem problem) {
        double result;
        DoubleData rd = ((DoubleData) (input));

        children[0].eval(state, thread, input, stack, individual, problem);
        result = rd.x;

        children[1].eval(state, thread, input, stack, individual, problem);
        rd.x = result * rd.x;
    }

    @Override
    public int expectedChildren() {
        return 2;
    }

    @Override
    public void checkConstraints(EvolutionState state, int tree, GPIndividual typicalIndividual, Parameter individualBase) {
        super.checkConstraints(state, tree, typicalIndividual, individualBase);
        if (children.length != 2) {
            state.output.error("Incorrect number of children for node " + toStringForError() + " at " + individualBase);
        }
    }
}
