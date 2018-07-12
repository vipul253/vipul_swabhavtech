package com.shopping.cart.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shopping.cart.view.model.ShoppingCartView;

public class AddToCartAction extends ActionSupport implements
		ModelDriven<ShoppingCartView> {

	private static final long serialVersionUID = 2L;
	ShoppingCartView addToCart = new ShoppingCartView();

	@Override
	public ShoppingCartView getModel() {
		return addToCart;
	}

	public String addLineItem() {
		addToCart.addLineItem();
		return ActionSupport.SUCCESS;
	}

	public void validate() {
		if (addToCart.getQuantity()<1) {
			addFieldError("quantity", "order minimum 1");
		}
		
		if(addToCart.getSelected().equals("-1") || addToCart.getSelected().equals(null)){
			addFieldError("notSelected", "select a product!!");
		}
	}
}
