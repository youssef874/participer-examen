package modele.entite;

/*
 * This class hold the Exam table for the database 
 */
public class Exam {

	//The variable represent the table primaryKey
	private int idExam;
	//The variable represent the  durree column in the table which refers to exam duration
	private float durree;
	//The variable represent the  nbreQuestion column in the table which refers to question number of the exam
	private int nbreQuestion;
	
	public Exam(int idExam, float durree, int nbreQuestion) {
		super();
		this.idExam = idExam;
		this.durree = durree;
		this.nbreQuestion = nbreQuestion;
	}
	
	public Exam(float durree, int nbreQuestion) {
		super();
		this.durree = durree;
		this.nbreQuestion = nbreQuestion;
	}

	public int getIdExam() {
		return idExam;
	}
	public float getDurree() {
		return durree;
	}
	public int getNbreQuestion() {
		return nbreQuestion;
	}
	@Override
	public String toString() {
		return "Exam [idExam=" + idExam + ", durree=" + durree + ", nbreQuestion=" + nbreQuestion + "]";
	}
	
	
}
