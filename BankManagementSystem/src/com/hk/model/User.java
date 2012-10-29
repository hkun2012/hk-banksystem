package com.hk.model;

import java.io.Serializable;

import com.hk.tool.Gender;
import com.hk.tool.UserRight;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2822684814134293283L;
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
	
	public UserRight getUserRight() {
		return this.userRight;
	}
	
	public String toString() {
		return this.userId + "  " + this.password + "  " 
				+ this.userName + "  " + this.age + "  " 
				+ this.gender + this.userRight; 
	}

	public void modifyInfo(String userName2, String age2, int choice,
			int gender2) {
		userName = userName2;
		age = Integer.valueOf(age2);
		if (choice == 1)
			userRight = UserRight.FRONT;
		else if (choice == 2)
			userRight = UserRight.MANAGER;
		else if (choice  == 3)
			userRight = UserRight.CONTROLLER;
		
		if (gender2 == 1)
			gender = Gender.MALE;
		if (gender2 == 2)
			gender = Gender.FEMALE;
	}
}
