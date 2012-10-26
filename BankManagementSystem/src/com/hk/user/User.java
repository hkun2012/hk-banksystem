package com.hk.user;

import com.hk.tool.Gender;
import com.hk.tool.UserRight;

public class User {
	private String userId;
	private String password;
	private String userName;
	private int age;
	private Gender gender;
	private UserRight userRight;
	
	public User() {
		
	}
	
	public User(String id, String pd, int userRight) {
		this.userId = id;		this.password = pd;
		if (userRight == 0)
			this.userRight = UserRight.FRONT;
		if (userRight == 1)
			this.userRight = UserRight.MANAGER;
		if (userRight == 2)
			this.userRight = UserRight.CONTROLLER;
		else
			this.userRight = UserRight.ADMIN;
			
	}
	
	public boolean matchPassword(String pd) {
		return this.password.equals(pd);
	}
	
	public String toString() {
		return new String(userId);
	}

	public boolean isAdmin() {
		return this.userRight == UserRight.ADMIN;
	}

	public void setBasicInfo(String userName2, int age2, Gender gender2) {
		this.userName = userName2;
		this.age = age2;
		this.gender = gender2;
	}

	public String getUserId() {
		return this.userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public int getUserAge() {
		return this.age;
	}

	public String getUserGender() {
		return String.valueOf(this.gender);
	}
}
