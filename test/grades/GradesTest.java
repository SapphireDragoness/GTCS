package grades;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GradesTest {

	@Test
	void testAddGrade() {
		Grades.addGrade("Algorithms", 27, 9);
		Grades.addGrade("Object Oriented Programming", 30, 9);
		Grades.addGrade("Mathematical Analysis", 25, 6);

		assertEquals(Grades.grades.get(0).getSubject(), "Algorithms");
		assertEquals(Grades.grades.get(0).getGrade(), 27);
		assertEquals(Grades.grades.get(0).getCfu(), 9);
		assertEquals(Grades.grades.get(1).getSubject(), "Object Oriented Programming");
		assertEquals(Grades.grades.get(1).getGrade(), 30);
		assertEquals(Grades.grades.get(1).getCfu(), 9);
		assertEquals(Grades.grades.get(2).getSubject(), "Mathematical Analysis");
		assertEquals(Grades.grades.get(2).getGrade(), 25);
		assertEquals(Grades.grades.get(2).getCfu(), 6);
		
		IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> Grades.addGrade("Algorithms", 22, 9));
		assertEquals(e.getMessage(), "There's already a grade for this subject present.");
		IllegalArgumentException e1 = Assertions.assertThrows(IllegalArgumentException.class, () -> Grades.addGrade("FLT", 16, 9));
		assertEquals(e1.getMessage(), "Grade out of range.");
		IllegalArgumentException e2 = Assertions.assertThrows(IllegalArgumentException.class, () -> Grades.addGrade("Functional Programming", 22, 13));
		assertEquals(e2.getMessage(), "Cfu out of range.");
	}

}
