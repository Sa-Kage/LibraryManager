package libraryManager;
	
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import libraryManager.GUI.MainGUIController;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			ResourceBundle bundle = ResourceBundle.getBundle("libraryManager.resources.language");
			FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI/MainGUI.fxml"), bundle);
			BorderPane root = loader.load();
			MainGUIController mainGUICtrl = loader.getController();
			mainGUICtrl.initialize(this);
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setMaximized(true);
			primaryStage.show();
		} catch(Exception e) {
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
		// TODO Auto-generated method stub
		
	}
}
