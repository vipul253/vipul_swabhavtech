package com.shopping.cart.actions;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.shopping.cart.entity.LineItem;
import com.shopping.cart.entity.Order;
import com.shopping.cart.service.CustomerService;
import com.shopping.cart.view.model.CheckoutView;

public class CheckoutAction implements ModelDriven<CheckoutView>, SessionAware {

	@Autowired
	private CustomerService svc;
	private CheckoutView checkout;
	private Map<String, Object> userSession;

	@Override
	public CheckoutView getModel() {
		checkout = new CheckoutView();
		return checkout;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		userSession = session;
	}

	public String execute() {
		double finalCost = 0;
		Set<LineItem> items = (HashSet<LineItem>) userSession.get("lineItems");
		for(LineItem li : items){
			finalCost += li.CalculateTotalCost();
		}
		checkout.setCheckoutCost(finalCost);
		return "success";
	}

	public String checkout() {
		System.out.println(checkout.getCheckoutCost());
		String name = userSession.get("name").toString();
		Set<LineItem> items = (HashSet<LineItem>) userSession.get("lineItems");
		Order order = new Order();
		for(LineItem li: items){
			li.setOrder(order);
		}
		order.setOrder(items);
		order.setCost(checkout.getCheckoutCost());
		svc.checkout(name, order);
		items.clear();
		userSession.put("lineitems", items);
		return "success";
	}

}
