package grades;

public class Grade {
	
	private final String subject;
	private int grade;
	private int cfu;
	
	public Grade(String subject, int grade, int cfu) {
		this.subject = subject;
		this.grade = grade;
		this.cfu = cfu;
	}

	public String getSubject() {
		return subject;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public int getCfu() {
		return cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;
	}
	
	@Override
	public String toString() {
		return subject + ": " + grade;
	}
	
	public String toFileString() {
		return subject + "," + grade + "," + cfu;
	}
	
}
