package com.hk.BMSystemBusiness;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.lang.model.element.NestingKind;

import com.hk.tool.Gender;
import com.hk.tool.IDGenerator;
import com.hk.tool.UserRight;
import com.hk.user.User;

public class UserBusiness {
private  ArrayList<User> allUsers;
	
	public UserBusiness() {
		//allUsers = new ArrayList<User>();
	}
	
	///后面看需不需要添加注册的函数
	@SuppressWarnings("unchecked")
	public  void initialize() throws IOException, ClassNotFoundException {
		FileInputStream fis;
		try {
			fis = new FileInputStream("db.xml");
			ObjectInputStream ois = new ObjectInputStream(fis);
			allUsers = (ArrayList<User>) ois.readObject();
			
			int frontCount = 0, managerCount = 0, controllerCount = 0;
			for (int i = 0; i < allUsers.size(); i++) {
				if (allUsers.get(i).getUserRight() == UserRight.FRONT) {
					frontCount++;		continue;
				}
				if (allUsers.get(i).getUserRight() == UserRight.MANAGER) {
					managerCount++;		continue;
				}
				if (allUsers.get(i).getUserRight() == UserRight.CONTROLLER) {
					controllerCount++;		continue;
				}
			}
			System.out.println("" + allUsers.size() + " " + frontCount);
			User user = allUsers.get(1);
			System.out.println(user.toString());
			IDGenerator.initialize(frontCount, managerCount, controllerCount);
		} catch (FileNotFoundException e) {
			System.out.println("file not found!");
			allUsers = new ArrayList<User>();
			User admin = new User("123", "123", 4);
			allUsers.add(admin);
		}
		
		
	}
	
	public void userInfoSerialize() {
		try {
			FileOutputStream fos = new FileOutputStream("db.xml");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(allUsers);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public  User checkPassword(String userId, String pd) {
		for (User user : allUsers) {
			if (user.getUserId().equals(userId)) {
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

	public void modifyUserInfo(User newUser, String userName, String age,
			int choice, int gender) {
		newUser.modifyInfo(userName, age, choice, gender);
		
	}
}
