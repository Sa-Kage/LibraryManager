package libraryManager.GUI;

import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import libraryManager.Main;
import libraryManager.model.Book;
import libraryManager.model.Book.Cover;
import libraryManager.model.Book.Kind;
import libraryManager.resources.ResourceReader;

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
		bookTable.setRowFactory(new Callback<TableView<Book>, TableRow<Book>>() {
			@Override
			public TableRow<Book> call(TableView<Book> tableView) {
				final TableRow<Book> row = new TableRow<>();
				final ContextMenu contextMenu = new ContextMenu();
				final MenuItem edit = new MenuItem(ResourceReader.getString("BookTable.Edit"));
				final MenuItem delete = new MenuItem(ResourceReader.getString("BookTable.Delete"));
				edit.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent arg0) {
						controller.showEditBookDialog(row.getItem());
					}
				});
				delete.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent arg0) {
						bookTable.getItems().remove(row.getItem());
					}
				});
				contextMenu.getItems().add(edit);
				contextMenu.getItems().add(delete);
				row.contextMenuProperty().bind(Bindings.when(row.emptyProperty()).then((ContextMenu)null).otherwise(contextMenu));
				return row;
			}
			
		});
		
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
