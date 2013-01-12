package com.calculabot.formulas;

import java.util.ArrayList;

public class squarearea extends BasicFormula {
	ArrayList<String> question = new ArrayList<String>();
	   
    public ArrayList<String> getQuestion() {
        return question;
    }
    
    public void initiate(){
        question.add("Side? (in centimetre)");
    }
    
    public String operate(ArrayList<String> input){
        double result = (Double.parseDouble(input.get(0))*2);
        return Double.toString(result);
    }
}
