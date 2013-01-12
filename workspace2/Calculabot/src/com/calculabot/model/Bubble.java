package com.calculabot.model;

public class Bubble {
	String input;
	int type; //0 = human, 1 = bot
	
	public Bubble(String in, int ty){
		input = in;
		type = ty;
	}
	
	public String getInput() {
		return input;
	}
	public int getType() {
		return type;
	}
}
