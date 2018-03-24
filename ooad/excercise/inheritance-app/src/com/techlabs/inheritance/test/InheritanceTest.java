package com.techlabs.inheritance.test;

import com.techlabs.inheritance.*;

public class InheritanceTest {

	public static void case1() {
		Man man;
		man = new Man();
		man.play();
		man.eat();
		man.read();
	}

	public static void case2() {
		Boy boy;
		boy = new Boy();
		boy.eat();
		boy.read();
		boy.run();
		boy.play();
	}

	public static void case3() {
		Man man;
		man = new Boy();
		man.eat();
		man.read();
		man.play();
	}

	public static void atTheGround(Man man) {
		System.out.print("at the ground ");
		man.play();
	}

	public static void case4() {
		atTheGround(new Man());
		atTheGround(new Boy());
		atTheGround(new Kid());
		atTheGround(new Infant());
	}

	public static void main(String[] args) {

		Boy boy1 = new Boy();
		boy1.eat();
		boy1.play();
		boy1.read();
		boy1.run();
		System.out.println("------case1-----");
		case1();
		System.out.println("------case2-----");
		case2();
		System.out.println("------case3-----");
		case3();
		System.out.println("------case4-----");
		case4();

	}
}
