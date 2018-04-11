package libraryManager.IO;

import java.io.File;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import libraryManager.model.Book;

public class IOManager {

	public static ObservableList<Book> loadFile(File file) {
		ObservableList<Book> books = FXCollections.observableArrayList();
		// TODO:
		
		return books;
	}

	/**
	 * @param file
	 */
	public static void saveTo(File file, ObservableList<Book> bookList) {
		// TODO:
	}
}
