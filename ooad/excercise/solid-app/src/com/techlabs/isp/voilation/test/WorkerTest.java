package com.techlabs.isp.voilation.test;

import com.techlabs.isp.voilation.*;

public class WorkerTest {

	public static void main(String[] args) {
		IWorker manager = new Manager();
		IWorker robot = new Robot();

		atTheWorkStation(manager);
		atTheWorkStation(robot);
		atTheCafeteria(manager);
		atTheCafeteria(robot); // voilation of LSP, solution is given by ISP
	}

	public static void atTheWorkStation(IWorker worker) {
		System.out.println("at work station");
		worker.startWork();
		worker.stopWork();
	}

	public static void atTheCafeteria(IWorker worker) {
		System.out.println("at Cafeteria");
		worker.startEating();
		worker.stopEating();
	}
}
