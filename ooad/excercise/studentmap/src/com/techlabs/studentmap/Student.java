package com.techlabs.studentmap;

public class Student implements Comparable<Student> {
	private int rollno;
	private String name;
	private int standard;
	
	public Student(int rollno,int standard,String name){
		this.name=name;
		this.rollno=rollno;
		this.standard=standard;
	}
	
	@Override
	public int compareTo(Student s) {
		return this.name.compareTo(s.name);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rollno;
		result = prime * result + standard;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (rollno != other.rollno)
			return false;
		if (standard != other.standard)
			return false;
		return true;
	}
	
	public int getRollno(){
		return this.rollno;
	}
	
	public int getStandard(){
		return this.standard;
	}
	
	public String getName(){
		return this.name;
	}
	
}
