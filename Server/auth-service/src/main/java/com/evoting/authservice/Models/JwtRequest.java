package com.evoting.authservice.Models;

import java.io.Serializable;

public class JwtRequest implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;

	//username = cin
	private String cin;
	private String password;
	
	//need default constructor for JSON Parsing
	public JwtRequest(){}

	public JwtRequest(String cin, String password) {
		this.cin = cin;
		this.password = password;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}