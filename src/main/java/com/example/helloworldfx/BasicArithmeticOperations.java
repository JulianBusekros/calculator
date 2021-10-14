package com.example.helloworldfx;

public class BasicArithmeticOperations {

    public double add(double value1, double value2){
        return value1 + value2;
    }

    public double sub(double value1, double value2){
        return value1 - value2;
    }

    public double mult(double value1, double value2){
        return value1 * value2;
    }

    public double div(double value1, double value2){
        if(value2 == 0){
            throw new IllegalArgumentException("Division durch 0 nicht möglich!");
        }
        else{
            return value1 / value2;
        }
    }

    public double pow(double value1, double value2){
        return Math.pow(value1, value2);
    }

    public double sqrt(double value){
        return Math.sqrt(value);
    }
}
