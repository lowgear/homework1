package com.example.aidar.calculator.exceptions;

/**
 * Created by aydar on 04.04.16.
 */
public class Const implements TripleExpression {
    final private double value;

    public Const(double value) {
        this.value = value;
    }

    @Override
    public double evaluate(double x, double y, double z) {
        return value;
    }
}
