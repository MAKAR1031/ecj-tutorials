package ru.makar.ecj.tutorials.tutorial4.node;

import ec.EvolutionState;
import ec.Problem;
import ec.gp.ADFStack;
import ec.gp.GPData;
import ec.gp.GPIndividual;
import ec.gp.GPNode;
import ec.util.Parameter;
import ru.makar.ecj.tutorials.tutorial4.DoubleData;

public abstract class AbstractOperationNode extends GPNode {

    protected abstract double calc(double x, double y);

    @Override
    public int expectedChildren() {
        return 2;
    }

    @Override
    public void eval(EvolutionState state, int thread, GPData input, ADFStack stack, GPIndividual individual, Problem problem) {
        DoubleData rd = ((DoubleData) (input));
        children[0].eval(state, thread, input, stack, individual, problem);
        double x = rd.x;
        children[1].eval(state, thread, input, stack, individual, problem);
        double y = rd.x;
        rd.x = this.calc(x, y);
    }

    @Override
    public void checkConstraints(EvolutionState state, int tree, GPIndividual typicalIndividual, Parameter individualBase) {
        super.checkConstraints(state, tree, typicalIndividual, individualBase);
        if (children.length != 2) {
            state.output.error("Incorrect number of children for node " + toStringForError() + " at " + individualBase);
        }
    }
}
