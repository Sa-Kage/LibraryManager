package libraryManager.GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import libraryManager.Main;

/**
 * 
 * @author Alexander Luebbe
 *
 */
public class AddBookController {

	private Main controller;
	
	@FXML
	private Button cancelButton;
	
	public void setMain(Main main) {
		controller = main;
	}
	
	@FXML
	private void addBook() {
		// TODO: Read out values
		//controller.addBook(new Book());
	}
	
	@FXML
	private void cancel() {
		((Stage) cancelButton.getScene().getWindow()).close();
	}
}
