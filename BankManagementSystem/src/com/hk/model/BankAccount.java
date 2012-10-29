package com.hk.model;

import java.util.ArrayList;

public abstract class BankAccount {
	int mAccountNumber;
	String mPasswordString;
	String mMasterIdentityNumber;
	double mBalance;
	
	ArrayList<BankBasicOperation> mOperations;
	
	public BankAccount() {
		// TODO Auto-generated constructor stub
	}
}
