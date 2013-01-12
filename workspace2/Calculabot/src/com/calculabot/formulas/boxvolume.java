package com.calculabot.formulas;

import java.util.ArrayList;

public class boxvolume extends BasicFormula{
	
		ArrayList<String> question = new ArrayList<String>();
	      
	    public ArrayList<String> getQuestion() {
	        return question;
	    }
	    
	    public void initiate(){
	        question.add("Width : " );
	        question.add("Length : " );
	        question.add("Height : " );
	    }
	    
	    public String operate(ArrayList<String> input){
	        double result = ((Double.parseDouble(input.get(0))*Double.parseDouble(input.get(1))))*Double.parseDouble(input.get(2));
	        return Double.toString(result);
	    }
	}
