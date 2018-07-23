package com.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.entity.User;
import com.bank.enums.UserRole;
import com.bank.repository.BankRepository;

@Service
public class UserAccountService {
	@Autowired
	private BankRepository bankRepository;
	
	public void addAccount(User user) {
		user.setRole(UserRole.USER);
		user.setActive(false);
		user.setValid(false);
		bankRepository.addAccount(user);
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
}
