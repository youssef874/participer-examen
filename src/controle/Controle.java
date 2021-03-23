package controle;

import java.sql.Date;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import modele.Model;
import modele.entite.Etudiant;
import modele.entite.EtudiantExamen;
import modele.entite.Exam;
import modele.entite.ExamQuestion;
import modele.entite.QCM;
import modele.entite.QROC;
import modele.entite.Question;
import view.AuthenticationView;
import view.HistoriqueView;
import view.ProfileView;

/*
 * This class contain the user interaction to the application and bond the main with the rest
 */


public class Controle {

	private BorderPane bp;
	private Model model = new Model();
	private AuthenticationView aV;
	//This represent the Authentication status
	private boolean authentificate = false;
	//This represent the current user(authenticated user)
	private Etudiant condidat;
	private ProfileView pV;
	//This will hold all current exam id
	private int idExamen;
	//This will hold all current exam 
	private Exam examen;
	//This will hold all current exam questions number
	private int nbreQuestionTotale;
	//This will hold all current exam questions id
	private  List<Integer> listIDQuestion = new ArrayList<>();
	//This will hold all current exam questions 
	private  List<Question> listQuestion = new ArrayList<>();
	//This will hold all current exam questions answer
	private List<Question> questionReponser = new ArrayList<>();
	private view.QuestionView qV;
	private EtudiantExamen e;

	public Controle(BorderPane bp) {
		this.bp = bp;
		
	}
	
	/*
	 * This method to show the authentication ui
	 */
	public void authentificationShow(Button logIn) {
		aV = new AuthenticationView(logIn,bp);
	}
	
	/*
	 * This method will check the user input in the authentication ui if the match an of the student row if does 
	 * change the authentication status and get the student available information in the database
	 */
	public void authentificate() {
		if(!aV.getMotPasseTextField().getText().isEmpty() && !aV.getUserTextField().getText().isEmpty()) {
			for(int i=0;i<model.getListEtudiant().size();i++) {
				if(model.getListEtudiant().get(i).getLogin().equals(aV.getUserTextField().getText()) &&
						model.getListEtudiant().get(i).getMotPasse().equals(aV.getMotPasseTextField().getText())) {
					authentificate = true;
					condidat = model.getListEtudiant().get(i);
				}
			}
		}
	}

	/*
	 * This method to show the user profile ui
	 */
	public void profileView() {
		pV = new ProfileView(bp,condidat);
	}
	
	
	public boolean isAuthentificate() {
		return authentificate;
	}
	
	/*
	 * This helper method will get all the questions for the current exam
	 */
	public List<Question> setQuestionInformation() {
	     setExamInformation();
	     List<Question> list = new ArrayList<>();
	     listIDQuestion = setIdQuestion();
		for(int h=0;h<nbreQuestionTotale;h++) {
			QCM qcm = model.getQCM(listIDQuestion.get(h));
			QROC qroc = model.getQROC(listIDQuestion.get(h));
			if(qcm != null) {
				list.add(qcm);
			}
			else if(qroc != null) {
				list.add(qroc);
			}
		}
		return list;
		
	}
	
	/*
	 * This helper method will get the current exam from data base with the Model class
	 */
	private void setExamInformation() {
		List<EtudiantExamen> listEtudiantExamen = model.getListEtudiantExamen();
		for(int i=0;i<listEtudiantExamen.size();i++) {
			if(listEtudiantExamen.get(i).getIdCIN() == condidat.getIdCIN()) {
				idExamen = listEtudiantExamen.get(i).getIdExamen();
				examen = model.getExam(idExamen);
				nbreQuestionTotale = examen.getNbreQuestion();
				e = listEtudiantExamen.get(i);
			}
		}
	}
	
	/*
	 * This helper method will get the current exam questions id from data base Through the Model class
	 */
	private List<Integer> setIdQuestion() {
		List<Integer> list = new ArrayList<>();
		for(int j=0;j<model.getListExamQuestion().size();j++) {
			if(model.getListExamQuestion().get(j).getIdExamn() == idExamen) {
				list.add(model.getListExamQuestion().get(j).getIdQuestion());
			}
		}
		return list;
	}
	
	/*
	 * This method to show the current question ui
	 */
	public void QuestionView(int nbrQuestion,Button suivant,Button precedant,Button fin) {
		qV = new view.QuestionView(precedant,suivant,fin,condidat.getIdCIN()+"",bp);
		listQuestion = setQuestionInformation();
		questionReponser = setproposedQuestion();
		qV.setQuestion(listQuestion.get(nbrQuestion));
		qV.setMessage((nbrQuestion+1)+"/"+nbreQuestionTotale);
		VBox vb = null ;
		if(model.getQCM(listQuestion.get(nbrQuestion).getIdQuation()) != null) {
			QCM qcm = (QCM) listQuestion.get(nbrQuestion);
		     vb = qV.qcmSetup();
			boolean [] tab = {qV.getProposition1().isSelected()
					,qV.getProposition2().isSelected(),qV.getProposition3().isSelected()};
			qcm.setPropositionCorrect(tab);
		}
		if(model.getQROC(listQuestion.get(nbrQuestion).getIdQuation()) != null) {
			QROC qroc = (QROC) listQuestion.get(nbrQuestion);
			 vb = qV.qrocSetup();
		} 
		VBox vb1 = qV.layoutSetup(vb);
		qV.layout(vb1);
	}
	
	/*
	 * This helper method to get the user answer
	 */
	public List<Question> setproposedQuestion(){
		List<Question> list = new ArrayList<>();
		questionReponser=listQuestion;
		for(int i=0;i<nbreQuestionTotale;i++) {
			if(model.getQCM(questionReponser.get(i).getIdQuation()) != null) {
				QCM qcm = (QCM) questionReponser.get(i);
				boolean [] tab = {qV.getProposition1().isSelected()
						,qV.getProposition2().isSelected(),qV.getProposition3().isSelected()};
				qcm.setPropositionCorrect(tab);
				list.add(qcm);
			}
			if(model.getQROC(questionReponser.get(i).getIdQuation()) != null) {
				QROC qroc = (QROC) questionReponser.get(i);
				String[] t = {qV.getMotCle1().getText(),qV.getMotCle2().getText(),qV.getMotCle3().getText()};
				list.add(new QROC(qroc.getIdQuation(),qroc.getIdChaptre(),qroc.getEnoonce(),t));
			} 
		}
		return list;
	}
	
	/*
	 * This method to evaluate the the user answer
	 */
	private int score() {
		questionReponser = setproposedQuestion();
		int score = 0;
		System.out.println("Liste Question" + listQuestion);
		for(int i=0;i<questionReponser.size();i++) {
			if(listQuestion.get(i).valide(questionReponser.get(i))) {
				score++;
			}
		}
		return score;
	}
	
	/*
	 * This method will update the exam result to database Through model
	 */
	public void finExamemen() {
		int score = score();
		e.setScore(score);
		model.updateScore(e);
	}
	
	/*
	 * This method to show the exam result historic ui for the current user 
	 */
	public void historicAffiche() {
		 ObservableList<EtudiantExamen> list = model.getObservableListEtudiantExamen();
		 ObservableList<Integer> l=FXCollections.observableArrayList(getScoreList(list));
		 HistoriqueView<Integer> view = new HistoriqueView(bp,l);
		 
	}
	
	/*
	 * This helper method to get Tall the exams scores
	 */
	private  List<Integer> getScoreList(ObservableList<EtudiantExamen> list ){
		 List<Integer> l= new ArrayList<>();
		 for (int i=0;i<list.size();i++) {
			 l.add(list.get(i).getScore());
		 }
		 return l;
	}
	
	/*
	 * This helper method to get Tall the exams dates
	 */
	private List<Date> getDateList(ObservableList<EtudiantExamen> list ){
		List<Date> l = new ArrayList<>();
		 for (int i=0;i<list.size();i++) {
			 l.add(list.get(i).getDate());
		 }
		return l;
	}
	
	/*
	 * This method to show the exam date historic ui for the current user 
	 */
	public void dateAffiche() {
		ObservableList<EtudiantExamen> list = model.getObservableListEtudiantExamen();
		ObservableList<Date> l=FXCollections.observableArrayList(getDateList(list));
		 HistoriqueView<Date> view = new HistoriqueView(bp,l);
	}
}
