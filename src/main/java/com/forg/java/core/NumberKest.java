package com.forg.java.core;

public class NumberKest {

	public static void main(String[] args) {
		NumberKest k = new NumberKest();
		String a = "1.00";
		String b = "2.01";
		
		System.out.println("" + k.add(convToDouble(a),convToDouble(b)));
		
	}
	
	public double add(double a, double b){
		return a+b ;
	}
	
    public static double convToDouble(Object pValue) {
        double dblValue = 0;
        if (pValue == null) {
            return dblValue;
        }

        try {
            dblValue = Double.parseDouble(String.valueOf(pValue).trim().replace(",", ""));
        } catch (Exception e) {
            return dblValue;
        }
        return dblValue;
    }
	

}
