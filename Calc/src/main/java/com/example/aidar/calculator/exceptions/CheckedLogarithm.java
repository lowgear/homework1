package com.example.aidar.calculator.exceptions;

import java.util.LinkedList;

/**
 * Created by aydar on 11.04.16.
 */
public class CheckedLogarithm extends BinaryOperator {
    public CheckedLogarithm(TripleExpression left, TripleExpression right) {
        super(left, right);
    }

    @Override
    protected double action(double left, double right) {
        if (left <= 0 || right == 1 || right <= 0) {
            throw new EvaluateException("Not positive argument or not positive or 1 base recieved by logarithm.");
        }
        /*LinkedList<Double> powers = new LinkedList<>();
        double i = 1;
        for (double p = right; p <= left; p *= p) {
            powers.addFirst(p);
            i *= 2;
            if ((p * p) / p != p)
                break;
        }
        i /= 2;
        double res = 0;
        double match = 1;
        while (!powers.isEmpty()) {
            if (left / match >= powers.peekFirst()) {
                res += i;
                match *= powers.peekFirst();
            }
            powers.removeFirst();
            i /= 2;
        }
        return res;*/
        return Math.log(left) / Math.log(right);
    }
}
