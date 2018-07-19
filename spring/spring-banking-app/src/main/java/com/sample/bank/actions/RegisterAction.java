package com.sample.bank.actions;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sample.bank.captcha.VerifyRecaptcha;
import com.sample.bank.entity.User;
import com.sample.bank.service.UserAccountService;
import com.sample.bank.view.model.RegisterView;

public class RegisterAction extends ActionSupport implements ModelDriven<RegisterView> {

	private static final long serialVersionUID = 1L;
	@Autowired
	private UserAccountService svc;
	private RegisterView registerView;

	@Override
	public RegisterView getModel() {
		registerView = new RegisterView();
		return registerView;
	}

	public String execute() {
		return "success";
	}
	
	public String register() {
		svc.addAccount(new User(registerView.getName(),registerView.getPassword()), registerView.getAmount());
		return "success";
	}
	
	@Override
	public void validate() {
		String gRecaptchaResponse = ServletActionContext.getRequest().getParameter("g-recaptcha-response");
		if(!VerifyRecaptcha.verify(gRecaptchaResponse)) {
			addFieldError("captchaError", "verify captcha");
		}
		
		if(registerView.getAmount()<999) {
			addFieldError("amountError", "minimum balance allowed is 1000");
		}
	}

}
