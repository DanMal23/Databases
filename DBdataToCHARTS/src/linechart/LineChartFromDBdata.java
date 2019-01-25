package linechart;

/**
 * The application takes data 
 * from MySQL Workbench databases
 * and inserts it into the LineChart
 * which consists of three series
 * of data from 3 database Tables.
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
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LineChartFromDBdata extends Application {

	final NumberAxis xAxis = new NumberAxis();
	final NumberAxis yAxis = new NumberAxis();
	LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
	Parent root = lineChart;
	Pane pane = new Pane();

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("from MySQL database to LineChart");
		primaryStage.setScene(new Scene(root, 700, 600));
		primaryStage.show();
		pane.setPrefSize(720, 620);

		Scene scene = new Scene(pane);
		scene.getStylesheets().add(getClass().getResource("linechartStyle.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();

		accessDB();
		executeDBStatements();
		insertDataToChart();
	}

	Connection connection;
	Statement statement;

	PreparedStatement prepStatement;
	ResultSet resultSet;
	String selectSQLData = "SELECT * FROM LGTRENDS1";

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

		lineChart.setTitle("Lg trends: % of Github Users ");
		lineChart.setPrefSize(700, 600);
		lineChart.setAnimated(false);
		lineChart.setLegendVisible(true);

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

		series1.setName("Go");
		series2.setName("TypeScript");
		series3.setName("Kotlin");

		lineChart.getData().addAll(series1, series2, series3);
		pane.getChildren().add(lineChart);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
