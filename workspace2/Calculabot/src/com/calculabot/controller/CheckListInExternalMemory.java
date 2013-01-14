package com.calculabot.controller;

import java.io.File;


import android.content.Context;




public class CheckListInExternalMemory {
	
	Context baleTampan;
	
	public CheckListInExternalMemory(Context z){
		
		baleTampan=z;
		
	}
	

	boolean hasExternalStoragePrivateFile(String wow ) {
	    // Get path for the file on external storage.  If external
	    // storage is not currently mounted this will fail.
	    File file = new File(baleTampan.getExternalFilesDir(null),wow +".class");
	    if (file != null) {
	        return file.exists();
	    }
	    return false;
	}
}
