package modele.entite;

/*
 * This class hold the etudiant(student) table for the database ,and it contain idCIN as primary key and nom(name)
 * , prenom(lastName),login,motPasse(password)and photo as colums
 */
public class Etudiant {

	private int idCIN;
	private String nom;
	private String prenom;
	private String login;
	private String motPasse;
	private String photo;
	public Etudiant(int idCIN, String nom, String prenom, String login, String motPasse, String photo) {
		super();
		this.idCIN = idCIN;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.motPasse = motPasse;
		this.photo = photo;
	}
	public int getIdCIN() {
		return idCIN;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getLogin() {
		return login;
	}
	public String getMotPasse() {
		return motPasse;
	}
	public String getPhoto() {
		return photo;
	}
	@Override
	public String toString() {
		return "Etudiant [idCIN=" + idCIN + ", nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", motPasse="
				+ motPasse + ", photo=" + photo + "]";
	}
	
	
	
}
