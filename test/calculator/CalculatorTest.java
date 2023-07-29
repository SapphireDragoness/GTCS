package calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import grades.Grades;

class CalculatorTest {

	@Test
	void testAritmeticMean() {
		Grades.addGrade("Algorithms", 27, 9);
		Grades.addGrade("Object Oriented Programming", 30, 9);
		Grades.addGrade("Mathematical Analysis", 25, 6);
		
		assertEquals(Calculator.arithmeticMean(), 27.33, 0.01);
		
		Grades.addGrade("FLT", 28, 9);
		Grades.addGrade("Functional Programming", 29, 9);
		
		assertEquals(Calculator.arithmeticMean(), 27.8, 0.01);
	}
	
	@Test
	void testWeightedMean() {
		assertEquals(Calculator.weightedMean(), 28.00, 0.01);
		
		Grades.addGrade("Cybersecurity", 30, 6);
		Grades.addGrade("Operating Systems", 18, 12);
		
		assertEquals(Calculator.weightedMean(), 26.20, 0.01);
	}

}
