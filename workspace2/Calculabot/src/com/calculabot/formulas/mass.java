package com.calculabot.formulas;

import java.util.ArrayList;

public class mass extends BasicFormula {
	ArrayList<String> question = new ArrayList<String>();
    
    public ArrayList<String> getQuestion() {
        return question;
    }
    
    public void initiate(){
        question.add("Force? (in newton)");
        question.add("Acceleration? (in m/s^2)");
    }
    
    public String operate(ArrayList<String> input){
        result = (Double.parseDouble(input.get(0))*Double.parseDouble(input.get(1)));
        return Double.toString(result);
    }

}
