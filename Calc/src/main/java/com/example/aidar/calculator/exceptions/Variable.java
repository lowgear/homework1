package com.example.aidar.calculator.exceptions;

/**
 * Created by aydar on 14.03.16.
 */
public class Variable implements TripleExpression {
    String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public double evaluate(double x, double y, double z) {
        switch (name) {
            case "x": return x;
            case "y": return y;
            case "z": return z;
        }
        throw new EvaluateException("Unrecognized variable name.");
    }
}
