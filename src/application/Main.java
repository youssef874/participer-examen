package application;

import controle.Controle;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

public class Main extends Application {

	private BorderPane root = new BorderPane();
	private Button login = new Button("connect");
	private Button precedant = new Button("previous");
	private Button Suivant = new Button("next");
	private Button fin = new Button("end");
	private Controle controle = new Controle(root);
	private int numeroQuetion = 0;

	@Override
	public void start(Stage primaryStage) {
		try {

			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			controle.authentificationShow(login);
			connecter();
			if (numeroQuetion > 0) {
				precedant.setVisible(true);
			}
			suivant();
			precedant();
			fin();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void menu() {
		root.setCenter(null);
		MenuBar menuBar = new MenuBar();
		root.setTop(menuBar);
		Menu profilMenu = new Menu("profil");
		Menu examenMenu = new Menu("Exam");
		menuBar.getMenus().addAll(profilMenu, examenMenu);
		MenuItem passerExamenMenuItem = new MenuItem("Take An Exam");
		Menu historiqueMenuItem = new Menu("hitoric");
		MenuItem dateMenuItem = new MenuItem("date");
		MenuItem scoreMenuItem = new MenuItem("score");
		historiqueMenuItem.getItems().addAll(dateMenuItem,scoreMenuItem);
		examenMenu.getItems().addAll(passerExamenMenuItem, historiqueMenuItem);
		MenuItem historiqueAfficheMenuItem = new MenuItem("Show");
		profilMenu.getItems().add(historiqueAfficheMenuItem);
		scoreMenuItem.setOnAction(e->controle.historicAffiche());
		historiqueAfficheMenuItem.setOnAction(e -> controle.profileView());
		passerExamenMenuItem.setOnAction(e -> {
			if (numeroQuetion == 0) {
				precedant.setVisible(false);
				controle.QuestionView(numeroQuetion, Suivant, precedant,fin);
				suivant();
			}
			if(numeroQuetion ==2) {
				Suivant.setVisible(false);
			}
		});
		dateMenuItem.setOnAction(e ->controle.dateAffiche());
	}

	public void connecter() {
		login.setOnAction(e -> {
			controle.authentificate();
			if (controle.isAuthentificate()) {
				menu();
			}
			if(numeroQuetion ==2) {
				Suivant.setVisible(false);
			}
		});
	}

	private void suivant() {
		Suivant.setOnAction(e -> {
			numeroQuetion++;
			controle.QuestionView(numeroQuetion,Suivant,precedant,fin);
			precedant.setVisible(true);
			if(numeroQuetion ==0) {
				precedant.setVisible(false);
			}
			if(numeroQuetion ==2) {
				Suivant.setVisible(false);
			}
		});
	}

	private void precedant() {
		precedant.setOnAction(e -> {
			numeroQuetion--;
			controle.QuestionView(numeroQuetion,Suivant,precedant,fin);
			if(numeroQuetion ==0) {
				precedant.setVisible(false);
			}
		});
	}
	
	private void fin() {
		fin.setOnAction(e ->controle.finExamemen());
	}
}