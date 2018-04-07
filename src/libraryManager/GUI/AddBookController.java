package libraryManager.GUI;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.PseudoClass;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import libraryManager.Main;
import libraryManager.model.Book;
import libraryManager.model.Book.Cover;
import libraryManager.model.Book.Kind;

/**
 * 
 * @author Alexander Luebbe
 *
 */
public class AddBookController {

	private Main controller;
	private PseudoClass error = PseudoClass.getPseudoClass("error");
	private boolean edit = false;
	
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
	
	public void setAdd(Main main) {
		controller = main;
		
		coverBox.getSelectionModel().selectFirst();
		kindBox.getSelectionModel().selectFirst();
	}
	
	public void setEdit(Book book) {
		edit = true;
		titleField.setDisable(true);
		authorField.setDisable(true);
		seriesField.setDisable(true);
		kindBox.setDisable(true);
		publisherField.setDisable(true);
		languageField.setDisable(true);
		coverBox.setDisable(true);
		
		// TODO: Set data to the fields
		titleField.setText(book.getTitle());
		authorField.setText(book.getAuthor());
		seriesField.setText(book.getSeries());
		seriesNoField.setText(book.getSeriesNumber());
		publisherField.setText(book.getPublisher());
		kindBox.getSelectionModel().select(book.getKind());
		languageField.setText(book.getLanguage());
		coverBox.getSelectionModel().select(book.getCover());
		locationField.setText(book.getLocation());
		lentToField.setText(book.getLent());
		commentField.setText(book.getComment());
	}
	
	@FXML
	public void initialize() {
		seriesNoField.disableProperty().bind(Bindings.isEmpty(seriesField.textProperty()));
		
		ObservableList<Cover> coverList = FXCollections.observableArrayList();
		coverList.addAll(Cover.HARDCOVER, Cover.PAPERBACK, Cover.SOFTCOVER);
		coverBox.setItems(coverList);
		
		ObservableList<Kind> kindList = FXCollections.observableArrayList();
		kindList.addAll(Kind.NOVEL, Kind.MANGA);
		kindBox.setItems(kindList);
	}
	
	@FXML
	private void handleOkButtonClicked() {
		if(edit) {
			editBook();
		} else {
			addBook();
		}
	}
	
	private void editBook() {
		
	}
	
	private void addBook() {
		// Check for correct input values
		// TODO: Color fields with wrong input
		byte correctValues = 5;
		if(titleField.getText().isEmpty()) {
			titleField.pseudoClassStateChanged(error, true);
		} else {
			correctValues++;
			titleField.pseudoClassStateChanged(error, false);
		}
		if(authorField.getText().isEmpty()) {
			authorField.pseudoClassStateChanged(error, true);
		}
		 else {
				correctValues++;
				authorField.pseudoClassStateChanged(error, false);
			}
		if(!seriesField.getText().isEmpty()) {
			if(seriesNoField.getText().isEmpty()) {
				seriesNoField.pseudoClassStateChanged(error, true);
			} else if(!seriesNoField.getText().matches("-?[123456789]{1}\\d*|0")) {
				seriesNoField.pseudoClassStateChanged(error, true);
			} else {
				correctValues++;
				seriesNoField.pseudoClassStateChanged(error, false);
			}
		} else {
			correctValues++;
		}
		if(publisherField.getText().isEmpty()) {
			publisherField.pseudoClassStateChanged(error, true);
		} else {
			correctValues++;
			publisherField.pseudoClassStateChanged(error, false);
		}
		if(languageField.getText().isEmpty()) {
			languageField.pseudoClassStateChanged(error, true);
		} else {
			correctValues++;
			languageField.pseudoClassStateChanged(error, false);
		}
		if(locationField.getText().isEmpty()) {
			locationField.pseudoClassStateChanged(error, true);
		} else {
			correctValues++;
			locationField.pseudoClassStateChanged(error, false);
		}
		
		if(correctValues == 11) {
			// Read out values
			String title = titleField.getText();
			String author = authorField.getText();
			String series = seriesField.getText();
			String seriesNo = seriesNoField.getText();
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
	}
	
	@FXML
	private void handleCancelButtonClicked() {
		((Stage) cancelButton.getScene().getWindow()).close();
	}
}
