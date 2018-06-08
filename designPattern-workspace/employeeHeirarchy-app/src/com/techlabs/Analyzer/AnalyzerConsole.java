package com.techlabs.Analyzer;

public class AnalyzerConsole {

	public static void main(String[] args) {

		HeirarchyBuilder builder = new HeirarchyBuilder();
		builder.getHead().getDetails(0);
		System.out.println(builder.getMap().size());
		
	}
}
