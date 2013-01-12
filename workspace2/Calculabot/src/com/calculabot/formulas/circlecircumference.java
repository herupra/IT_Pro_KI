package com.calculabot.formulas;

import java.util.ArrayList;

public class circlecircumference extends BasicFormula {
	ArrayList<String> question = new ArrayList<String>();
    
	   
    public ArrayList<String> getQuestion() {
        return question;
    }
    
    public void initiate(){
        question.add("Radius? (in centimetre)");
    }
    
    public String operate(ArrayList<String> input){
        double result = (Math.PI)*(2*Double.parseDouble(input.get(0)));
        return Double.toString(result);
    }
}
