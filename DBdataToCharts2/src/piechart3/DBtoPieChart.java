package piechart3;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DBtoPieChart extends Application {

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
		showPercentOnClick();
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
	// String selectSQLData = "SELECT * FROM LGPOP2018";
	String selectSQLData = "SELECT NAME, PERCENT FROM LGPOP2018";

	public void accessDB() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");

		connection = (Connection) DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false", "root", "root");

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

		pane.getChildren().add(pieChart);

	}

	public void showPercentOnClick() {
		final Label caption = new Label(""); /* https://docs.oracle.com/javafx/2/charts/pie-chart.htm#BABHBIJH */
		caption.setTextFill(Color.ALICEBLUE);
		caption.setStyle("-fx-font: 25 Arial;");

		for (final PieChart.Data data : pieChart.getData()) {
			data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					caption.setTranslateX(e.getSceneX());
					caption.setTranslateY(e.getSceneY());
					caption.setText(String.valueOf(data.getPieValue()) + "%");
				}
			});
		}
		pane.getChildren().add(caption);
	}

	public static void main(String[] args) {
		launch(args);
	}

}