package view;

import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

/*
 * This Class contain historic ui which contain all the exam they take and there  result 
 */
public class HistoriqueView<T> {
	
public HistoriqueView(BorderPane bp, ObservableList <T>l){
	bp.setCenter(new ListView(l));
}
}
