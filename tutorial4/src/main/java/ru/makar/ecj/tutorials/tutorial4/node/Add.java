package ru.makar.ecj.tutorials.tutorial4.node;

public class Add extends AbstractOperationNode {
    @Override
    public String toString() {
        return " + ";
    }

    @Override
    protected double calc(double x, double y) {
        return x + y;
    }
}
