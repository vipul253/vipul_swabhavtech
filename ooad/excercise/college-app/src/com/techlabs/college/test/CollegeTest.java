package com.techlabs.college.test;

import com.techlabs.collegepeople.*;

public class CollegeTest {
	
	public static void main(String args[]){
		College college = new College();
		
		college.addStudent(new Student(1,"1/101,mumbai","1/1/96",Branch.IT));
		college.addStudent(new Student(2,"2/102,mumbai","1/1/96",Branch.CIVIL));
		college.addStudent(new Student(3,"3/103,mumbai","1/1/96",Branch.MECH));
		college.addStudent(new Student(4,"4/104,mumbai","1/1/96",Branch.EXTC));
		college.addStudent(new Student(5,"911,wall_street,mumbai","1/1/96",Branch.CS));
		
		college.addProfessor(new Professor(6, "1,25,mumbai-suburb","1/3/87",43321.90));
		college.addProfessor(new Professor(7, "6,25,mumbai","1/3/87",42212.90));
		college.addProfessor(new Professor(8, "3,25,mumbai-suburb","1/3/87",43231.90));
		college.addProfessor(new Professor(9, "7,23,mumbai-suburb","1/3/88",12334.23));
		
		System.out.println("----------Professors-----------");
		for(Professor p : college.getProfessors()){
			System.out.println(p.toString());
		}
		
		System.out.println("----------Students-----------");
		for(Student s : college.getStudents()){
			System.out.println(s.toString());
		}
	}
}
