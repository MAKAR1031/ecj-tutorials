package ru.makar.ecj.tutorials.tutorial4.node;

import ec.EvolutionState;
import ec.Problem;
import ec.gp.ADFStack;
import ec.gp.GPData;
import ec.gp.GPIndividual;
import ec.gp.GPNode;
import ru.makar.ecj.tutorials.tutorial4.DoubleData;
import ru.makar.ecj.tutorials.tutorial4.MultiValuedRegression;

public class X extends GPNode {
    @Override
    public String toString() {
        return "X";
    }

    @Override
    public int expectedChildren() {
        return 0;
    }

    @Override
    public void eval(EvolutionState state, int thread, GPData input, ADFStack stack, GPIndividual individual, Problem problem) {
        DoubleData rd = ((DoubleData) (input));
        rd.x = ((MultiValuedRegression) problem).currentX;
    }
}
