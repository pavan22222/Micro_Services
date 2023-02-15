package com.infinite.beans;

public class SingleTon {
	
	private static SingleTon singleTon;
	
	private SingleTon() {
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String name;

	
	public static SingleTon getInstance() {
		System.out.println("getInstance()");
		if(singleTon == null)
			singleTon = new SingleTon();
		return singleTon;
	}
	
	


}
