package com.forg.java.core;

import java.math.BigDecimal;


public class NumberKest {

	public static void main(String[] args) {
		NumberKest k = new NumberKest();
		String a = "1.00";
		String b = "211.11";
		
		//System.out.println("" + k.add(convToDouble(a),convToDouble(b)));
		System.out.println(double2Str3(convToDouble(b)));
		
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
    
    
    public static String double2Str(double pValue) {

    	Double d = pValue * 0.2;
    	return d.toString();
    }
    
    public static String double2Str2(double pValue) {
    	
    	BigDecimal d = new BigDecimal(pValue);
    	d = d.multiply(new BigDecimal(0.2));
    	
    	return d.toString();
    }
    
    public static String double2Str3(double pValue) {
    	
    	Double amountMoney = pValue * 0.002;
    	BigDecimal d = new BigDecimal(amountMoney);
    	return d.setScale(2,java.math.BigDecimal.ROUND_HALF_UP).doubleValue() +"" ;
    }

}
