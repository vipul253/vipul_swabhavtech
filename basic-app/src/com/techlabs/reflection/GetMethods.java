package com.techlabs.reflection;
import java.lang.reflect.*;

public class GetMethods {
	public void printMethods(String cname) {
		try {
			Class<?> c = Class.forName(cname);
			Method m[] = c.getDeclaredMethods();
			for (int i = 0; i < m.length; i++)
				System.out.println(m[i].toString());
		}
		catch (Throwable e) {
			System.err.println(e);
		}
	}

}
