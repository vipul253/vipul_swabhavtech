package com.techlabs.DataLoader;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class WEBLoader implements Loader {

	private ArrayList<String> EmpList = new ArrayList<String>();
	private String path;

	public WEBLoader(String path) {
		this.path = path;
	}

	public ArrayList<String> load() {
		try {
			InputStream is = new URL(path).openStream();
			Scanner in = new Scanner(is);
			while (in.hasNextLine()) {
				EmpList.add(in.nextLine());
			}
			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return EmpList;
	}
}