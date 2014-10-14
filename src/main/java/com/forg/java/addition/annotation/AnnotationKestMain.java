package com.forg.java.addition.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationKestMain {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		AnnotationKestBean  b = new AnnotationKestBean();
		Field[] fs = AnnotationKestBean.class.getDeclaredFields();
		Method[] ms = AnnotationKestBean.class.getDeclaredMethods();
		AnnotationKest k = null;
		
		for (Method m : ms) {
			if( (k = m.getAnnotation(AnnotationKest.class)) != null){
				m.invoke(b, k.val());
			}
		}
		
		b.sayHello();
		for (Field f : fs){
			if( (k = f.getAnnotation(AnnotationKest.class)) != null){
				f.setAccessible(true);
				f.set(b,k.val());
				
			}
		}
		b.sayHello();
	}

}
