package ru.makar.ecj.tutorials.tutorial4.node;

public class Sub extends AbstractOperationNode {
    @Override
    protected double calc(double x, double y) {
        return x - y;
    }

    @Override
    public String toString() {
        return " - ";
    }
}
