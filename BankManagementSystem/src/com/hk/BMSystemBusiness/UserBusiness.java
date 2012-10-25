package com.hk.BMSystemBusiness;

import java.util.ArrayList;

import javax.lang.model.element.NestingKind;

import com.hk.tool.Gender;
import com.hk.tool.IDGenerator;
import com.hk.user.User;

public class UserBusiness {
private  ArrayList<User> allUsers;
	
	public UserBusiness() {
		allUsers = new ArrayList<User>();
	}
	
	///后面看需不需要添加注册的函数
	public  void initialize() {
		User firstUser = new User("123", "123", 4);
		allUsers.add(firstUser);
	}
	
	public  User checkPassword(String userId, String pd) {
		for (User user : allUsers) {
			if (user.toString().equals(userId)) {
				if (user.matchPassword(pd))
					return user;
				else {
					System.out.println("Account Password not match!");
					return null;
				}
			}
		}
		System.out.println("Account not exist!");
		return null;
	}

	/////后面再修改
	public boolean isRegistValid(Integer choice) {
		return true;
	}

	public User registUser(Integer choice, String password) {
		String userId = IDGenerator.generateUserId(choice);
		if (userId != null) {
			User newUser = new User(userId, password, choice);
			allUsers.add(newUser);
			
			return newUser;
		}
		return null;
	}

	public boolean isAdmin(User currentUser) {
		return currentUser.isAdmin();
	}

	public void setUserBasicInfo(User user, String userName, String userAge,
			String userGender) {
		int age = Integer.valueOf(userAge);
		Gender gender = null;
		if (userGender.equals("1"))
			gender = Gender.MALE;
		else {
			gender = Gender.FEMALE;
		}
		user.setBasicInfo(userName, age, gender);
	}

	public void printUserInfo(User newUSer) {
		System.out.println("账号:    " + newUSer.getUserId());
		System.out.println("用户名:  " + newUSer.getUserName());
		System.out.println("年龄:    " + newUSer.getUserAge());
		System.out.println("性别:    " + newUSer.getUserGender());
		
	}
}
