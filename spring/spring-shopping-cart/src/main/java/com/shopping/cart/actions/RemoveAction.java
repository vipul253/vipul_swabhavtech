package com.shopping.cart.actions;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shopping.cart.entity.LineItem;
import com.shopping.cart.service.ProductService;
import com.shopping.cart.view.model.DisplayView;

public class RemoveAction extends ActionSupport implements
ModelDriven<DisplayView>, SessionAware {

	private static final long serialVersionUID = 1L;
	@Autowired
	private ProductService svc;
	private DisplayView removeFromCart;
	private Map<String, Object> userSession;

	@Override
	public DisplayView getModel() {
		removeFromCart = new DisplayView();
		return removeFromCart;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		userSession = session;
	}
	
	@Override
	public String execute() {
		Set<LineItem> items = (HashSet<LineItem>)userSession.get("lineItems");
		Iterator<LineItem> iter = items.iterator();
		while (iter.hasNext()){
			if(removeFromCart.getId().equals(iter.next().getProduct().getId().toString())){
				iter.remove();
			}
		}
		userSession.put("lineitems", items);
		return "success";
	}
}
