package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void studentMenu(Scanner scanner, SchoolClass class1) {
        while (true) {
            System.out.println("\nChoose option: ");
            System.out.println("1) Add activity");
            System.out.println("2) Add grade");
            System.out.println("3) Add homework");
            System.out.println("4) Add note");
            System.out.println("5) Add new student");
            System.out.println("6) Show average grade");
            System.out.println("7) Show all students");
            System.out.println("0) Exit");

            int option = Integer.parseInt(scanner.nextLine());

            if (option == 0) break;

            String fname = "", lname = "";
            if (option >= 1 && option <= 6) {
                System.out.print("Enter first name: ");
                fname = scanner.nextLine();
                System.out.print("Enter last name: ");
                lname = scanner.nextLine();
            }

            Student s = class1.searchStudent(fname, lname);
            
            switch (option) {
                case 1:
                    if (s != null) s.addActivity();
                    else System.out.println("Student not found.");
                    break;
                case 2:
                    if (s != null) {
                        System.out.print("Enter grade: (1-5) ");
                        int grade = Integer.parseInt(scanner.nextLine());
                        s.addGrade(grade);
                    } else System.out.println("Student not found.");
                    break;
                case 3:
                    if (s != null) {
                        System.out.print("Enter '+' or '-' for homework: ");
                        String hw = scanner.nextLine();
                        s.addHomeWork(hw);
                    } else System.out.println("Student not found.");
                    break;
                case 4:
                    if (s != null) {
                        System.out.print("Enter note: ");
                        String note = scanner.nextLine();
                        s.addNote(note);
                    } else System.out.println("Student not found.");
                    break;
                case 5:
                    System.out.print("Enter first name: ");
                    fname = scanner.nextLine();
                    System.out.print("Enter last name: ");
                    lname = scanner.nextLine();
                    class1.addStudent(new Student(fname, lname));
                    System.out.println("Student added.");
                    break;
                case 6:
                    if (s != null) {
                        System.out.println("Average: " + s.averageGrades());
                    } else System.out.println("Student not found.");
                    break;
                case 7:
                    for (Student student : class1.getStudents()) {
                        student.showInfo();
                    }
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }


	public static void main(String[] args) throws IOException {
		    System.out.println("Welcome to Application");
		
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the name of the CSV file:");
			String path = scanner.nextLine();
			System.out.println("Enter the label of class:");
			String label = scanner.nextLine();
			System.out.println("Enter the name of class teacher:");
			String nameTeacher = scanner.nextLine();
			

			ArrayList<Student> students = Classroom.loadStudents(path);
			
			SchoolClass class1 = new SchoolClass(label, nameTeacher);

			for(Student s : students)
			{
				class1.addStudent(s);
			}
			
			System.out.println("Number of classes in the week:");
			int num = scanner.nextInt();
			scanner.nextLine();
			
			for(int i = 0; i < num; i++)
			{
				System.out.println("Write day of class:" );
				String day = scanner.nextLine();
				System.out.println("Write number of class:");
				int n = scanner.nextInt();
				scanner.nextLine();
				class1.addClassInDay(day, n);
			}
			
			studentMenu(scanner, class1);
			
			
			students = class1.getStudents();
			
			Classroom.saveClassToTxt(class1, "class.txt");
			System.out.println("Class saved to class.txt");
			
			Classroom.saveStudents(path, students);
			System.out.println("New information has been added to " + path);
			scanner.close();
	}
}


