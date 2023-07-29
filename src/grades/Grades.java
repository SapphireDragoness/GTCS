package grades;

import java.util.ArrayList;
import java.util.Iterator;

public class Grades implements Iterable<Grade>{

	public static ArrayList<Grade> grades = new ArrayList<>();
		
	public static void addGrade(String subject, int grade, int cfu) throws IllegalArgumentException {
		checkSubject(subject);
		checkGrade(grade);
		checkCfu(cfu);
		grades.add(new Grade(subject, grade, cfu));
	}
	
	private static void checkSubject(String subject) {
		if(grades.stream().anyMatch(s -> s.getSubject().equals(subject))) {
			throw new IllegalArgumentException("There's already a grade for this subject present.");
		}
	}
	
	private static void checkGrade(int grade) {
		if(grade < 18 || grade > 31) throw new IllegalArgumentException("Grade out of range.");
	}
	
	private static void checkCfu(int cfu) {
		if(cfu < 3 || cfu > 12) throw new IllegalArgumentException("Cfu out of range.");
	}

	@Override
	public Iterator<Grade> iterator() {
		return iterator();
	}
	
	public static void print() {
		grades.stream().forEach(s -> System.out.println(s.toString()));
	}
	
	public class GradesIterator implements Iterator<Grade> {
		
		private int cursor;

		@Override
		public boolean hasNext() {
			return cursor < grades.size();
		}

		@Override
		public Grade next() {
			return grades.get(cursor++);
		}
		
	}
	
}
