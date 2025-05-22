package model;

import java.util.ArrayList;

public class Student 
{
	private String firstName;
	private String lastName;
	private String activity;
	private String homework;
	private ArrayList<Integer> grades;
	private ArrayList<String> notes;
	
	public Student(String firstName, String lastName) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.activity = "";
		this.homework = "";
		this.grades = new ArrayList<>();
		this.notes = new ArrayList<>();
	}
	public String getFirstName() 
	{
		return firstName;
	}
	
	public String getLastName() 
	{
		return lastName;
	}
	
	public String getActivity() 
	{
		return activity;
	}
	
	public String getHomework() 
	{
		return homework;
	}
	
	public double averageGrades() 
	{
		if(grades.isEmpty()) return 0;
		int sum = 0;
		for(int g : grades) {
			sum += g;
		}
		return (double) sum/grades.size();
	}
	public void addGrade(int grade) 
	{
		grades.add(grade);
	}
	public void addActivity() 
	{
		activity += "+";
		
	}
	
	public void addHomeWork(String s) 
	{
		StringBuilder sb = new StringBuilder(homework);
		sb.append(s);
		homework = sb.toString();
	}
	
	public void addNote(String note) 
	{
		notes.add(note);
	}
	public int numActivity() 
	{
		return activity.length();
	}
	
	public ArrayList<Integer> getGrades() {
		return grades;
	}
	public ArrayList<String> getNotes() {
		
		return notes;
	}
	public int numPosHomework() 
	{
		int num = 0;
		for(int i = 0; i < homework.length(); i++) 
		{
			if(homework.charAt(i) == '+') 
			{
				num++;
			}
		}
		return num;
	}
	
	public int numNegHomework() 
	{
		int num = 0;
		for(int i = 0; i < homework.length(); i++) 
		{
			if(homework.charAt(i) == '-') 
			{
				num++;
			}
		}
		return num;
	}
	public static Student fromCSV(String line)
	{
		String[] parts = line.split(",");
		
		if(parts.length < 6)
		{
			return null;
		}
		
		String firstName = parts[0];
		String lastName = parts[1];
		
		ArrayList<Integer> grades = new ArrayList<>();
		for(String o:parts[2].split(";"))
		{
			if(!o.isEmpty()) grades.add(Integer.parseInt(o));
		}
		String activity = parts[3];
		String homework = parts[4];
		
		ArrayList<String> notes = new ArrayList<>();
		for(String o: parts[5].split(";"))
		{
			if(!o.isEmpty()) notes.add(o);
		}
		Student s = new Student(firstName,lastName);
		for(int i = 0; i < activity.length(); i++)
		{
			s.addActivity();
		}
		
		s.addHomeWork(homework);
		for(int i = 0; i < grades.size(); i++)
		{
			s.addGrade(grades.get(i));
		}
		for(int i = 0; i < notes.size(); i++)
		{
			s.addNote(notes.get(i));
		}
		
		return s;
	}
	public String toCSV()
	{
		String gradesString=String.join(";", grades.stream().map(String::valueOf).toList());
		String notesString = String.join(";", notes);
		return firstName + "," + lastName + "," + gradesString + "," + activity + "," + homework + "," + notesString;
	}
	public void showInfo() 
	{
		System.out.println("First Name: " + firstName + " Last Name: " + lastName);
		System.out.println("Grades: " + grades);
		System.out.println("Average Grades: " + averageGrades());
		System.out.println("Number of  finished homeworks: " + numPosHomework() + " Number of missing homeworks: " + numNegHomework());
		System.out.println("Activity: " + activity+" Number: " + numActivity());
		System.out.println("Notes: " + notes);
		
	}

	
	
}
