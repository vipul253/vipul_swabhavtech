package com.techlabs.DataLoader;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileLoader implements Loader {
	private ArrayList<String> EmpList = new ArrayList<String>();
	private String path;

	public FileLoader(String path) {
		this.path = path;
	}

	public ArrayList<String> load() {
		try {
			Scanner in = new Scanner(new File(path));
			while (in.hasNext()) {
				EmpList.add(in.nextLine());

			}
			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return EmpList;
	}
}
