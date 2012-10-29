package com.hk.BMSystemView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.hk.BMSystemBusiness.UserBusiness;
import com.hk.tool.Gender;
import com.hk.tool.UserRight;
import com.hk.user.User;

public class BMSystemMain {
	private UserBusiness userBusiness;
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private User currentUser = null;
	
	public BMSystemMain() {
		userBusiness = new UserBusiness();
		print("Welcome to The HK Bank Management System!");
	}
	
	public void mainMenu() {
		print("please input the number;");
		print("1: log in");
		print("2: exit");
		while (true) {
			try {
				Integer choice = 0;
				BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
				choice = Integer.valueOf(bReader.readLine());
				
				switch (choice) {
					case 1: 	userLogIn();	break;
					case 2:	exit();
									break;
					default:	print("valid input");
									break;
				}
			} catch (IOException e) {
				e.printStackTrace();
				print("主目录输入异常");
			}
		}
	}
	
	private void userMainMenu() {
		print("");
		
		if (userBusiness.isAdmin(currentUser)) {
			printAdminMenu();
			
			try {
				Integer choice = Integer.valueOf(reader.readLine());
				processAdminMenuInput(choice);
			} catch (IOException e) {
				e.printStackTrace();
				print("用户主页面输入异常");
			}
			
		}	else {
			printUserMainMenu();
		
			try {
				Integer choice = Integer.valueOf(this.reader.readLine().substring(0, 1));
				switch (choice) {
				case 1:	 
				}
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void processAdminMenuInput(Integer choice) {
		switch (choice) {
			case 1:	registeUserPage();
							break;
			case 2:	modifyUserPage(null);
							break;
			case 3:	removeUserPage();
							break;
			case 4:	userMainMenu();
							break;
			case 5:   exit();
			default:	print("输入有误!");
							userMainMenu();
		}
		
	}

	private void removeUserPage() {
		// TODO Auto-generated method stub
		
	}

	private void modifyUserPage(User user) {
		String userName = null, userAge = null, userGender = null;
		System.out.print("请输入您的姓名: ");
		try {
			userName = reader.readLine();
			System.out.print("请输入您的年龄: ");
			userAge = reader.readLine();
			System.out.print("请输入您的性别: 1.男  2.女   ");
			userGender = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			print("修改用户信息输入异常!");
		}
		
		userBusiness.setUserBasicInfo(user, userName, userAge, userGender);
	}

	private void registeUserPage() {
		String userId, password, passwordComfirm;
		UserRight right;
		
		print("请输入要注册用户级别的代号：	1. 前台操作员   2. 银行经理  3. 业务总管");
		try {
			Integer choice = Integer.valueOf(reader.readLine().substring(0, 1));
			if (choice >= 1 && choice <= 3) {
				if (userBusiness.isRegistValid(choice)) {
					password = setupPassword();
					if (password == null) 
						registeUserPage();
					else {
						User newUSer = userBusiness.registUser(choice, password);
						modifyUserPage(newUSer);
						print("注册用户成功!");
						userBusiness.printUserInfo(newUSer);
					}
				}
			}
			else 
				registeUserPage();
		} catch (NumberFormatException e) {
			e.printStackTrace();
			print("注册页面数字格式异常");
			registeUserPage();
		} catch (IOException e) {
			e.printStackTrace();
			print("注册页面输入异常");
			registeUserPage();
		}
	}

	private String setupPassword() {
		String password, comfirmPassword;
		int times = 0;
		do {
			try {
				print("请输入密码(输入0返回):  ");
				password = reader.readLine();
				if (password.equals("0"))
					return null;
				print("请再次确认密码");
				comfirmPassword = reader.readLine();
				print(password + "  " + comfirmPassword);
			} catch (IOException e) {
				print("密码输入异常");
				password = "0";		comfirmPassword = "1";
			}
			times++;
			
			if (!password.equals(comfirmPassword))
				print("密码确认不匹配，请重新输入:");
			
			if (times >= 3) {
				print("连续三次密码输入错误！");
				return null;
			}
		} while (!password.equals(comfirmPassword));
		
		print("密码设置成功!");
		return password;
	}

	private void printAdminMenu() {
		print("1:  注册用户");
		print("2:  修改用户信息");
		print("3:  删除用户");
		print("4:  返回上一级");
		print("5:  退出");
		print("请输入:  ");
	}

	private void userLogIn() {
		String accountIdString, passwordString;
		
		do {
			print("");
			print("输入0返回上一级目录");
			print("账号: ");
			
			BufferedReader stdInBufferedReader = new BufferedReader(new InputStreamReader(System.in));
			try {
				accountIdString = stdInBufferedReader.readLine();
				if (accountIdString.equals("0"))
					return;
				
				print("密码: ");
				passwordString = stdInBufferedReader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
				print("error: 账号密码输入异常");
				return;
			}
			System.out.println(accountIdString + "  " + passwordString);
			currentUser = userBusiness.checkPassword(accountIdString, passwordString);
		} while (currentUser == null);
		
		userMainMenu();
	}
	
	private void exit() {
		print("Thank you for your using!");
		System.exit(0);
	}
	
	private void printUserMainMenu() {
		print("1.  开户");
		print("2.  存款");
		print("3.  取款");
		print("4.  查询");
		print("5.  转账");
		print("6.  改密码");
		print("7.  销户");
		print("8.  返回上一级");
		print("0.  退出系统");
		print("");
		print("请输入:  ");
	}
	
	private void print(String s) {
		System.out.println(s);
	}
	
	/*
	public static void main(String[] args) {
		BMSystemMain sy = new BMSystemMain();
		sy.mainMenu();
	}
	*/
}
