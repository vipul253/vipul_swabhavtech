package com.sample.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.bank.entity.Account;
import com.sample.bank.entity.Transaction;
import com.sample.bank.entity.User;
import com.sample.bank.repository.BankRepository;

@Service
public class UserAccountService {
	
	@Autowired
	private BankRepository bankRepository;
	
	public void addAccount(User user, double amount) {
		Account account = new Account();
		account.setBalance(amount);
		user.setStatus("active");
		user.setRole("user");
		user.setAcc(account);
		bankRepository.addAccount(user);
	}
	
	public boolean checkUser(String name, String password){
		if(bankRepository.checkUser(name, password)){
			return true;
		}
		return false;
	}
	
	public String getRole(String name, String password){
		return bankRepository.getRole(name, password);
	}
	
	public String getAccountStatus(String name, String password){
		return bankRepository.getAccountStatus(name, password);
	}
	
	public List<Transaction> getTransactions(String name){
		return bankRepository.getTransactions(name);
		
	}	
	
	public List<User> getUsers(){
		return bankRepository.getUsers();
	}
	
	public void changeAccountState(String name){
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
}
