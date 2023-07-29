package simulator;

import calculator.Calculator;
import grades.Grades;

public class Simulator {
	
	public static int simulator(int wantedMean) throws Exception {
		double actualMean = Calculator.arithmeticMean();
		int grade = (int)actualMean;
		while((actualMean+grade/Grades.grades.size()+1) > wantedMean) {
			grade++;
		}
		if(grade > 31) throw new Exception("There's no single grade that can achieve this mean!");
		return grade;
	}
	
}
