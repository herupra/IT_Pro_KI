/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.calculabot.formulas;

import java.util.ArrayList;

 /**
 *
 * @author Zeed
 */
public abstract class BasicFormula implements Formula {
    
    double result;
    ArrayList<String> question = new ArrayList<String>();
    
    public BasicFormula(){};

   
    public ArrayList<String> getQuestion() {
        return question;
    }
    
    
    
    public abstract void initiate();
    public abstract String operate(ArrayList<String> input);
    
}
