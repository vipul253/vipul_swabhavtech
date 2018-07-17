package com.shopping.cart.interceptors;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor {

	private static final long serialVersionUID = 4L;

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> session = invocation.getInvocationContext().getSession();
		if(session.isEmpty() || session.get("name")==null){
			return "login";
		}
		return invocation.invoke();
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
