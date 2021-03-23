package view;

import java.io.File;

import java.net.MalformedURLException;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modele.entite.Etudiant;

/*
 * This Class contain user profil ui which contain all the user information available in the database
 */
public class ProfileView {
	
	public ProfileView(BorderPane bp,Etudiant e) {
		bp.setCenter(layoutSetup(e));
	}

	/*
	 * This a helper method ,to setup  a view for most the information 
	 */
	private HBox hboxSetup(String message,String value) {
		HBox hb  =new HBox();
		hb.setPadding(new Insets(20, 10, 20, 10));
		hb.getChildren().add(new Label(message));
		hb.getChildren().add(new Label(value));
		return hb;
	}
	
	/*
	 * Setup the Layout put everything together
	 */
	private VBox layoutSetup(Etudiant e) {
		VBox vb = new VBox();
		vb.setPadding(new Insets(20, 10, 20, 10));
		File f = new File(e.getPhoto());
		Image image;
		try {
			//Get the user image
			image = new Image(f.toURL().toExternalForm());
			//Display the user image
			ImageView iV = new ImageView();
			iV.setImage(image);
			iV.setFitWidth(100);
			iV.setPreserveRatio(true);
			vb.getChildren().add(iV);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		vb.getChildren().add(hboxSetup("CIN : ",e.getIdCIN()+""));
		vb.getChildren().add(hboxSetup("Nom : ",e.getNom()));
		vb.getChildren().add(hboxSetup("Prenom : ",e.getPrenom()));
		return vb;
	}
}
