package com.example.aidar.calculator.exceptions;

/**
 * Created by aydar on 14.03.16.
 */
public class CheckedDivide extends BinaryOperator {
    public CheckedDivide(TripleExpression left, TripleExpression right) {
        super(left, right);
    }

    @Override
    protected double action(double left, double right) {
        if (right == 0) {
            throw new EvaluateException("Zero devisor recieved.");
        }
        if (left == Integer.MIN_VALUE && right == -1) {
            throw new EvaluateException("MIN_double divided by -1.");
        }
        return left / right;
    }
}
