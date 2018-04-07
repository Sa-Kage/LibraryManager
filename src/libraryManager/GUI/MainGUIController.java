package libraryManager.GUI;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import libraryManager.Main;
import libraryManager.model.Book;
import libraryManager.model.Book.Cover;
import libraryManager.model.Book.Kind;

/**
 * 
 * @author Alexander Luebbe
 *
 */
public class MainGUIController {

	private Main controller;
	
	@FXML
	private TableView<Book> bookTable;
	@FXML
	private TableColumn<Book, String> titleCol;
	@FXML
	private TableColumn<Book, String> authorCol;
	@FXML
	private TableColumn<Book, String> seriesCol;
	@FXML
	private TableColumn<Book, String> seriesNoCol;
	@FXML
	private TableColumn<Book, String> publisherCol;
	@FXML
	private TableColumn<Book, Kind> kindCol;
	@FXML
	private TableColumn<Book, String> languageCol;
	@FXML
	private TableColumn<Book, Cover> coverCol;
	@FXML
	private TableColumn<Book, String> locationCol;
	@FXML
	private TableColumn<Book, String> lentToCol;
	@FXML
	private TableColumn<Book, String> commentCol;
	
	/**
	 * 
	 */
	@FXML
	public void initialize() {
		bookTable.setPlaceholder(new Label(""));
		titleCol.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
		authorCol.setCellValueFactory(cellData -> cellData.getValue().authorProperty());
		seriesCol.setCellValueFactory(cellData -> cellData.getValue().seriesProperty());
		seriesNoCol.setCellValueFactory(cellData -> cellData.getValue().seriesNoProperty());
		publisherCol.setCellValueFactory(cellData -> cellData.getValue().publisherProperty());
		kindCol.setCellValueFactory(cellData -> cellData.getValue().kindProperty());
		languageCol.setCellValueFactory(cellData -> cellData.getValue().languageProperty());
		coverCol.setCellValueFactory(cellData -> cellData.getValue().coverProperty());
		locationCol.setCellValueFactory(cellData -> cellData.getValue().locationProperty());
		lentToCol.setCellValueFactory(cellData -> cellData.getValue().lentToProperty());
		commentCol.setCellValueFactory(cellData -> cellData.getValue().commentProperty());
	}
	
	/**
	 * 
	 * @param main
	 */
	public void setMain(Main main) {
		controller = main;
	}
	
	public void setBookList(ObservableList<Book> bookList) {
		bookTable.setItems(bookList);
	}
	
	/**
	 * 
	 */
	@FXML
	private void showAddBookDialog() {
		controller.showAddBookDialog();
	}
}
