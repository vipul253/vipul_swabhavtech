package com.sample.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.bank.entity.Transaction;
import com.sample.bank.exceptions.InsufficientBalanceException;
import com.sample.bank.repository.BankRepository;

@Service
public class TransactionService {
	
	@Autowired
	private BankRepository bankRepository;
	
	public void makeTransaction(String name, Transaction txn) throws InsufficientBalanceException {
		bankRepository.makeTransaction(name,txn);
	}
}
