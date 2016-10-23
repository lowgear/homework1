package com.example.aidar.calculator.exceptions;

/**
 * Created by aydar on 11.04.16.
 */
public class CheckedSqrt implements TripleExpression {
    final private TripleExpression expression;

    public CheckedSqrt(TripleExpression expression) {
        if (expression == null) {
            throw new NullPointerException();
        }
        this.expression = expression;
    }

    @Override
    public double evaluate(double x, double y, double z) {
        double s = expression.evaluate(x, y, z);
        if (s < 0) {
            throw new EvaluateException("Sqrt from negative number attempt.");
        }/*
        double l = 0;
        double r = s + 1;
        while (l + 1 < r) {
            double m = (l + r) / 2;
            if (m <= s / m) {
                l = m;
            } else {
                r = m;
            }
        }
        return l;*/
        return Math.sqrt(s);
    }
}
