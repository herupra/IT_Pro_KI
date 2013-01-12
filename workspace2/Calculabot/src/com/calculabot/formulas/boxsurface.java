package com.calculabot.formulas;

import java.util.ArrayList;

public class boxsurface extends boxvolume {
		
			ArrayList<String> question = new ArrayList<String>();
		      
		    
		    
		    public String operate(ArrayList<String> input){
		    	double a = Double.parseDouble(input.get(0));
		    	double b = Double.parseDouble(input.get(1));
		    	double c = Double.parseDouble(input.get(2));
		    	return Double.toString(2*((a*c)+(a*b)+(b*c)));
		    }
		}
