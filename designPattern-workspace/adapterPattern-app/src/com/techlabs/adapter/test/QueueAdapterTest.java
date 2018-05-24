package com.techlabs.adapter.test;

import com.techlabs.adapter.*;

public class QueueAdapterTest {

	public static void main(String[] args) {

		SwabhavQueue<Integer> numq = new SwabhavQueue<Integer>();
		numq.enqueue(10);
		numq.enqueue(20);
		numq.enqueue(30);
		// numq.enqueue("abc");

		System.out.println(numq.count());
		System.out.println(numq.dequeue());
		System.out.println(numq.count());

		for (Integer n : numq) {
			System.out.println(n);
		}
	}
}
