package com.shopping.cart.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shopping.cart.view.model.ShoppingCartView;

public class DisplayAction extends ActionSupport implements ModelDriven<ShoppingCartView> {

	private static final long serialVersionUID = 1L;
	ShoppingCartView display = new ShoppingCartView(); 
	
	@Override
	public ShoppingCartView getModel() {
		return display;
	}

	public String execute() {
		return ActionSupport.SUCCESS;
	}
	
	public String getTotalCost(){
		return ActionSupport.SUCCESS;
	}
}