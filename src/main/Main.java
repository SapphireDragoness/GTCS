package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import calculator.Calculator;
import grades.Grade;
import grades.Grades;
import input.Input;
import simulator.Simulator;

public class Main {

	public static void main(String[] args) {
		while(true) {
			System.out.println("What do you want to do?\n" 
					+ "\n1.Add/modify grades or import from file" 
					+ "\n2.Calculate means" 
					+ "\n3.Simulate grades from mean"
					+ "\n4.Exit program");
			switch (Input.readInt()) {
			case 1:
				gradeOperations();
				break;
			case 2:
				calculator();
				break;
			case 3:
				simulator();
				break;
			case 4:
				System.exit(0);
			default:
				System.out.println("\nInvalid operation.");
			}
		}
	}

	private static void gradeOperations() {
		while(true) {
			System.out.println("What do you want to do?\n" 
					+ "\n1.Add grade" 
					+ "\n2.Modify grade" 
					+ "\n3.Delete grade"
					+ "\n4.Show grades"
					+ "\n5.Import from file"
					+ "\n6.Export to file"
					+ "\n7.Return");
			switch (Input.readInt()) {
			case 1:
				add();
				break;
			case 2:
				modify();
				break;
			case 3:
				delete();
				break;
			case 4:
				Grades.print();
				break;
			case 5:
				importFile();
				break;
			case 6:
				try {
					exportFile();
				} catch (FileNotFoundException e) {
					System.out.println("File not found.");
				}
				break;
			case 7:
				return;
			default:
				System.out.println("\nInvalid operation.");
			}
		}
	}
	
	private static void add() {
		String subject;
		int grade;
		int cfu;
		System.out.println("Subject: ");
		subject = Input.readString();
		System.out.println("Grade: ");
		grade = Input.readInt();
		System.out.println("CFU: ");
		cfu = Input.readInt();
		Grades.addGrade(subject, grade, cfu);
	}
	
	private static void modify() {
		if(!checkGradesPresence()) return;
		System.out.println("Grades present: ");
		Grades.print();
		System.out.println("Select the grade you want to modify: ");
		int choice = Input.readInt();
		checkGradesSize(choice);
		Grade grade = Grades.grades.get(choice);
		System.out.println("Enter new grade: ");
		int n = Input.readInt();
		checkGrade(n);
		grade.setGrade(n);
	}
	
	private static void delete() {
		if(!checkGradesPresence()) return;
		System.out.println("Grades present: ");
		Grades.print();
		System.out.println("Select the grade you want to modify: ");
		int choice = Input.readInt();
		checkGradesSize(choice);
		Grades.grades.remove(choice);
	}
	
	private static void importFile() {
		String fileName = Input.readString("Enter name of file to read from: ");
		String line;
		try (BufferedReader input = new BufferedReader(new FileReader(fileName))) {
			while ((line = input.readLine()) != null) {
				String[] fields = line.split(",");
				if (fields.length > 5)
					throw new IllegalArgumentException("File not properly formatted.");
				Grades.addGrade(fields[0], Integer.parseInt(fields[1]), Integer.parseInt(fields[2]));
			}
			input.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void exportFile() throws FileNotFoundException {
		if(!checkGradesPresence()) return;
		PrintWriter output = new PrintWriter("grades.txt");
		Grades.grades.stream().forEach(a -> {
			output.write(a.toFileString() + "\n");
		});
		output.close();
	}
	
	private static boolean checkGradesPresence() {
		if(Grades.grades.size() == 0) {
			System.out.println("No grades present.");
			return false;
		}
		return true;
	}
	
	private static void checkGradesSize(int index) {
		if(index < 0 || index > Grades.grades.size()) throw new IndexOutOfBoundsException("No grade with that index present.");
	}
	
	private static void checkGrade(int grade) {
		if(grade < 18 || grade > 31) throw new IllegalArgumentException("Grade out of range.");
	}
	
	private static void calculator() {
		if(!checkGradesPresence()) return;
		System.out.println("Arithmetic mean: " + Calculator.arithmeticMean());
		System.out.println("Weighted mean: " + Calculator.weightedMean());
	}

	private static void simulator() {
		if(!checkGradesPresence()) return;
		System.out.println("Enter the mean you want to achieve: ");
		int mean = Input.readInt();
		try {
			System.out.println("Your next grade should be: " + Simulator.simulator(mean));
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
}
