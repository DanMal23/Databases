package piechart1;

/**
 * The application takes data 
 * from MySQL Workbench databases
 * and inserts it into the BarChart
 * Shows name and percentage in
 * the legend.
 */

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SimplePieChart extends Application {

	PieChart pieChart = new PieChart();
	Parent root = pieChart;
	Pane pane = new Pane();

	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("from MySQL databases");
		primaryStage.setScene(new Scene(root, 550, 600));
		primaryStage.show();

		accessDB();
		executeDBStatements();
		insertDataToChart();

		pane.setPrefSize(700, 600);

		Scene scene = new Scene(pane);
		scene.getStylesheets().add(getClass().getResource("pieStyle.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	Connection connection;
	Statement statement;
	PreparedStatement prepStatement;
	ResultSet resultSet;
	String selectSQLData = "SELECT * FROM LGPOP2018";
	/* or: String selectSQLData = "SELECT NAME, PERCENT FROM LGPOP2018"; */

	public void accessDB() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");

		connection = (Connection) DriverManager
				.getConnection("jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false", "root", "root");

		statement = (Statement) connection.createStatement();
	}

	public void executeDBStatements() throws SQLException {
		resultSet = statement.executeQuery(selectSQLData);
		prepStatement = connection.prepareStatement(selectSQLData);
		resultSet = prepStatement.executeQuery();
	}

	public void insertDataToChart() throws SQLException {

		pieChart.setTitle("Popular Languages in 2018 {source: coderseye.com}");
		pieChart.setPrefSize(690, 600);

		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

		while (resultSet.next()) {
			pieChartData.add(new PieChart.Data(resultSet.getString(1), resultSet.getDouble(2)));
		}

		pieChart.setData(pieChartData);
		pieChart.setVisible(true);

		pieChartData.forEach(
				data -> data.nameProperty().bind(Bindings.concat(data.getName(), " ", data.pieValueProperty(), "%")));

		pane.getChildren().add(pieChart);

	}

	public static void main(String[] args) {
		launch(args);
	}

}
