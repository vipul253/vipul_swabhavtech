package com.techlabs.listener.example;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ContextAttributeListener
 *
 */
@WebListener
public class ContextAttributeListener implements ServletContextAttributeListener {

    /**
     * Default constructor. 
     */
    public ContextAttributeListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("\nAttribute has been added");
        String attributeName = event.getName();
        Object attributeValue = event.getValue();
        System.out.println("Attribute Name ::" + attributeName);
        System.out.println("Attribute Value ::" + attributeValue.toString());
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent event)  { 
    	System.out.println("Attribute has been replaced");
        String attributeName = event.getName();
        Object attributeValue = event.getValue();
        System.out.println("Attribute Name ::" + attributeName);
        System.out.println("Attribute Value ::" + attributeValue.toString());
    }

	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent event)  { 
    	System.out.println("Attribute has been removed");
        String attributeName = event.getName();
        Object attributeValue = event.getValue();
        System.out.println("Attribute Name ::" + attributeName);
        System.out.println("Attribute Value ::" + attributeValue.toString());
    }
	
}
