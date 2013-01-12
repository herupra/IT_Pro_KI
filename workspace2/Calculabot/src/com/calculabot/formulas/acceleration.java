package com.calculabot.formulas;

import java.util.ArrayList;

public class acceleration extends BasicFormula {
	
    
    public void initiate(){
        question.add("Mass (in kg)");
        question.add("Force (in newton)");
    }
    
    @Override
    public String operate(ArrayList<String> input){
        double result = Double.parseDouble(input.get(1))/Double.parseDouble(input.get(0));
        return Double.toString(result);
    }
}
