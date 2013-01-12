package com.calculabot.formulas;

import java.util.ArrayList;

public class circlearea extends BasicFormula{
	ArrayList<String> question = new ArrayList<String>();
    
    
    
    

	   
    public ArrayList<String> getQuestion() {
        return question;
    }
    
    public void initiate(){
        question.add("Radius? (in centimetre)");
    }
    
    public String operate(ArrayList<String> input){
        double result = ((Double.parseDouble(input.get(0))*Double.parseDouble(input.get(0))))*Math.PI;
        return Double.toString(result);
    }
}
