package com.calculabot.formulas;

import java.util.ArrayList;

public class rectangularcircumference extends BasicFormula{
	ArrayList<String> question = new ArrayList<String>();
	   
    public ArrayList<String> getQuestion() {
        return question;
    }
    
    public void initiate(){
        question.add("Length? (in centimetre)");
        question.add("Width? (in centimetre)");
    }
    
    public String operate(ArrayList<String> input){
        double result = (2*(Double.parseDouble(input.get(0)))+(2*Double.parseDouble(input.get(1))));
        return Double.toString(result);
    }
}
