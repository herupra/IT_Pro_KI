package com.calculabot.controller;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import android.annotation.SuppressLint;
//import android.util.Log;
import com.calculabot.formulas.BasicFormula;
import com.calculabot.model.FormulaBase;
/**
 *
 * @author Zeed
 */
@SuppressLint("DefaultLocale")
public class ChatController {
	
	BasicFormula formula;
	FormulaBase base;
	String packageDir = "com.calculabot.formulas.";
	
	public ChatController(){
		formula = null;
		base = new FormulaBase();
	}
	
	public boolean checkEx(String name){
		return base.isExist(name);
		
	}
	
	public int checkType(String name){
		return base.checkType(name);
	}
	
	public BasicFormula getClass(String name) throws Exception {
		
		name = name.toLowerCase();
		
		Class clazz = Class.forName(packageDir + name);
        Class[] param = new Class[]{};
        Constructor cons = clazz.getConstructor(param);
        Object[] arguments = new Object[]{};
        formula = (BasicFormula)cons.newInstance(arguments);
		
		return formula;
	}
	
	public ArrayList<String> getQuetion(String name) throws Exception {
    	name = name.toLowerCase();
    	
        Class clazz = Class.forName(packageDir + name);
        Class[] param = new Class[]{};
        Constructor cons = clazz.getConstructor(param);
        Object[] arguments = new Object[]{};
        formula = (BasicFormula)cons.newInstance(arguments);
        
        formula.initiate();
        ArrayList<String> question = formula.getQuestion();
        
        return question;
    }

    public String sendAnswer(ArrayList<String> in){
    	return formula.operate(in);
    }
}
