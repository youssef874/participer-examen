package modele.entite;

import java.sql.Date;


/*
 * This class hold the EtudiantExamen(studentExam) table for the database 
 */
public class EtudiantExamen {

	//The variable represent the table primaryKey
	private int id;
	//This variable represent a foreign key to etudiant Table
	private int idCIN;
	//This variable represent a foreign key to examen Table
	private int idExamen;
	//This variable represent a score column in the data base which refers to exam result
	private int score;
	//This variable represent a date column in the data base which refers to exam date
	private Date date;
	
	public EtudiantExamen(int idCIN, int idExamen, int score, Date date) {
		super();
		this.idCIN = idCIN;
		this.idExamen = idExamen;
		this.score = score;
		this.date = date;
	}

	
	public EtudiantExamen(int id, int idCIN, int idExamen, int score, Date date) {
		super();
		this.id = id;
		this.idCIN = idCIN;
		this.idExamen = idExamen;
		this.score = score;
		this.date = date;
	}


	public int getIdCIN() {
		return idCIN;
	}

	public int getIdExamen() {
		return idExamen;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}

	public Date getDate() {
		return date;
	}

	
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "EtudiantExamen [idCIN=" + idCIN + ", idExamen=" + idExamen + ", score=" + score + ", date=" + date
				+ "]";
	}
	
	
}
