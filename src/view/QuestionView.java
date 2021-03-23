package view;

import javafx.scene.control.Button;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modele.entite.QCM;
import modele.entite.Question;

/*
 * This Class contain question ui which contain the question the the user answer in it 
 */

public class QuestionView {

	//This variable will hold the current question
	private Question question;
	//This button will display the previous question if exist in the current exam
	private Button precedant ;
	//This button will display the next question if exist in the current exam
	private Button suivant;
	//This button for the student if they complete there exam
	private Button fin;
	//This label contain the question text
	private Label message;
	//This variable will hold the current user id
	private String idEtudiant;
	//This variable will hold the first proposition status (true/false) for the user to declare,if the question is qcm
	private CheckBox proposition1 = new CheckBox();
	//This variable will hold the second proposition status (true/false) for the user to declare,if the question is qcm
	private CheckBox proposition2 = new CheckBox();
	//This variable will hold the third proposition status (true/false) for the user to declare,if the question is qcm
	private CheckBox proposition3 = new CheckBox();
	//This variable will for the user to set the first key word for question ,if the question is qroc
	private TextField motCle1 = new TextField();
	//This variable will for the user to set the second key word for question ,if the question is qroc
	private TextField motCle2 = new TextField();
	//This variable will for the user to set the third key word for question ,if the question is qroc
	private TextField motCle3 = new TextField();
	//This layout will be container of the question 
	private VBox layout = new VBox();
	
	public QuestionView( Button precedant, Button suivant,Button fin, String idEtudiant,BorderPane bp) {
		this.fin = fin;
		this.precedant = precedant;
		this.suivant = suivant;
		this.idEtudiant = idEtudiant;
		bp.setCenter(layout);
		bp.setRight(fin);
	}

	/*
	 * This a helper method ,to setup  a view for the prposition
	 */
	private HBox propositionSetup(String proposition,CheckBox cb) {
		HBox hb = new HBox();
		hb.getChildren().add(cb);
		hb.getChildren().add(new Label(proposition));
		return hb;
	}
	
	/*
	 * Setup the Layout put everything together
	 */
	public VBox layoutSetup(VBox quetionVBox) {
		VBox vb = new VBox();
		vb.getChildren().add(questionSetup());
		vb.getChildren().add(quetionVBox);
		vb.getChildren().add(buttonSetup());
		vb.getChildren().add(message);
		return vb;
	}
	
	/*
	 * This helper method ,afer setting the current question and it is corresponding ui  will be called to attach the ui with
	 * the question container
	 */
	public void layout(VBox vb) {
		layout.getChildren().add(vb);
	}
	
	/*
	 * This a helper method ,to setup  a view for the qcm
	 */
	public VBox qcmSetup() {
		VBox vb = new VBox();
		QCM qcm = (QCM) question;
		vb.getChildren().add(propositionSetup(qcm.getProposition()[0],proposition1));
		vb.getChildren().add(propositionSetup(qcm.getProposition()[1],proposition2));
		vb.getChildren().add(propositionSetup(qcm.getProposition()[2],proposition3));
		return vb;
	}
	
	/*
	 * This a helper method ,to setup  a view for the qroc
	 */
	public VBox qrocSetup() {
		VBox vb = new VBox();
		vb.setMaxWidth(100);
		vb.getChildren().add(motCle1);
		vb.getChildren().add(motCle2);
		vb.getChildren().add(motCle3);
		return vb;
	}
	
	/*
	 * This a helper method ,to setup  a view for the previous and next button
	 */
	private HBox buttonSetup() {
		HBox hb = new HBox();
		hb.getChildren().add(precedant);
		hb.getChildren().add(suivant);
		return hb;
	}
	
	/*
	 * This a helper method ,to setup  a view for the user id,question id and the question text 
	 */
	private VBox questionSetup() {
		VBox vb = new VBox();
		vb.getChildren().add(new Label(idEtudiant));
		vb.getChildren().add(new Label(question.getIdQuation()+""));
		vb.getChildren().add(new Label(question.getEnoonce()));
		return vb;
	}
	
	//Set the current question
	public void setQuestion(Question question) {
		this.question = question;
	}

	
	public void setMessage(String message) {
		this.message = new Label(message) ;
	}

	public CheckBox getProposition1() {
		return proposition1;
	}

	public CheckBox getProposition2() {
		return proposition2;
	}

	public CheckBox getProposition3() {
		return proposition3;
	}

	public TextField getMotCle1() {
		return motCle1;
	}

	public TextField getMotCle2() {
		return motCle2;
	}

	public TextField getMotCle3() {
		return motCle3;
	}
	
	
}
