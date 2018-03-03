package com.techlabs.student;

import java.io.*;
import java.util.*;

public class SerializeDeserialize {
	public void serialize(Object obj) {

		try {

			FileOutputStream file = new FileOutputStream("data/StudentList.ser");
			ObjectOutputStream out = new ObjectOutputStream(file);

			out.writeObject(obj);
			out.close();
			file.close();

			System.out.println("serialized!!\n");
		} catch (IOException ex) {
			System.out.println("IOException" + ex);
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Student> deserialize() {
		ArrayList<Student> obj = null;
		try {

			FileInputStream file = new FileInputStream("data/StudentList.ser");
			ObjectInputStream in = new ObjectInputStream(file);

			obj = (ArrayList<Student>) in.readObject();
			in.close();
			file.close();
		} catch (IOException ex) {
			System.out.println("IOException is caught");
		} catch (ClassNotFoundException ex) {
			System.out.println(ex);
		}
		System.out.println("Deserialized!!");
		return obj;
	}
}
