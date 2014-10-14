package com.forg.java.core;

public class StringKest {

	public static void main(String[] args) {
		
		StringKest k = new StringKest();
//		String url = "http://pic.dbmeizi.com/npics/9c1/c2e/s_p9321106.jpg";
//		long s = System.currentTimeMillis();
//		String picName1 = url.split("/")[url.split("/").length - 1];
//		long m = System.currentTimeMillis();
//		String picName2 = url.substring(url.lastIndexOf("/")+1,url.length());
//		long e = System.currentTimeMillis();
//		
//		System.out.println("picName1 = " + picName1 + ",cost=" + (m-s) + "ms");
//		System.out.println("picName2 = " + picName2 + ",cost=" + (e-m) + "ms");
		
		k.testString();
	}
	
	public void testString(){
		String src = "9.00" ;
		int i = src.lastIndexOf(".");
		if (i >= 0) {
			System.out.println(src.charAt(i+1));
			//"0".equals(src.charAt(i+1)) <=========false
			if( "0".equals(src.substring(i+1,i+2)) ){
				src = src.substring(0,i);
			}else{
				src =  src.substring(0,i+2);
			}
		} else {
			src = src ;
		}
		System.out.println(src);
	}

}
