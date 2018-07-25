package com.bank.user.actions;

import javax.mail.MessagingException;

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
		try {
			svc.addAccount(new User(registerView.getEmail(), registerView.getName(), 
					registerView.getPassword()));
		} catch (MessagingException e) {
			addFieldError("captchaError", "couldn't send email, check email");
			return "input";
		}
		return "success";
	}

	@Override
	public void validate() {
		System.out.println("1");
		String gRecaptchaResponse = ServletActionContext.getRequest()
				.getParameter("g-recaptcha-response");

		if (!VerifyRecaptcha.verify(gRecaptchaResponse)) {
			addFieldError("captchaError", "verify captcha");
		}
	}
}
