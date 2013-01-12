package com.calculabot.model;

import java.util.ArrayList;
import java.util.Scanner;

import android.R;
import android.util.Log;

public class FormulaBase {
	ArrayList<String> formulaNames = new ArrayList<String>();
	ArrayList<Integer> types = new ArrayList<Integer>();
	ArrayList<String> info = new ArrayList<String>();
	
	
	
	public FormulaBase() {
		formulaNames = new ArrayList<String>();
		types = new ArrayList<Integer>();
		info = new ArrayList<String>();
		
		readFile();
		
	}
	
	public boolean isExist(String searchName){
		boolean exist = false;
		if(!formulaNames.isEmpty()){
			for(String i : formulaNames){
				if(i.equalsIgnoreCase(searchName)){
					exist = true;
				}
			}
		}
		return exist;
	}
	
	public int checkType(String searchName){
		for(int i = 0; i< formulaNames.size(); i++){
			if(formulaNames.get(i).equalsIgnoreCase(searchName)){
				return types.get(i);
			}
		}
		return 0;
	}
	
	public ArrayList<String> getNames(){
		return formulaNames;
	}
	
	public ArrayList<Integer> getTypes() {
		return types;
	}
	
	public ArrayList<String> getInfo() {
		return info;
	}
	
	//dummy class before serialization implemented
	public void addExample(){
		formulaNames.add("acceleration");
		types.add(1);
		info.add("SADSAD");
		formulaNames.add("circlearea");
		types.add(1);
		info.add("1");
		formulaNames.add("circlecircumference");
		types.add(1);
		info.add("1");
		formulaNames.add("force");
		types.add(1);
		info.add("1");
		formulaNames.add("mass");
		types.add(1);
		info.add("1");
		formulaNames.add("rectangulararea");
		types.add(1);
		info.add("1");
		formulaNames.add("rectangularcircumference");
		types.add(1);
		info.add("1");
		formulaNames.add("squarearea");
		types.add(1);
		info.add("1");
		formulaNames.add("boxvolume");
		types.add(1);
		info.add("1");
		formulaNames.add("boxsurface");
		types.add(1);
		info.add("1");
	}
	
	public void readFile(){
		try {
			String fname = "formuladata.txt";
			String dir = "res/raw/";
			   Scanner scan = new Scanner(this.getClass().getClassLoader().getResourceAsStream(dir + fname));
			   String[] p; //parsed string
			   while(scan.hasNext()){
				   p = scan.nextLine().split(",");
				   formulaNames.add(p[0]);
				   types.add(Integer.parseInt(p[1]));
				   info.add(p[2]);
				   //Log.i("mattibeku", "bzzzz" + title + " , " + text);
				   
			   }
			   scan.close();
			  } catch (Exception e) {
			   Log.i("ReadNWrite, readFile()", "bzzzz"+"Exception e = " + e);
			  }
	}
}
