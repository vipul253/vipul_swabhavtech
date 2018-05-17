package com.techlabs.isp.refactor.test;

import com.techlabs.isp.refactor.*;

public class WorkerTest {

	public static void main(String[] args) {
		Manager manager = new Manager();
		Robot robot = new Robot();

		atTheWorkStation(manager);
		atTheWorkStation(robot);
		atTheCafeteria(manager);
		
	}

	public static void atTheWorkStation(Workable worker) {
		System.out.println("at work station");
		worker.startWork();
		worker.stopWork();
	}

	public static void atTheCafeteria(Eatable eater) {
		System.out.println("at Cafeteria");
		eater.startEating();
		eater.stopEating();
	}
}
