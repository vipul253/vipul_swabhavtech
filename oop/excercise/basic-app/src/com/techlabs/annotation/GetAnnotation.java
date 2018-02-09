package com.techlabs.annotation;

import java.lang.reflect.*;

public class GetAnnotation {

	public void printMethods(String cname) {
		try {
			Class<?> c = Class.forName(cname);
			for (Method m : c.getMethods()) {
				if (m.isAnnotationPresent(NeedRefactoring.class)) {
					System.out.println(m.getName());
				}
			}
		} catch (Throwable e) {
			System.err.println(e);
		}
	}

	public int getMethodCount(String cname) {
		int c = 0;
		try {
			Class<?> cl = Class.forName(cname);
			for (Method m : cl.getMethods()) {
				if (m.isAnnotationPresent(NeedRefactoring.class)) {
					c++;
				}
			}
		} catch (Throwable e) {
			System.err.println(e);
		}
		return c;
	}

}
