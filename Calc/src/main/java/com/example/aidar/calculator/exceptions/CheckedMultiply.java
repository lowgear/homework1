package com.example.aidar.calculator.exceptions;

/**
 * Created by aydar on 14.03.16.
 */
public class CheckedMultiply extends BinaryOperator {
    public CheckedMultiply(TripleExpression left, TripleExpression right) {
        super(left, right);
    }

    @Override
    protected double action(double left, double right) {
        if (left > right) {
            double t = left;
            left = right;
            right = t;
        }

        if ((left > 0 && left > Integer.MAX_VALUE / right) ||
                (right == Integer.MIN_VALUE) ||
                (right < 0 && left < (-Integer.MAX_VALUE) / (-right)) ||
                (right > 0 && left < Integer.MIN_VALUE / right)) {
            throw new EvaluateException("Multiply overflow.");
        }
        return left * right;
    }
}
