package libraryManager.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * 
 * @author Alexander Luebbe
 *
 */
public abstract class LibraryItem {
	
	private final StringProperty TITLE;
	private final StringProperty location;
	private final StringProperty SERIES;
	private final IntegerProperty seriesNumber;
	private final StringProperty comment;
	
	/**
	 * 
	 * @param title
	 * @param location
	 * @param series
	 * @param seriesNumber
	 * @param comment
	 */
	public LibraryItem(String title, String location, String series, int seriesNumber, String comment) {
		this.TITLE 			= new SimpleStringProperty(title);
		this.location 		= new SimpleStringProperty(location);
		this.SERIES 		= new SimpleStringProperty(series);
		this.seriesNumber 	= new SimpleIntegerProperty(seriesNumber);
		this.comment 		= new SimpleStringProperty(comment);
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return TITLE.get();
	}
	
	public StringProperty titleProperty() {
		return TITLE;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location.getValue();
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location.set(location);
	}
	
	/**
	 * 
	 * @return
	 */
	public StringProperty locationProperty() {
		return location;
	}

	/**
	 * @return the series
	 */
	public String getSeries() {
		return SERIES.get();
	}
	
	public StringProperty seriesProperty() {
		return SERIES;
	}

	/**
	 * @return the number in the series
	 */
	public int getSeriesNumber() {
		return seriesNumber.get();
	}
	
	/**
	 * 
	 * @param number
	 */
	public void setSeriesNumber(int number) {
		seriesNumber.set(number);
	}
	
	public IntegerProperty seriesNoProperty() {
		return seriesNumber;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment.get();
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment.set(comment);
	}
	
	public StringProperty commentProperty() {
		return comment;
	}
}
