package libraryManager.IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import libraryManager.model.Book;
import libraryManager.model.Book.Cover;
import libraryManager.model.Book.Kind;

public class IOManager {

	/**
	 * 
	 * @param file
	 * @return
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static ObservableList<Book> loadFile(File file) throws IOException {
		ObservableList<Book> books = FXCollections.observableArrayList();
		FileReader fileReader = new FileReader(file);
		BufferedReader bufReader = new BufferedReader(fileReader);
		
		if(bufReader.readLine().matches("<bookList>")) {
			while(bufReader.readLine().matches("\\s*<book>")) {
				books.add(readBook(bufReader));
			}
		} else {
			// TODO:
		}
			
		bufReader.close();
		fileReader.close();
		return books;
	}
	
	/**
	 * 
	 * @param reader
	 * @return
	 * @throws IOException
	 */
	private static Book readBook(BufferedReader reader) throws IOException {
		String xml;
		String title = getInfoFromXML(reader.readLine());
		String author = getInfoFromXML(reader.readLine());
		String series = getInfoFromXML(reader.readLine());
		String seriesNo = getInfoFromXML(reader.readLine());
		Kind kind = null;
		xml = reader.readLine();
		if(xml.matches("\\s*<kind>.*</kind>")) {
			xml = xml.replaceAll("\\s", "");
			if(xml.substring(6, xml.length()-7).matches("Novel")) {
				kind = Kind.NOVEL;
			} else if(xml.substring(6, xml.length()-7).matches("Manga")) {
				kind = Kind.MANGA;
			} else {
				throw new IOException("Error while parsing XML: Illegal kind!");
			}
		} else {
			throw new IOException("Error while parsing XML: Kind not declared correctly!");
		}
		String publisher = getInfoFromXML(reader.readLine());
		String language = getInfoFromXML(reader.readLine());
		Cover cover = null;
		xml = reader.readLine();
		if(xml.matches("\\s*<cover>.*</cover>")) {
			xml = xml.replaceAll("\\s", "");
			if(xml.substring(7, xml.length()-8).matches("Hardcover")) {
				cover = Cover.HARDCOVER;
			} else if(xml.substring(7, xml.length()-8).matches("Paperback")) {
				cover = Cover.PAPERBACK;
			} else if(xml.substring(7, xml.length()-8).matches("Softcover")) {
				cover = Cover.SOFTCOVER;
			} else {
				throw new IOException("Error while parsing XML: Illegal cover type!");
			}
		} else {
			throw new IOException("Error while parsing XML: Cover not declared correctly!");
		}
		String location = getInfoFromXML(reader.readLine());
		String lentTo = getInfoFromXML(reader.readLine());
		String comment = getInfoFromXML(reader.readLine());
		xml = reader.readLine();
		System.out.println(xml);
		if(!xml.matches("\\s*</book>")) {
			throw new IOException("Error while parsing XML: Book not closed correctly!");
		}
		
		return new Book(title, author, series, seriesNo, publisher, kind, language, cover, location, lentTo, comment);
	}
	
	private static String getInfoFromXML(String xmlLine) {
		xmlLine = xmlLine.substring(5, xmlLine.length()-1);
		xmlLine = xmlLine.split(">")[1].split("<")[0];
		return xmlLine;
	}

	/**
	 * @param file
	 * @throws IOException 
	 */
	public static void saveTo(File file, ObservableList<Book> bookList) throws IOException {
		String data = "<bookList>\n";
		for(Book b : bookList) {
			data += "  <book>\n";
			data += "    <title>" + b.getTitle() + "</title>\n";
			data += "    <author>" + b.getAuthor() + "</author>\n";
			data += "    <series>" + b.getSeries() + "</series>\n";
			data += "    <seriesNo>" + b.getSeriesNumber() + "</seriesNo>\n";
			switch(b.getKind()) {
				case NOVEL:
					data += "    <kind>Novel</kind>\n";
					break;
				case MANGA:
					data += "    <kind>Manga</kind>\n";
					break;
			}
			data += "    <publisher>" + b.getPublisher() + "</publisher>\n";
			data += "    <language>" + b.getLanguage() + "</language>\n";
			switch(b.getCover()) {
			case HARDCOVER:
				data += "    <cover>Hardcover</cover>\n";
				break;
			case PAPERBACK:
				data += "    <cover>Paperback</cover>\n";
				break;
			case SOFTCOVER:
				data += "    <cover>Softcover</cover>\n";
				break;
		}
			data += "    <location>" + b.getLocation() + "</location>\n";
			data += "    <lentTo>" + b.getLent() + "</lentTo>\n";
			data += "    <comment>" + b.getComment() + "</comment>\n";
			data += "  </book>\n";
		}
		data += "</bookList>\n";
		FileWriter writer = new FileWriter(file);
		writer.write(data);
		writer.close();
	}
}
