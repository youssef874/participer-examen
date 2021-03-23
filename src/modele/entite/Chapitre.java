package modele.entite;

/*
 * This class hold the chapter table for the database ,and it contain idChapitre as primary key and titre of type varchar
 */
public class Chapitre {

	private int idChapitre;
	private String titre;
	
	public Chapitre(int idChapitre, String titre) {
		super();
		this.idChapitre = idChapitre;
		this.titre = titre;
	}

	public int getIdChapitre() {
		return idChapitre;
	}

	public String getTitre() {
		return titre;
	}

	@Override
	public String toString() {
		return "Chapitre [idChapitre=" + idChapitre + ", titre=" + titre + "]";
	}
	
	
}
