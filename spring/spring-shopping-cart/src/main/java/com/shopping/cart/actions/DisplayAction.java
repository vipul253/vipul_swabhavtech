package com.shopping.cart.actions;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.shopping.cart.service.ProductService;
import com.shopping.cart.view.model.DisplayView;

public class DisplayAction implements ModelDriven<DisplayView> {

	@Autowired
	private ProductService svc;
	private DisplayView display = new DisplayView();

	@Override
	public DisplayView getModel() {
		return display;
	}

	public String execute() {
		display.setProducts(svc.getProducts());
		return "success";
	}

	public String getTotalCost() {
		if (display.getQuantity() < 12) {
			display.setTotalCost(svc.getById(
					UUID.fromString(display.getSelected())).getCost()
					* display.getQuantity());
		}
		return "success";
	}

}
