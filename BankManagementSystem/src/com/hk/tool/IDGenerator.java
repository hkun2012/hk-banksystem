package com.hk.tool;

public class IDGenerator {
	private static int ClertUserIdCount = 0;
	private static int BankManagerIdCount = 0;
	private static int BankBusinessControllerIdCount = 0;
	
	public static void initialize(int frontCount, int managerCount, int controllerCount) {
		ClertUserIdCount += frontCount;
		BankManagerIdCount += managerCount;
		BankBusinessControllerIdCount += controllerCount;
	}
	
	public static String generateUserId(int choice) {
		if (choice == 1) {
			return String.valueOf(choice * 10000 + ClertUserIdCount++);
		} else if (choice == 2) {
			return String.valueOf(choice * 10000 + BankManagerIdCount++);
		} else {
			return String.valueOf(choice * 10000 + BankBusinessControllerIdCount++);
		}
	}

}
