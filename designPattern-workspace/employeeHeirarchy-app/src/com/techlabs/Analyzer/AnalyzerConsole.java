package com.techlabs.Analyzer;

import com.techlabs.Employee.*;

public class AnalyzerConsole {

	public static void main(String[] args) {

		HeirarchyBuilder builder = new HeirarchyBuilder();
		builder.getHead().getDetails();
	
		System.out.println(builder.getMap().size());
	}
}
