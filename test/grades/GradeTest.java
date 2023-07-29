package grades;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GradeTest {

	@Test
	void testCostructor() {
		Grade grade1 = new Grade("Algorithms", 27, 9);
		Grade grade2 = new Grade("Object Oriented Programming", 30, 9);
		Grade grade3 = new Grade("Mathematical Analysis", 25, 6);
		
		assertEquals(grade1.getSubject(), "Algorithms");
		assertEquals(grade1.getGrade(), 27);
		assertEquals(grade1.getCfu(), 9);
		assertEquals(grade2.getSubject(), "Object Oriented Programming");
		assertEquals(grade2.getGrade(), 30);
		assertEquals(grade2.getCfu(), 9);
		assertEquals(grade3.getSubject(), "Mathematical Analysis");
		assertEquals(grade3.getGrade(), 25);
		assertEquals(grade3.getCfu(), 6);
	}

}
