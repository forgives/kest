package com.forg.java.core;

public class AbstractStringBuilderKest {

	public static void main(String[] args) {
		AbstractStringBuilderKest k = new AbstractStringBuilderKest();
		k.testStringBuilder();
	}

	public void testStringBuilder() {
				
		String nullStr  = null;
		StringBuilder sb = new StringBuilder();
		sb.append("kest_null[");
		sb.append(nullStr);
		sb.append("]");
		
		System.out.println(sb.toString());
		
		
	}
}
