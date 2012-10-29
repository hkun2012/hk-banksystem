package com.hk.model;

public class BankBasicOperation {
	Operation mOperationType;
	int mSourceAccount;
	int mDestAccout;
	int sum;
}


enum Operation {
	TRANSFER_IN, TRANSFER_OUT, DEPOSIT, DRAW
}