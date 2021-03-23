package modele.entite;

import java.util.Arrays;

public class QCM extends Question {

	private String[] proposition = new String[3];
	private boolean[] propositionCorrect = new boolean[3];
	
	public QCM(int idQuation, int idChaptre, String enoonce
			,String[] proposition,boolean[] propositionCorrect) {
		super(idQuation, idChaptre, enoonce);
		// TODO Auto-generated constructor stub
		this.proposition  = proposition;
		this.propositionCorrect = propositionCorrect;
	}

	public String[] getProposition() {
		return proposition;
	}

	public boolean[] getPropositionCorrect() {
		return propositionCorrect;
	}

	@Override
	public String toString() {
		return "QCM [proposition=" + Arrays.toString(proposition) + ", propositionCorrect="
				+ Arrays.toString(propositionCorrect)+", id ="
						+ super.getIdQuation() + "]";
	}

	@Override
	public boolean valide(Question question) {
		// TODO Auto-generated method stub{
		QCM qcm =  (QCM) question;
		System.out.println("liste des qcm = "+qcm);
		int nb=0;
		for(int i=0;i<3;i++) {
			if(qcm.getPropositionCorrect()[i] == this.propositionCorrect[i]) {
				nb++;
			}
		}
		if(nb == 3) {
			return true;
		}
		return false;
	}

	public void setProposition(String[] proposition) {
		this.proposition = proposition;
	}

	public void setPropositionCorrect(boolean[] propositionCorrect) {
		this.propositionCorrect = propositionCorrect;
	}

	
	
}

