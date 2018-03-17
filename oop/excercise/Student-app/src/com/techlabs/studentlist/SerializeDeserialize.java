package com.techlabs.studentlist;

import java.io.*;
import java.util.*;

public class SerializeDeserialize {
	public void serialize(Object obj) {

		try {

			FileOutputStream file = new FileOutputStream("data/list.ser");
			ObjectOutputStream out = new ObjectOutputStream(file);

			out.writeObject(obj);
			out.close();
			file.close();
		} catch (IOException ex) {
			System.out.println("IOException" + ex);
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Student> deserialize() {
		ArrayList<Student> obj = null;
		try {

			FileInputStream file = new FileInputStream("data/list.ser");
			ObjectInputStream in = new ObjectInputStream(file);

			obj = (ArrayList<Student>) in.readObject();
			in.close();
			file.close();
		} catch (IOException ex) {
			System.out.println("IOException is caught");
		} catch (ClassNotFoundException ex) {
			System.out.println(ex);
		}
		return obj;
	}
}
