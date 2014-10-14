package com.forg.java.core;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class ListKest {

	public static void main(String[] args) {
		ListKest k = new ListKest();
		k.testLinkedListAddAll();
	}
	
	public void kestListRemoveAllNull(){
		List<String> lista = new ArrayList<String>();
		List<String> listb = null;//new ArrayList<String>();
		
		lista.add("1");
		lista.add("2");
		lista.add("3");
		
		// java.lang.NullPointerException
		// at java.util.AbstractCollection.removeAll(AbstractCollection.java:336)
		/*
		    public boolean removeAll(Collection<?> c) {
			boolean modified = false;
			Iterator<?> e = iterator();
			while (e.hasNext()) {
			    if (c.contains(e.next())) {  	<====java.lang.NullPointerException
				e.remove();
				modified = true;
			    }
			}
			return modified;
		    }
		 */
		lista.removeAll(listb);
		
		System.out.println(lista.size());
	}
	
	public void testGetModCount(){
		
		ArrayList<String> list = new ArrayList<String>();
		//System.out.println(list.modCount); <===The field AbstractList<String>.modCount is not visible
		
	} 
	
	
	public void testRemoveRange(){
		List<String> lista = new ArrayList<String>();
		lista.add("1");
		lista.add("2");
		lista.add("3");
		lista.add("4");
		
		lista.subList(1, 3).clear();
		System.out.println(JSON.toJSONString(lista));
		
	}
	
	public void testLinkedListAddAll(){
		List <String>list = new LinkedList<String>();
		List<String> arrayList = new ArrayList<String>();
		arrayList.add("1");
		arrayList.add("2");
		arrayList.add("3");
		
		list.addAll(1,arrayList);
		System.out.println(JSON.toJSONString(list));
	}
	
}

@SuppressWarnings("rawtypes")
class ListKestSubClass extends AbstractList{

	@Override
	public Object get(int index) {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}
	
	public void testGetModCount(){
		
		ListKestSubClass list = new ListKestSubClass();
		System.out.println(list.modCount); //<===self's modCount
		
	} 
}
