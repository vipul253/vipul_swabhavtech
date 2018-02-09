package com.techlabs.annotation;

public class AnnotationTest {

	@NeedRefactoring
	public void test1() {
	}

	public void test2() {
	}

	@NeedRefactoring
	public void test3() {
	}

	public static void main(String[] args) {
		int a;
		GetAnnotation a1 = new GetAnnotation();
		a1.printMethods("com.techlabs.annotation.AnnotationTest");
		a = a1.getMethodCount("com.techlabs.annotation.AnnotationTest");
		System.out.println("Count: " + a);

	}

}
