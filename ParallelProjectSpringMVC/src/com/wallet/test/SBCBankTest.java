package com.wallet.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.wallet.exception.InvalidAmount;
import com.wallet.exception.InvalidPhoneNumber;
import com.wallet.exception.NameException;
import com.wallet.service.BankServiceImpl;

public class SBCBankTest {
	
	@Test
	public void ValidateNameTrue() throws NameException{
		BankServiceImpl bs = new BankServiceImpl();
		assertEquals(true, bs.validateUserName("Supriya"));
	}
		
	@Test(expected = NameException.class) 
	public void ValidateNameFalse() throws NameException{
		BankServiceImpl bs = new BankServiceImpl();
		assertEquals(false, bs.validateUserName("supriya"));
		assertEquals(false, bs.validateUserName("Supriya@1234"));
		assertEquals(false, bs.validateUserName("2514533"));
		assertEquals(false, bs.validateUserName("Supriya3243"));
	}
	
	@Test
	public void ValidatePhonNumberTrue() throws InvalidPhoneNumber{
		BankServiceImpl bs = new BankServiceImpl();
		assertEquals(true, bs.validatePhoneNumber("7702725233"));
	}
	
	@Test(expected = InvalidPhoneNumber.class)
	public void ValidatePhoneNumber() throws InvalidPhoneNumber{
		BankServiceImpl bs = new BankServiceImpl();
		assertEquals(false, bs.validatePhoneNumber("963258417"));
		assertEquals(false, bs.validatePhoneNumber("5632584170"));
		assertEquals(false, bs.validatePhoneNumber("584170"));
		assertEquals(false, bs.validatePhoneNumber("testing"));
		assertEquals(false, bs.validatePhoneNumber("@#%"));
	}
	
	@Test
	public void ValidateAmountTrue() throws InvalidAmount{
		BankServiceImpl bs = new BankServiceImpl();
		assertEquals(true, bs.validateAmount(10000));
	}
	
	@Test(expected = InvalidAmount.class) 
	public void ValidateAmountFalse() throws InvalidAmount{
		BankServiceImpl bs = new BankServiceImpl();
		assertEquals(false, bs.validateAmount(0));
		assertEquals(false, bs.validateAmount(-400));
	}

}
