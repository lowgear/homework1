package com.example.aidar.calculator.exceptions;

/**
 * Created by aydar on 04.04.16.
 */
public class CheckedNegate implements TripleExpression {
    final private TripleExpression expression;

    public CheckedNegate(TripleExpression expression) {
        if (expression == null) {
            throw new NullPointerException();
        }
        this.expression = expression;
    }

    @Override
    public double evaluate(double x, double y, double z) {
        double res = expression.evaluate(x, y, z);
        if (res == Integer.MIN_VALUE)
            throw new EvaluateException("Negate of MIN_double attempt.");
        return -res;
    }
}
