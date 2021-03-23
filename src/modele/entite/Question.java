package modele.entite;

/*
 * This class hold the question table for the database 
 */
public abstract class Question {

	//The variable represent the table primaryKey
	private int idQuation;
	//This variable represent a foreign key to chapitre Table
	private int idChaptre;
	//The variable represent the  enoonce column in the table which refers to question text
	private String enoonce;
	
	public Question(int idQuation, int idChaptre, String enoonce) {
		super();
		this.idQuation = idQuation;
		this.idChaptre = idChaptre;
		this.enoonce = enoonce;
	}
	
	public Question(int idChaptre, String enoonce) {
		super();
		this.idChaptre = idChaptre;
		this.enoonce = enoonce;
	}
	
	public int getIdQuation() {
		return idQuation;
	}
	
	public int getIdChaptre() {
		return idChaptre;
	}
	public String getEnoonce() {
		return enoonce;
	}
	
	
	public void setIdQuation(int idQuation) {
		this.idQuation = idQuation;
	}

	public void setIdChaptre(int idChaptre) {
		this.idChaptre = idChaptre;
	}

	public void setEnoonce(String enoonce) {
		this.enoonce = enoonce;
	}

	@Override
	public String toString() {
		return "Question [idQuation=" + idQuation + ", idChaptre=" + idChaptre + ", enoonce=" + enoonce + "]";
	}
	
	public abstract boolean valide (Question question);
}
