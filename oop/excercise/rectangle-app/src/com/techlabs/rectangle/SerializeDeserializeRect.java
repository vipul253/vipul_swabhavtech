package com.techlabs.rectangle;

import java.io.*;

public class SerializeDeserializeRect {

	public void serialize(Object obj) {

		try {

			FileOutputStream file = new FileOutputStream("data/RectObj.ser");
			ObjectOutputStream out = new ObjectOutputStream(file);

			out.writeObject(obj);
			out.close();
			file.close();

			System.out.println("Object serialized!!\n");
		} catch (IOException ex) {
			System.out.println("IOException" + ex);
		}
	}

	public Rectangle deserialize() {
		Rectangle rect = null;
		try {

			FileInputStream file = new FileInputStream("data/RectObj.ser");
			ObjectInputStream in = new ObjectInputStream(file);

			rect = (Rectangle) in.readObject();
			in.close();
			file.close();
		} catch (IOException ex) {
			System.out.println("IOException is caught");
		} catch (ClassNotFoundException ex) {
			System.out.println(ex);
		}
		System.out.println("Object deserialized!!");
		return rect;
	}
}
