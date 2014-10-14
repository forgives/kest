package com.forg.java.addition.annotation;

public class AnnotationKestBean {

	@AnnotationKest(val="kest_f")
	private String name = "none";
	
	public void sayHello(){
		System.out.println("hello," + name);
	}
	
	@AnnotationKest(val="kest_m")
	public void sayHello(String n){
		System.out.println("hello," + n);
	}
}
