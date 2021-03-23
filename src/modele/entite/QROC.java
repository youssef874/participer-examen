package modele.entite;

import java.util.Arrays;

/*
 * This class hold the QCM table for the database ,and it inherit from question table so idQuestion it is primary key too
 */
public class QROC extends Question {

	//The variable represent the  3 motCle columns in the table which refers to key word for as an answer if the question
	//is qroc type
	private String[]  motCle = new String[3];
	
	public QROC(int idQuation, int idChaptre, String enoonce,String[]  motCle) {
		super(idQuation, idChaptre, enoonce);
		// TODO Auto-generated constructor stub
		this.motCle = motCle;
	}

	public String[] getMotCle() {
		return motCle;
	}

	
	public void setMotCle(String[] motCle) {
		this.motCle = motCle;
	}

	@Override
	public String toString() {
		return "QROC [motCle=" + Arrays.toString(motCle) + "]";
	}

	@Override
	public boolean valide(Question question) {
		// TODO Auto-generated method stub
		QROC qroc = (QROC) question;
		System.out.println("liste des qroc = "+qroc);
		int nb= 0;
		for(int i=0;i<3;i++) {
			if(qroc.getMotCle()[i]==(this.motCle[i])) {
				nb++;
			}
		}
		if(nb == 3) {
			return true;
		}
		return false;
	}

	
}
