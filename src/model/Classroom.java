package model;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map.Entry;




public class Classroom 
{
	public static ArrayList<Student> loadStudents(String path) throws IOException
	{
		ArrayList<Student> list = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(path));
		
		String line;
		while((line=br.readLine())!=null)
		{
			list.add(Student.fromCSV(line));
		}
		br.close();
		return list;
		
	}
	public static void saveStudents(String path,ArrayList<Student> students) throws IOException
	{
		BufferedWriter bw=new BufferedWriter(new FileWriter(path));
		for(Student s:students)
		{
			bw.write(s.toCSV());
			bw.newLine();
		}
		bw.close();
	}
	
	public static void saveClassToTxt(SchoolClass classObj, String filePath) throws IOException {
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
	        writer.write("Class Label: " + classObj.getLabel());
	        writer.newLine();
	        writer.write("Class Teacher: " + classObj.getClassTeacher());
	        writer.newLine();
	        writer.write("Schedule: ");
	        writer.newLine();
	        for (Entry<String, Integer> entry : classObj.getSchedule().entrySet()) {
	            writer.write(" - " + entry.getKey() + ": " + entry.getValue());
	            writer.newLine();
	        }

	        writer.newLine();
	        writer.write("Students:");
	        writer.newLine();
	        for (Student s : classObj.getStudents()) {
	            writer.write(" - " + s.getFirstName() + " " + s.getLastName());
	            writer.newLine();
	            writer.write("   Grades: " + s.getGrades().toString());
	            writer.newLine();
	            writer.write("   Activity: " + s.getActivity());
	            writer.newLine();
	            writer.write("   Homework: " + s.getHomework());
	            writer.newLine();
	            writer.write("   Notes: " + s.getNotes().toString());
	            writer.newLine();
	            writer.newLine();
	        }
	    }
	}


}
