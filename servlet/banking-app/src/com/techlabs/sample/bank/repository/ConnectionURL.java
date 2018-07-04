package com.techlabs.sample.bank.repository;

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
					.getResourceAsStream("com/techlabs/sample/bank/repository/app.config.properties");
			prop.load(input);
			url = prop.getProperty("connURL");
		} catch (IOException iox) {
			System.out.println("error in connURL: " + iox);
		}
		return url;
	}
}