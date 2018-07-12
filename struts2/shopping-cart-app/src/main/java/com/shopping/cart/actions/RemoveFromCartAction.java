package com.shopping.cart.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shopping.cart.view.model.ShoppingCartView;

public class RemoveFromCartAction extends ActionSupport implements ModelDriven<ShoppingCartView> {
	
	private static final long serialVersionUID = 3L;
	ShoppingCartView removeFromCart = new ShoppingCartView();
	
	@Override
	public ShoppingCartView getModel() {
		return removeFromCart;
	}
	
	public String removeLineItem(){
		removeFromCart.removeLineItem();
		return ActionSupport.SUCCESS;
	}

}
