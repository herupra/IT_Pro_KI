package com.calculabot.formulas;

import java.util.ArrayList;

/**
 * @author Zeed
 * Calculabot Formula Template
 */
//always write your class name in LOWERCASE, remember LOWERCASE
public class template extends BasicFormula {
	
	//This is the question ArrayList that will store your question
    ArrayList<String> question = new ArrayList<String>();
    
    //Getter for question, don't change it
    public ArrayList<String> getQuestion() {
        return question;
    }
    
    /*
     * Method to initiate the question, question.add(Your Question here)
     * the number of question is depends on how much you add
     */
    public void initiate(){
    	//TODO your input code, use question.add(String question)
    }
    
    /*
     * Method to do the algorithm, use math class if there's power or such
     * it will get the answer as ArrayList<String> input, the number of answer string
     * in the arraylist depends on the number of answer in the question
     * you can get the index based on the index of the question
     * 
     * The input is in STRING, so if you needed to calculate it as int or another clase
     * please use PARSE
     */
    public String operate(ArrayList<String> input){
    	//TODO your code, remeber, use PARSE
    	
    	
        return Double.toString(result);
    }
    
}
