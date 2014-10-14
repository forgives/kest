package com.forg.java.core;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class FormatKest {

	public static void main(String[] args) {
		//FormatKest k = new FormatKest();
		
		String n = "1234567.123";
		System.out.println(FormatKest.thousandSemicolon(n,false));
	}
	
	
//	public String thousandSemicolon(String src){
//		DecimalFormat ft = new DecimalFormat();
//		ft.applyPattern("###,###,###");
//		
//		return ft.format(Double.parseDouble(src));
//	}

	public static String thousandSemicolon(String src,boolean keepDecimal){
		String dest = "";
		BigDecimal b = new BigDecimal(src);
		DecimalFormat ft = new DecimalFormat();
		if(!keepDecimal){
			ft.applyPattern("#,###");
		}else{
			ft.applyPattern("#,###.####");
		}
		dest = ft.format(b);
		return dest;
	}
	
	public static String thousandSemicolon(String src){
		return thousandSemicolon(src,true);
	}
	
}
