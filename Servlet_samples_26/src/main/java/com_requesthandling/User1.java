package com_requesthandling;

public class User1 {


	private int userid;
	private String name;
	private String password;
	private String email;
	
	public User1() {
		
	}

	public User1(int userid, String name, String password, String email) {
		this.userid = userid;
		this.name = name;
		this.password = password;
		this.email = email;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User1 [userid=" + userid + ", name=" + name + ", password=" + password + ", email=" + email + "]";
	}
	
	

}
