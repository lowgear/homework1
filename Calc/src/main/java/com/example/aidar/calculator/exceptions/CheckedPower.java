package com.example.aidar.calculator.exceptions;

/**
 * Created by aydar on 11.04.16.
 */
public class CheckedPower extends BinaryOperator {
    public CheckedPower(TripleExpression left, TripleExpression right) {
        super(left, right);
    }

    @Override
    protected double action(double left, double right) {
        /*if (right < 0) {
            throw new EvaluateException("Negative power level is giver for integer power.");
        }*/
        if (left == 0 && right == 0) {
            throw new EvaluateException("Base and lavel are zero.");
        }
        if (left == 0) {
            return 0;
        }
        /*double res = 1;
        while (right != 0) {
            if (right % 2 == 1) {
                if ((res * left) / left != res) {
                    throw new EvaluateException("Power overflow.");
                }
                res *= left;
            }
            right /= 2;
            if (right != 0) {
                if ((left * left) / left != left) {
                    throw new EvaluateException("Power overflow.");
                }
                left *= left;
            }
        }
        return res;*/
        return Math.pow(left, right);
    }
}
