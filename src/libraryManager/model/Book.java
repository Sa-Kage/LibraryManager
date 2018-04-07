package libraryManager.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import libraryManager.resources.ResourceReader;

/**
 * 
 * @author Alexander Luebbe
 *
 */
public class Book extends LibraryItem {

	/**
	 * 
	 */
	public enum Cover {
		HARDCOVER {
			public String toString() {
				return ResourceReader.getString("Book.Hardcover"); //$NON-NLS-1$
			}
		},
		
		PAPERBACK {
			public String toString() {
				return ResourceReader.getString("Book.Paperback"); //$NON-NLS-1$
			}
		},
		
		SOFTCOVER {
			public String toString() {
				return ResourceReader.getString("Book.Softcover"); //$NON-NLS-1$
			}
		}
	}
	
	/**
	 * 
	 */
	public enum Kind {
		NOVEL {
			public String toString() {
				return ResourceReader.getString("Book.Novel"); //$NON-NLS-1$
			}
		},
		
		MANGA {
			public String toString() {
				return ResourceReader.getString("Book.Manga"); //$NON-NLS-1$
			}
		}
	}
	
	private final StringProperty AUTHOR;
	private final StringProperty PUBLISHER;
	private final ObjectProperty<Kind> KIND;
	private final StringProperty LANGUAGE;
	private final ObjectProperty<Cover> COVER;
	private final StringProperty lentTo;
	
	/**
	 * 
	 * @param titel
	 * @param author
	 * @param series
	 * @param seriesNumber
	 * @param publisher
	 * @param kind
	 * @param language
	 * @param cover
	 * @param location
	 * @param comment
	 */
	public Book(String titel, String author, String series, int seriesNumber, 
			String publisher, Kind kind, String language, Cover cover, 
			String location, String lentTo, String comment) {
		super(titel, location, series, seriesNumber, comment);
		AUTHOR 		= new SimpleStringProperty(author);
		PUBLISHER 	= new SimpleStringProperty(publisher);
		KIND		= new SimpleObjectProperty<Kind>(kind);
		LANGUAGE	= new SimpleStringProperty(language);
		COVER 		= new SimpleObjectProperty<Cover>(cover);
		this.lentTo = new SimpleStringProperty(lentTo);
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return AUTHOR.getValue();
	}
	
	public StringProperty authorProperty() {
		return AUTHOR;
	}

	/**
	 * @return the publisher
	 */
	public String getPublisher() {
		return PUBLISHER.getValue();
	}
	
	public StringProperty publisherProperty() {
		return PUBLISHER;
	}
	
	/**
	 * 
	 * @return
	 */
	public Kind getKind() {
		return KIND.getValue();
	}
	
	public ObjectProperty<Kind> kindProperty() {
		return KIND;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getLanguage() {
		return LANGUAGE.getValue();
	}
	
	public StringProperty languageProperty() {
		return LANGUAGE;
	}

	/**
	 * @return the cover
	 */
	public Cover getCover() {
		return COVER.getValue();
	}
	
	public ObjectProperty<Cover> coverProperty() {
		return COVER;
	}

	/**
	 * @return the lentTo
	 */
	public String getLent() {
		return lentTo.getValue();
	}

	/**
	 * @param lentTo the person, the book is tent to
	 */
	public void setLent(String lentTo) {
		this.lentTo.setValue(lentTo);
	}
	
	public StringProperty lentToProperty() {
		return lentTo;
	}
}
