package com.mrlglobal.simplecalc;


public class CalculatorOperation {

    private String op;
    private double a;
    private double b;
    private double result;

    CalculatorOperation(double a, double b, String op){
        this.a = a;
        this.b = b;
        this.op = op;

        double result = 0;
        switch (op){
            case "+": result = a + b;
                break;
            case "-": result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
        }
        this.result = result;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getResult() {
        return result;
    }
}
