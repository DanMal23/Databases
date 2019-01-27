package bubble_chart;

/**
 * The application takes data 
 * from MySQL Workbench databases
 * and inserts it into the BubbleChart
 * with 3 series of data.
 * The table in databases contains
 * year column and percentage column.
 * Here, an extra value was added:
 * bubble's radius (which could be
 * added as an additional 
 * column to a databases table.
 * 
 * */

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BubbleChart;

import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BubbleChart0 extends Application {

	NumberAxis xAxis = new NumberAxis(0, 2018, 1);

	NumberAxis yAxis = new NumberAxis(0, 4.5, 0.5);

	BubbleChart<Number, Number> bubbleChart = new BubbleChart<>(xAxis, yAxis);
	Parent root = bubbleChart;
	Pane pane = new Pane();

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("from MySQL database to LineChart");
		primaryStage.setScene(new Scene(root, 700, 600));
		primaryStage.show();
		pane.setPrefSize(720, 620);

		Scene scene = new Scene(pane);
		scene.getStylesheets().add(getClass().getResource("bubblechartStyle.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();

		accessDB();
		executeDBStatements();
		insertDataToChart();
	}

	Connection connection;
	Statement statement;

	PreparedStatement prepStatement1;
	ResultSet resultSet1;
	String selectSQLData1 = "SELECT * FROM LGTRENDS1";

	PreparedStatement prepStatement2;
	ResultSet resultSet2;
	String selectSQLData2 = "SELECT * FROM LGTRENDS2";

	PreparedStatement prepStatement3;
	ResultSet resultSet3;
	String selectSQLData3 = "SELECT * FROM LGTRENDS3";

	public void accessDB() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		connection = (Connection) DriverManager
				.getConnection("jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false", "root", "root");
		statement = (Statement) connection.createStatement();
	}

	public void executeDBStatements() throws SQLException {
		resultSet1 = statement.executeQuery(selectSQLData1);
		prepStatement1 = connection.prepareStatement(selectSQLData1);
		resultSet1 = prepStatement1.executeQuery();

		resultSet2 = statement.executeQuery(selectSQLData2);
		prepStatement2 = connection.prepareStatement(selectSQLData2);
		resultSet2 = prepStatement2.executeQuery();

		resultSet3 = statement.executeQuery(selectSQLData3);
		prepStatement3 = connection.prepareStatement(selectSQLData3);
		resultSet3 = prepStatement3.executeQuery();
	}

	public void insertDataToChart() throws SQLException {

		bubbleChart.setTitle("Lg trends: % of Github Users ");
		bubbleChart.setPrefSize(700, 600);
		bubbleChart.setAnimated(false);
		bubbleChart.setLegendVisible(true);

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

		while (resultSet1.next()) {
			XYChart.Data<Integer, Double> ratingsdata1 = new XYChart.Data<>(resultSet1.getInt(a),
					resultSet1.getDouble(b));
			series1.getData().add(ratingsdata1);
			ratingsdata1.setExtraValue(0.2); // bubble radius
		}
		a++;
		b++;

		int i = 1;
		int j = 2;
		while (resultSet2.next()) {
			XYChart.Data<Integer, Double> ratingsdata2 = new XYChart.Data<>(resultSet2.getInt(i),
					resultSet2.getDouble(j));
			series2.getData().add(ratingsdata2);
			ratingsdata2.setExtraValue(0.2);
		}
		i++;
		j++;

		int m = 1;
		int n = 2;
		while (resultSet3.next()) {
			XYChart.Data<Integer, Double> ratingsdata3 = new XYChart.Data<>(resultSet3.getInt(m),
					resultSet3.getDouble(n));
			series3.getData().add(ratingsdata3);
			ratingsdata3.setExtraValue(0.2);
		}
		m++;
		n++;

		series1.setName("Go");
		series2.setName("TypeScript");
		series3.setName("Kotlin");

		bubbleChart.getData().addAll(series1, series2, series3);
		pane.getChildren().add(bubbleChart);
	}

	public static void main(String[] args) {
		launch(args);
	}
}