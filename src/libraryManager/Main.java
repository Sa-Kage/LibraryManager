package libraryManager;
	
import java.io.IOException;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import libraryManager.GUI.AddBookController;
import libraryManager.GUI.MainGUIController;
import libraryManager.model.Book;

/**
 * 
 * @author Alexander Luebbe
 *
 */
public class Main extends Application {
	
	private ResourceBundle bundle;
	private Stage primaryStage;
	//private MainGUIController mainGUICtrl;
	
	private ObservableList<Book> bookList = FXCollections.observableArrayList();;
	
	/**
	 * 
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage;
			bundle = ResourceBundle.getBundle("libraryManager.resources.language");
			
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI/MainGUI.fxml"), bundle);
			BorderPane root = loader.load();
			MainGUIController mainGUICtrl = loader.getController();
			mainGUICtrl.setMain(this);
			mainGUICtrl.setBookList(bookList);
			
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setMaximized(true);
			primaryStage.show();
		} catch(Exception e) {
			// TODO:
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * 
	 */
	public void showAddBookDialog() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI/AddBook.fxml"), bundle);
			BorderPane addBook;
			addBook = loader.load();
			AddBookController addBookCtrl = loader.getController();
			
			addBookCtrl.setAdd(this);
			Scene scene = new Scene(addBook);
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.initOwner(primaryStage);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(scene);
			stage.showAndWait();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void showEditBookDialog(Book book) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI/AddBook.fxml"), bundle);
			BorderPane addBook;
			addBook = loader.load();
			AddBookController addBookCtrl = loader.getController();
			
			addBookCtrl.setAdd(this);
			addBookCtrl.setEdit(book);
			Scene scene = new Scene(addBook);
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.initOwner(primaryStage);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(scene);
			stage.showAndWait();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addBook(Book book) {
		bookList.add(book);
	}
	
	public String getString(String key) {
		return bundle.getString(key);
	}
}
