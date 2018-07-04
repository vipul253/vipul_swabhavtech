package com.techlabs.contact.repository;

import java.util.Properties;
import java.io.*;

public class ConnectionURL {

	private Properties prop = new Properties();
	private InputStream input = null;
	private String url = "";

	public String getURL() {
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			input = classLoader
					.getResourceAsStream("com/techlabs/contact/repository/app.config.properties");
			//com/techlabs/contact/repository
			prop.load(input);
			url = prop.getProperty("connURL");
		} catch (IOException iox) {
			System.out.println("error in connURL: " + iox);
		}
		return url;
	}
}
