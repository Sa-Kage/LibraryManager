package libraryManager;
	
import java.io.IOException;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import libraryManager.GUI.AddBookController;
import libraryManager.GUI.MainGUIController;

public class Main extends Application {
	
	private ResourceBundle bundle;
	private Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage;
			bundle = ResourceBundle.getBundle("libraryManager.resources.language");
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI/MainGUI.fxml"), bundle);
			BorderPane root = loader.load();
			MainGUIController mainGUICtrl = loader.getController();
			
			mainGUICtrl.initialize(this);
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
			
			//addBookCtrl.initialize(this);
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
}
