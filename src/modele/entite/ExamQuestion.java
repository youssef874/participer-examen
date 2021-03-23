package modele.entite;

/*
 * This class hold the ExamQuestion table for the database 
 */
public class ExamQuestion {

	//The variable represent the table primaryKey
	private int idExamQuestion;
	//This variable represent a foreign key to examen(exam) Table
	private int idExamn;
	//This variable represent a foreign key to question Table
	private int idQuestion;
	
	public ExamQuestion(int idExamQuestion, int idExamn, int idQuestion) {
		super();
		this.idExamQuestion = idExamQuestion;
		this.idExamn = idExamn;
		this.idQuestion = idQuestion;
	}
	
	public int getIdExamQuestion() {
		return idExamQuestion;
	}
	public int getIdExamn() {
		return idExamn;
	}
	
	public int getIdQuestion() {
		return idQuestion;
	}
	@Override
	public String toString() {
		return "ExamQuestion [idExamQuestion=" + idExamQuestion + ", idExamn=" + idExamn + ", idQuestion=" + idQuestion
				+ "]";
	}
	
	
}
