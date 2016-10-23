package com.example.aidar.calculator.exceptions;

/**
 * Created by aydar on 04.04.16.
 */
abstract class BinaryOperator implements TripleExpression {
    private final TripleExpression left, right;

    public BinaryOperator(TripleExpression left, TripleExpression right) {
        if (left == null || right == null) {
            throw new NullPointerException("Null pointer given to constructor.");
        }
        this.left = left;
        this.right = right;
    }

    @Override
    public double evaluate(double x, double y, double z) {
        return action(left.evaluate(x, y, z), right.evaluate(x, y, z));
    }

    protected abstract double action(double left, double right);
}