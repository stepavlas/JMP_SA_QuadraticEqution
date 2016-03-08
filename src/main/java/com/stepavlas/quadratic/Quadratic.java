package com.stepavlas.quadratic;

import com.stepavlas.calculator.Calculator;

public class Quadratic {
    Calculator calculator = new Calculator();

    public static void main(String[] args) {
        if (args.length != 2 && args.length != 3){
            throw new IllegalArgumentException();
        }
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c;
        if (args.length == 2){
            c = 0;
        } else {
            c = Integer.parseInt(args[2]);
        }
        Quadratic quadratic = new Quadratic();
        try {
            double[] result = quadratic.findX(a, b, c);
            if (result.length == 1){
                System.out.println("x1/2 = " + result[0]);
            } else {
                System.out.println("x1 = " + result[0] + " x2 = " + result[1]);
            }
        } catch (ArithmeticException ae) {
            System.out.println("D < 0");
        }
    }

    private int defineD(int a, int b, int c){
        return calculator.power(b) - 4 * a * c;
    }

    public double[] findX(int a, int b, int c){
        double[] roots;
        int D = defineD(a, b, c);
        double doubleA = a;
        double doubleB = b;
        if (D > 0){
            roots = new double[2];
            double x1 = (-doubleB + calculator.root(D)) / (2 * doubleA);
            double x2 = (-doubleB - calculator.root(D)) / (2 * doubleA);
            roots[0] = x1;
            roots[1] = x2;
        } else if (D == 0){
            roots = new double[1];
            double x = -doubleB / (2 * doubleA);
            roots[0] = x;
        } else {
            throw new ArithmeticException();
        }
        return roots;
    }
}
