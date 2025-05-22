package model;

import java.util.ArrayList;
import java.util.HashMap;

public class SchoolClass 
{
	private String label;
	private String classTeacher;
	private ArrayList<Student> students;
	private HashMap<String,Integer> schedule;// <day in Week, number of class
	
	public SchoolClass(String label, String classTeacher) 
	{
		this.label = label;
		this.classTeacher = classTeacher;
		this.students = new ArrayList<>();
		this.schedule = new HashMap<>();
		
	}
	public ArrayList<Student> getStudents()
	{
		return students;
	}
	
	public HashMap<String,Integer> getSchedule()
	{
		return schedule;
	}
	
	public void addStudent(Student s) 
	{
		students.add(s);
	}
	public String getLabel() {
		
		return label;
	}
	public String getClassTeacher() {
	
		return classTeacher;
	}
	
	public void addClassInDay(String day, int number) {
		schedule.put(day, number);
	}
	public Student searchStudent(String firstName, String lastName)
	{
		for(Student s : students)
		{
			if(s.getFirstName().equals(firstName) && s.getLastName().equals(lastName))
			{
				return s;
			}
			
		}
		return null;
	}
	public void showClass() 
	{
		System.out.println("Class: " + label);
		System.out.println("Class Teacher: " + classTeacher);
		System.out.println("Students:");
		for(Student s : students) 
		{
			System.out.println(s.getFirstName() + " " + s.getLastName());
		}
		System.out.println("Schedule:");
		for(String day: schedule.keySet())
		{
			System.out.println("Day in week: " + day + " - Number: " + schedule.get(day));
		}
		
	}

	
}