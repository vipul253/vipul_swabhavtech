package com.techlabs.reflection;

import java.lang.reflect.Constructor;

public class GetConstructor {
	public void printConstructor(String cname) {
		try {
			Class<?> c = Class.forName(cname);
			Constructor<?> clist[] = c.getDeclaredConstructors();
			for (int i = 0; i < clist.length; i++)
				System.out.println(clist[i].toString());
		}
		catch (Throwable e) {
			System.err.println(e);
		}
	}
}
