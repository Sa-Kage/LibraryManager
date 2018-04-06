package libraryManager.GUI;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import libraryManager.Main;
import libraryManager.Model.Book;
import libraryManager.Model.Book.Cover;
import libraryManager.Model.Book.Kind;

/**
 * 
 * @author Alexander Luebbe
 *
 */
public class AddBookController {

	private Main controller;
	
	@FXML
	private Button cancelButton;
	@FXML
	private TextField titleField;
	@FXML
	private TextField authorField;
	@FXML
	private TextField seriesField;
	@FXML
	private TextField seriesNoField;
	@FXML
	private TextField publisherField;
	@FXML
	private ChoiceBox<Kind> kindBox;
	@FXML
	private TextField languageField;
	@FXML
	private ChoiceBox<Cover> coverBox;
	@FXML
	private TextField locationField;
	@FXML
	private TextField lentToField;
	@FXML
	private TextField commentField;
	
	public void setMain(Main main) {
		controller = main;
	}
	
	@FXML
	public void initialize() {
		seriesNoField.disableProperty().bind(Bindings.isEmpty(seriesField.textProperty()));
		
		ObservableList<Cover> coverList = FXCollections.observableArrayList();
		coverList.addAll(Cover.HARDCOVER, Cover.PAPERBACK, Cover.SOFTCOVER);
		coverBox.setItems(coverList);
		coverBox.getSelectionModel().selectFirst();
		
		ObservableList<Kind> kindList = FXCollections.observableArrayList();
		kindList.addAll(Kind.NOVEL, Kind.MANGA);
		kindBox.setItems(kindList);
		kindBox.getSelectionModel().selectFirst();
	}
	
	@FXML
	private void addBook() {
		// TODO: Read out values
		String title = titleField.getText();
		String author = authorField.getText();
		String series = seriesField.getText();
		int seriesNo = Integer.parseInt(seriesNoField.getText());
		String publisher = publisherField.getText();
		Kind kind = kindBox.getValue();
		String language = languageField.getText();
		Cover cover = coverBox.getValue();
		String location = locationField.getText();
		String lentTo = lentToField.getText();
		String comment = commentField.getText();
		controller.addBook(new Book(title, author, series, seriesNo, publisher, kind, language, cover, location, lentTo, comment));
		((Stage) titleField.getScene().getWindow()).close();
	}
	
	@FXML
	private void cancel() {
		((Stage) cancelButton.getScene().getWindow()).close();
	}
}
