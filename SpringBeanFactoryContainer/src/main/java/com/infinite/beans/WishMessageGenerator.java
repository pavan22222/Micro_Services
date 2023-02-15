package com.infinite.beans;

import java.util.Date;

public class WishMessageGenerator {
	
	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public WishMessageGenerator(Date date) {
		System.out.println("1-Param Constructor"+date);
		this.date = date;
	}
	
	public WishMessageGenerator() {
		System.out.println("0-Param Constructor");
	}
	
	
	public String getMessage() {
		System.out.println(date);
		int hour=date.getHours();
		if( hour >= 1 && hour <= 12)
			return "Good Morning";
		else if(hour > 12 && hour < 16)
			return "Good Afternoon";
		else if(hour > 16 && hour < 20)
			return "Good Evening";
		else
			return "Good Night";
		
	}
	
	


}
