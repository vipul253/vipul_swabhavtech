package com.bank.user.actions;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.bank.captcha.VerifyRecaptcha;
import com.bank.entity.User;
import com.bank.service.UserAccountService;
import com.bank.view.model.RegisterView;

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
		svc.addAccount(new User(registerView.getEmail(), registerView.getName(), registerView.getPassword()));
		return "success";
	}

	@Override
	public void validate() {
		String gRecaptchaResponse = ServletActionContext.getRequest()
				.getParameter("g-recaptcha-response");
		
		if (!VerifyRecaptcha.verify(gRecaptchaResponse)) {
			addFieldError("captchaError", "verify captcha");
		}
	}

}
