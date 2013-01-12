package com.calculabot.formulas;

import java.util.ArrayList;

/**
 * @author Zeed
 * Calculabot Formula Example
 */
//always write your class name in LOWERCASE, remember LOWERCASE
public class force extends BasicFormula {
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
        question.add("Mass? (in kg)");
        question.add("Acceleration? (in m/s^2)");
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
        result = (Integer.parseInt(input.get(0))*Integer.parseInt(input.get(1)));
        return Double.toString(result);
    }
    
}
