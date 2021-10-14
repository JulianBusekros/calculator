package com.example.helloworldfx;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Calculation {

    private final BasicArithmeticOperations arithmeticOperations = new BasicArithmeticOperations();
    private final List<String> operatorAndValueList = new ArrayList<>();

    public String doCalculation(String inputCalculationExpression){

        operatorAndValueList.clear();

        Matcher m = Pattern.compile("[-+*/()^√]|\\d*").matcher(inputCalculationExpression);

        while (m.find()){
            operatorAndValueList.add(m.group());
        }

        operatorAndValueList.remove(operatorAndValueList.size() - 1);

        return validation(operatorAndValueList);
    }

    private String validation(List<String> operatorsAndValues){

        try{
            return calculateResult(operatorsAndValues) + "";
        }
        catch(IllegalArgumentException exception){
            return exception.getMessage();
        }
    }

    public double calculateResult(List<String> operatorsAndValues) {

        while (operatorsAndValues.contains("(") && operatorsAndValues.contains(")")){
            calculateParentheses(operatorsAndValues);
        }

        int operatorIndex;

        while(operatorsAndValues.contains("√")){
            operatorIndex = operatorsAndValues.indexOf("√");
            double num = Double.parseDouble(operatorsAndValues.get(operatorIndex + 1));
            operatorsAndValues.set(operatorIndex + 1, arithmeticOperations.sqrt(num) + "");
            operatorsAndValues.remove(operatorIndex);
        }

        operatorIndex = 1;

        while(operatorsAndValues.contains("^") || operatorsAndValues.contains("*") || operatorsAndValues.contains("/") || operatorsAndValues.contains("+") || operatorsAndValues.contains("-")) {

            boolean repeat = false;

            double num1 = Double.parseDouble(operatorsAndValues.get(operatorIndex - 1));
            double num2 = Double.parseDouble(operatorsAndValues.get(operatorIndex + 1));

            if (operatorsAndValues.contains("^")){
                if (operatorsAndValues.get(operatorIndex).equals("^")) {
                    operatorsAndValues.set(operatorIndex + 1, arithmeticOperations.pow(num1, num2)+ "");
                    repeat = true;
                }
            }else if (operatorsAndValues.contains("*") || operatorsAndValues.contains("/")){
                if (operatorsAndValues.get(operatorIndex).equals("*")) {
                    operatorsAndValues.set(operatorIndex + 1, arithmeticOperations.mult(num1, num2) + "");
                    repeat = true;
                }
                if (operatorsAndValues.get(operatorIndex).equals("/")) {
                    operatorsAndValues.set(operatorIndex + 1, arithmeticOperations.div(num1, num2) + "");
                    repeat = true;
                }
            }else if (operatorsAndValues.contains("+") || operatorsAndValues.contains("-")){
                if (operatorsAndValues.get(operatorIndex).equals("+")) {
                    operatorsAndValues.set(operatorIndex + 1, arithmeticOperations.add(num1, num2)+ "");
                    repeat = true;
                }
                if (operatorsAndValues.get(operatorIndex).equals("-")) {
                    operatorsAndValues.set(operatorIndex + 1, arithmeticOperations.sub(num1, num2)+ "");
                    repeat = true;
                }
            }

            if(repeat){
                operatorsAndValues.remove(operatorIndex-1);
                operatorsAndValues.remove(operatorIndex-1);
            }
            else{
                operatorIndex += 2;
            }
            if(operatorIndex >= operatorsAndValues.size()){
                operatorIndex = 1;
            }
        }

        return Double.parseDouble(operatorsAndValues.get(0));
    }

    private void calculateParentheses(List<String> opsAndValues){

        List<String> parentheses = new ArrayList<>();

        for(int i = opsAndValues.indexOf("(")+1; i < opsAndValues.indexOf(")"); i++){
            parentheses.add(opsAndValues.get(i));
            opsAndValues.remove(i);
            i--;
        }

        calculateResult(parentheses);

        opsAndValues.set(opsAndValues.indexOf("("), parentheses.get(0));

        opsAndValues.remove(")");
    }
}
