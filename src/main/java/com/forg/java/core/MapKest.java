package com.forg.java.core;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;

public class MapKest {

	public static void main(String[] args) {
		MapKest k = new MapKest();
		k.testHashtable();
	}

	public void testHashCode(){
		
		HashMap<String,String> m = new HashMap<String,String>();
		String k = "1";
		String v = "2";
		//System.out.println(k.hashCode());
		m.put("1", "1");
		
		//Entry.hashCode的实现  key.hashCode()异或value.hashCode()
		System.out.println(k.hashCode()^v.hashCode());
		
	}
	
	void testHashtable(){
		Hashtable<String,String> t = new Hashtable<String,String>(10);
		t.put("k1", "v1");
		t.put("k2", "v1");
		
		int size = t.size();
		Enumeration<String> e = t.elements();
		StringBuilder sb = new StringBuilder();
		while(e.hasMoreElements()){
			sb.append(e.nextElement()).append(",");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
		
	}
}
