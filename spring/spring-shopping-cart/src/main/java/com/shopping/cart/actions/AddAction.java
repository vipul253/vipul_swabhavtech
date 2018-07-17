package com.shopping.cart.actions;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shopping.cart.entity.LineItem;
import com.shopping.cart.entity.Order;
import com.shopping.cart.service.ProductService;
import com.shopping.cart.view.model.DisplayView;

public class AddAction extends ActionSupport implements
		ModelDriven<DisplayView>, SessionAware {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ProductService svc;
	private DisplayView addToCart;
	private Map<String, Object> userSession;

	@Override
	public DisplayView getModel() {
		addToCart = new DisplayView();
		addToCart.setProducts(svc.getProducts());
		return addToCart;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		userSession = session;
	}
	
	@Override
	public String execute() {
		LineItem li = new LineItem(svc.getById(UUID.fromString(addToCart
				.getSelected())), addToCart.getQuantity());
		Set<LineItem> items = (HashSet<LineItem>)userSession.get("lineItems");
		for (LineItem item : items) {
			if (li.getProduct().getId().equals(item.getProduct().getId())) {
				item.setQuantity(li.getQuantity() + item.getQuantity());
				userSession.put("lineitems", items);
				return "success";
			}
		}
		items.add(li);
		userSession.put("lineitems", items);
		return "success";
	}

	public void validate() {
		if (addToCart.getQuantity() < 1) {
			addFieldError("quantity", "order minimum 1");
		}

		if (addToCart.getSelected().equals("-1")
				|| addToCart.getSelected().equals(null)) {
			addFieldError("notSelected", "select a product!!");
		}
	}
}
