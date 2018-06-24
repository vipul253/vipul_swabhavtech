package com.techlabs.html.dom.test;

import com.techlabs.html.dom.*;

public class HtmlDomTest {
	
	public static void main(String[] args){
		ControlGroup html = new ControlGroup("html");
		ControlGroup head = new ControlGroup("head");
		ControlGroup body = new ControlGroup("body");
		html.add(head);
		html.add(body);
		head.add(new Control("title"));
		ControlGroup division = new ControlGroup("div");
		body.add(division);
		html.draw(1);
	}
}
