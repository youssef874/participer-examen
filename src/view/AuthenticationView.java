package view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/*
 * This Class contain authentication ui 
 */
public class AuthenticationView {

	//the input how will hold the user number login is the login column in the etudiant table
	private TextField userTextField = new TextField();
	//the input how will hold the user password login is the motPasse column in the etudiant table
	private TextField motPasseTextField = new TextField();
	//the login button that will compare the input with the etudiant table in the database the connect
	private Button logIn;
	public AuthenticationView(Button logIn,BorderPane bp) {
		this.logIn = logIn;
		bp.setCenter(layoutSetup());
	}
	
	/*
	 * Setup the user login part to help the user to know the place to put their login
	 */
	private HBox userSetUp() {
		HBox hb = new HBox();
		hb.setPadding(new Insets(20, 10, 20, 10));
		hb.getChildren().add(new Label ("login "));
		hb.getChildren().add(userTextField);
		return hb;
	}
	
	/*
	 * Setup the user password part to help the user to know the place to put their password
	 */
	private HBox motPasseSetup() {
		HBox hb = new HBox();
		hb.setPadding(new Insets(20, 10, 20, 10));
		hb.getChildren().add(new Label ("mot de passe "));
		hb.getChildren().add(motPasseTextField);
		return hb;
	}
	
	/*
	 * Setup the Layout put everything together
	 */
	private VBox layoutSetup() {
		VBox vb =new VBox();
		vb.setPadding(new Insets(20, 10, 20, 10));
		vb.getChildren().add(new Label ("bienvenue "));
		vb.getChildren().add(userSetUp());
		vb.getChildren().add(motPasseSetup());
		vb.getChildren().add(logIn);
		return vb;
	}
	
	public TextField getUserTextField() {
		return userTextField;
	}
	
	public TextField getMotPasseTextField() {
		return motPasseTextField;
	}
	
	
}
