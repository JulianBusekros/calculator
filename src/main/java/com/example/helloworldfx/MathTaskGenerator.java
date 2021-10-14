package com.example.helloworldfx;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MathTaskGenerator {

    private final Random r = new Random();

    public String getRandomEquation(){

        List<String> equation = new ArrayList<>();

        for(int i = 0; i < getRandomLength(); i++){
            equation.add(getRandomNumber());
            equation.add(getRandomOperator());
        }
        equation.remove(equation.size() - 1);

        return getEquationAsString(equation);
    }
    private int getRandomLength(){

        int x = 2;
        int y = 6;

        return r.nextInt(y-x) + x;
    }
    private String getRandomOperator(){

        int a = 1;
        int b = 4;

        int op = r.nextInt(b-a) + a;


        return switch (op) {
            case 1 -> "+";
            case 2 -> "-";
            case 3 -> "*";
            default -> "Fehler";
        };
    }
    private String getRandomNumber(){

        int x = 1;
        int y = 10;


        return r.nextInt(y-x) + x + "";
    }

    private String getEquationAsString(List<String> equation) {

        StringBuilder stringBuilder = new StringBuilder();
        for (String s : equation) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}
