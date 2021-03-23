package modele;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modele.dao.DAOQROC;
import modele.dao.DAOEtudiant;
import modele.dao.DAOEtudiantExamen;
import modele.dao.DAOExam;
import modele.dao.DAOExamQuestion;
import modele.dao.DAOQCM;
import modele.entite.Etudiant;
import modele.entite.EtudiantExamen;
import modele.entite.Exam;
import modele.entite.ExamQuestion;
import modele.entite.QCM;
import modele.entite.QROC;

/*
 * This Class hold all the data the application need like data base 
 */
public class Model {

	private DAOEtudiant dE;
	private DAOEtudiantExamen deE;
	private DAOExam dEx;
	private DAOExamQuestion dEQ;
	private DAOQCM dQCM;
	private DAOQROC dQROC;
	private List<EtudiantExamen> listEtudiantExamen = new ArrayList<>();
	private List<Etudiant> listEtudiant = new ArrayList<>();
	private List<ExamQuestion> listExamQuestion = new ArrayList<>();
	
	public Model() {
		dE = new DAOEtudiant();
		deE = new DAOEtudiantExamen();
		dEx = new DAOExam();
		dEQ = new DAOExamQuestion();
		dQCM = new DAOQCM();
		dQROC = new DAOQROC();
		listEtudiant = dE.findAll();
		listEtudiantExamen = deE.findAll();
		listExamQuestion = dEQ.findAll();
	}

	public List<Etudiant> getListEtudiant() {
		return listEtudiant;
	}

	public void updateScore(EtudiantExamen e) {
		deE.update(e);
	}
	
	public QCM getQCM(int id) {
		return dQCM.findWithId(id);
	}
	
	public QROC getQROC(int id) {
		return dQROC.findWithId(id);
	}
	
	public Exam getExam(int id) {
		return dEx.findWithId(id);
	}
	
	/*
	 *This method convert EtudiantExamen list from database using DAOEtudiantExamen
	 */
	public List<EtudiantExamen> getListEtudiantExamen() {
		return listEtudiantExamen;
	}

	/*
	 *This method convert ExamQuestion list from database using DAOExamQuestion
	 */
	public List<ExamQuestion> getListExamQuestion() {
		return listExamQuestion;
	}
	
	/*
	 *This method convert EtudiantExamen list in ObservableArray for the ListView
	 */
	public ObservableList<EtudiantExamen> getObservableListEtudiantExamen(){
		return FXCollections.observableArrayList(listEtudiantExamen);
	}
}
