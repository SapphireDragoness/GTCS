package calculator;

import grades.Grades;

public class Calculator {
	
	public static double arithmeticMean() {
		return (double)Grades.grades.stream().mapToInt(g -> g.getGrade()).sum() / Grades.grades.size(); 
	}
	
	public static double weightedMean() {
		return (double)Grades.grades.stream().mapToInt(g -> g.getGrade()*g.getCfu()).sum() / Grades.grades.stream().mapToInt(g -> g.getCfu()).sum(); 
	}
	
}
