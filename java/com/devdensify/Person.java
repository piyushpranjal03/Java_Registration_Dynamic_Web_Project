package com.devdensify;

public class Person {
	private String email;
	private String password;
	
	public Person(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}	
}