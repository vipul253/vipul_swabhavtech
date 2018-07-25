package com.bank.user.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.bank.entity.Transaction;
import com.bank.exceptions.InsufficientBalanceException;
import com.bank.service.UserAccountService;
import com.bank.view.model.TransactionView;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TransactionAction extends ActionSupport implements ModelDriven<TransactionView>, SessionAware {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UserAccountService svc;
	private Map<String, Object> userSession;
	private TransactionView transactionView;
	
	@Override
	public void setSession(Map<String, Object> session) {
		userSession = session;
	}

	@Override
	public TransactionView getModel() {
		transactionView = new TransactionView();
		return transactionView;
	}
	
	public String execute() {
		return "success";
	}
	
	public String transact(){
		Transaction transaction = new Transaction(transactionView.getAmount(),transactionView.getTransactionType());
		try {
			svc.makeTransaction(userSession.get("name").toString(), transaction, transactionView.getAccountType());
		} catch (InsufficientBalanceException e) {
			addFieldError("balanceError", "insufficeint balance, cannot withdraw");
			return "input";
		}
		return "success";
	}
	
	public String transfer(){
		try {
			svc.doTransfer(userSession.get("name").toString(), transactionView.getAmount(), transactionView.getAccountType());
		} catch (InsufficientBalanceException e) {
			addFieldError("balanceError", "insufficeint balance, cannot transfer");
			return "input";
		}
		return "success";
	}
}
