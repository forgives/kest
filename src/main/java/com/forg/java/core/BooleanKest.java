package com.forg.java.core;

public class BooleanKest {

	public static void main(String[] args) {
		BooleanKest k = new BooleanKest();
		boolean b = false ;
		k.showBoolean(b);
	}
	
	public void showBoolean(boolean b){
		if(!b){
			System.out.println("no");
		}else{
			System.out.println("yes");
		}
		
		
	}

}
