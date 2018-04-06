package libraryManager.GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import libraryManager.Main;

/**
 * 
 * @author Alexander Luebbe
 *
 */
public class MainGUIController {

	private Main controller;
	
	@FXML
	private TableView bookTable;
	
	@FXML
	private void showAddBookDialog() {
		controller.showAddBookDialog();
	}
	
	public void initialize(Main main) {
		controller = main;
		bookTable.setPlaceholder(new Label(""));
	}
}
