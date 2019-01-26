package databasetable;

/*
 * The application shows data 
 * from MySQL Workbench
 * in a tableView.
 * 
 * */

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Main extends Application {
	private TableView<ModelClass> tableView = new TableView<>();

	@Override
	public void start(Stage primaryStage) throws SQLException, ClassNotFoundException {

		Parent root = tableView;

		primaryStage.setTitle("from MySQL database");
		primaryStage.setScene(new Scene(root, 360, 400));
		primaryStage.show();

		tableView.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

		accessDB();
		executeDBStatements();
		insertDataToTableView();
	}

	Connection connection;
	Statement statement;
	PreparedStatement prepStatement;
	ResultSet resultSet;
	String selectData = "SELECT * FROM LGS";

	public void accessDB() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");

		connection = (Connection) DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false", "root", "root");

		statement = (Statement) connection.createStatement();
	}

	public void executeDBStatements() throws SQLException {

		resultSet = statement.executeQuery(selectData);
		try {
			prepStatement = connection.prepareStatement(selectData);
			resultSet = prepStatement.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertDataToTableView() throws SQLException {

		ObservableList mydbTableData = FXCollections.observableArrayList(dataBaseArrayList(resultSet));

		for (int i = 0; i < resultSet.getMetaData().getColumnCount(); i++) {
			TableColumn column = new TableColumn<>();
			switch (resultSet.getMetaData().getColumnName(i + 1)) {
			case "name":
				column.setText("Name");
				break;
			case "progrlang":
				column.setText("Language");
				break;
			case "year":
				column.setText("Year");
				break;
			default:
				column.setText(resultSet.getMetaData().getColumnName(i + 1));
				break;
			}
			column.setCellValueFactory(new PropertyValueFactory<>(resultSet.getMetaData().getColumnName(i + 1)));

			tableView.getColumns().add(column);
		}

		tableView.setItems(mydbTableData);
	}

	private ArrayList dataBaseArrayList(ResultSet resultSet) throws SQLException {

		ArrayList<ModelClass> dataList = new ArrayList<>();

		while (resultSet.next()) {
			ModelClass data = new ModelClass();
			data.nameProperty().set(resultSet.getString("name"));
			data.progrlangProperty().set(resultSet.getString("progrlang"));
			data.yearProperty().set(resultSet.getInt("year"));
			dataList.add(data);
		}
		return dataList;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
