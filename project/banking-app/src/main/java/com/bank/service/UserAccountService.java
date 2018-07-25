package com.bank.service;

import java.util.List;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.entity.Account;
import com.bank.entity.Transaction;
import com.bank.entity.User;
import com.bank.enums.AccountType;
import com.bank.enums.UserRole;
import com.bank.exceptions.InsufficientBalanceException;
import com.bank.repository.BankRepository;

@Service
public class UserAccountService {
	@Autowired
	private BankRepository bankRepository;

	public void addAccount(User user) throws AddressException, MessagingException {
		user.setRole(UserRole.USER);
		user.setActive(false);
		user.setValid(false);
		bankRepository.addAccount(user);
		bankRepository.sendVerificationEmail(user.getName());
	}

	public boolean checkUser(String name, String password) {
		if (bankRepository.checkUser(name, password)) {
			return true;
		}
		return false;
	}

	public UserRole getRole(String name, String password) {
		return bankRepository.getRole(name, password);
	}

	public boolean getAccountState(String name, String password) {
		return bankRepository.getAccountState(name, password);
	}

	public void changeAccountState(String name) {
		bankRepository.changeAccountState(name);
	}

	public void setLoginTime(String name) {
		bankRepository.setLastLoggedIn(name);
	}

	public void increaseAttempts(String name) {
		bankRepository.increaseAttempts(name);
	}

	public int getAttempts(String name) {
		return bankRepository.getAttempts(name);
	}

	public void resetAttempts(String name) {
		bankRepository.resetAttempts(name);
	}

	public boolean checkValid(String name) {
		return bankRepository.checkValid(name);
	}

	public void verify(UUID id) {
		bankRepository.verify(id);
	}

	public List<Transaction> getTransactions(String name, AccountType type) {
		return bankRepository.getTransactions(name, type);
	}

	public List<Transaction> getAllTransactions(String name) {
		return bankRepository.getAllTransactions(name);
	}

	public Account getCurrentAccount(String name) {
		return bankRepository.getCurrentAccount(name);
	}

	public Account getSavingsAccount(String name) {
		return bankRepository.getSavingsAccount(name);
	}

	public void makeCurrentAccount(String name, double amount) {
		bankRepository.makeCurrentAccount(name, amount);
	}

	public void makeSavingsAccount(String name, double amount) {
		bankRepository.makeSavingsAccount(name, amount);
	}

	public void makeTransaction(String name, Transaction txn, AccountType accountType) throws InsufficientBalanceException {
		bankRepository.makeTransaction(name, txn, accountType);
	}
	
	public void doTransfer(String name, double amount, AccountType accountType) throws InsufficientBalanceException {
		bankRepository.doTransfer(name, amount, accountType);
	}
}
