package ui_chart_dataseries;

/**
 * The application takes data 
 * from MySQL Workbench databases
 * and inserts it into the LineChart
 * which consists of three series
 * of data from 3 database Tables.
 * There are 2 buttons:
 * one removes a line, the other
 * closes the application.
 * 
 * */

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.sun.glass.ui.Window;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class UI_LineChart_Series extends Application {

	final NumberAxis xAxis = new NumberAxis(2011, 2018, 1);
	final NumberAxis yAxis = new NumberAxis(-0.2, 3.0, 0.2);
	LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
	Parent root = lineChart;
	Pane pane = new Pane();

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("from MySQL database to LineChart");
		primaryStage.setScene(new Scene(root, 900, 800));
		primaryStage.show();
		pane.setPrefSize(900, 620);

		Scene scene = new Scene(pane);
		scene.getStylesheets().add(getClass().getResource("linechartStyle.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();

		accessDB();
		executeDBStatements();
		insertDataToChart();
		addUI();
	}

	Connection connection;
	Statement statement;

	PreparedStatement prepStatement;
	ResultSet resultSet;
	String selectSQLData = "SELECT * FROM LGSCIE1";

	PreparedStatement prepStatement2;
	ResultSet resultSet2;
	String selectSQLData2 = "SELECT * FROM LGSCIE3";

	PreparedStatement prepStatement3;
	ResultSet resultSet3;
	String selectSQLData3 = "SELECT * FROM LGSCIE2";

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

		resultSet2 = statement.executeQuery(selectSQLData2);
		prepStatement2 = connection.prepareStatement(selectSQLData2);
		resultSet2 = prepStatement2.executeQuery();

		resultSet3 = statement.executeQuery(selectSQLData3);
		prepStatement3 = connection.prepareStatement(selectSQLData3);
		resultSet3 = prepStatement3.executeQuery();
	}

	public void insertDataToChart() throws SQLException {

		lineChart.setTitle("Scientific Languages: % Github Users growth");
		lineChart.setPrefSize(900, 500);
		// lineChart.setAnimated(false);
		lineChart.setLegendVisible(true);
		lineChart.setLegendSide(Side.RIGHT);

		// xAxis.setLabel("Year");
		xAxis.setLowerBound(2011);
		xAxis.setUpperBound(2018);
		xAxis.setTickLabelRotation(15);
		xAxis.setAutoRanging(false);

		yAxis.setLabel("% Percentage of Users");

		yAxis.setTickLabelGap(3);

		XYChart.Series series1 = new XYChart.Series();
		XYChart.Series series2 = new XYChart.Series();
		XYChart.Series series3 = new XYChart.Series();

		int a = 1;
		int b = 2;

		while (resultSet.next()) {
			XYChart.Data<Integer, Double> ratingsdata = new XYChart.Data<>(resultSet.getInt(a), resultSet.getDouble(b));
			series1.getData().add(ratingsdata);
		}
		a++;
		b++;

		int i = 1;
		int j = 2;
		while (resultSet2.next()) {
			XYChart.Data<Integer, Double> ratingsdata2 = new XYChart.Data<>(resultSet2.getInt(i),
					resultSet2.getDouble(j));
			series2.getData().add(ratingsdata2);
		}
		i++;
		j++;

		int m = 1;
		int n = 2;
		while (resultSet3.next()) {
			XYChart.Data<Integer, Double> ratingsdata3 = new XYChart.Data<>(resultSet3.getInt(m),
					resultSet3.getDouble(n));
			series3.getData().add(ratingsdata3);
		}
		m++;
		n++;

		series1.setName("Jupyter Notebook");
		series2.setName("MATLAB");
		series3.setName("R");

		lineChart.getData().addAll(series1, series2, series3);
		pane.getChildren().add(lineChart);
	}

	public void addUI() throws Exception {

		final Button closeButton = new Button("Close");
		final Button removeButton = new Button("Remove line");
		closeButton.setLayoutX(800);
		closeButton.setLayoutY(550);
		removeButton.setLayoutX(30);
		removeButton.setLayoutY(550);

		pane.getChildren().addAll(closeButton, removeButton);

		closeButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.close();
			}
		});

		removeButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!lineChart.getData().isEmpty())
					lineChart.getData().remove((int) (Math.random() * (lineChart.getData().size() - 1)));
			}
		});
	}

	public static void main(String[] args) {
		launch(args);
	}
}