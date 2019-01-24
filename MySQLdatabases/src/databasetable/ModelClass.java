package databasetable;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class ModelClass {

	private StringProperty nameProperty = new SimpleStringProperty();
	private StringProperty progrlangProperty = new SimpleStringProperty();
	private IntegerProperty yearProperty = new SimpleIntegerProperty();

	public StringProperty nameProperty() { // property getter in JavaFX
		return nameProperty;
	}

	public StringProperty progrlangProperty() { 
		return progrlangProperty;
	}

	public IntegerProperty yearProperty() { 
		return yearProperty;
	}

	ModelClass() {
	}

	public ModelClass(String name, String progrlang, int year) {
		nameProperty.set(name);
		progrlangProperty.set(progrlang);
		yearProperty.set(year);
	}

}