package stacked_barchart;

/**
 * The application takes data 
 * from MySQL Workbench databases
 * and inserts it into the StackedBarChart
 * with 4 categories (year) of data.
 * The bars are vertical.
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
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StackedBC_4Series extends Application {

	CategoryAxis xAxis = new CategoryAxis();
	NumberAxis yAxis = new NumberAxis();

	StackedBarChart<String, Number> stackedBC = new StackedBarChart(xAxis, yAxis);

	Parent root = stackedBC;
	Pane pane = new Pane();

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("from MYDB database");
		primaryStage.setScene(new Scene(root, 900, 600));
		primaryStage.show();

		accessDB();
		executeDBStatements();
		insertDataToChart();

		pane.setPrefSize(900, 600);

		Scene scene = new Scene(pane);
		scene.getStylesheets().add(getClass().getResource("sbcStyle.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	Connection connection;
	Statement statement;

	PreparedStatement prepStatement1;
	ResultSet resultSet1;
	String selectSQLData1 = "SELECT * FROM LGS2011";

	PreparedStatement prepStatement2;
	ResultSet resultSet2;
	String selectSQLData2 = "SELECT * FROM LGS2013";

	PreparedStatement prepStatement3;
	ResultSet resultSet3;
	String selectSQLData3 = "SELECT * FROM LGS2016";

	PreparedStatement prepStatement4;
	ResultSet resultSet4;
	String selectSQLData4 = "SELECT * FROM LGS2018";

	public void accessDB() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");

		connection = (Connection) DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false", "root", "root");

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

		resultSet4 = statement.executeQuery(selectSQLData4);
		prepStatement4 = connection.prepareStatement(selectSQLData4);
		resultSet4 = prepStatement4.executeQuery();
	}

	public void insertDataToChart() throws SQLException {

		stackedBC.setTitle("Ranking programming languages by Github users");

		stackedBC.setPrefSize(890, 600);
		stackedBC.setCategoryGap(30);
		// xAxis.setLabel("Language");
		yAxis.setLabel("% ratings");
		xAxis.setTickLabelRotation(45);
		xAxis.setTickLabelGap(5);

		yAxis.setTickLabelRotation(45);

		XYChart.Series series1 = new XYChart.Series();
		XYChart.Series series2 = new XYChart.Series();
		XYChart.Series series3 = new XYChart.Series();
		XYChart.Series series4 = new XYChart.Series();

		int a = 1;
		int b = 2;

		while (resultSet1.next()) {
			XYChart.Data<String, Double> ratingsdata1 = new XYChart.Data<>(resultSet1.getString(a),
					resultSet1.getDouble(b));
			series1.getData().add(ratingsdata1);
		}
		a++;
		b++;

		int i = 1;
		int j = 2;
		while (resultSet2.next()) {
			XYChart.Data<String, Double> ratingsdata2 = new XYChart.Data<>(resultSet2.getString(i),
					resultSet2.getDouble(j));
			series2.getData().add(ratingsdata2);
		}
		i++;
		j++;

		int m = 1;
		int n = 2;
		while (resultSet3.next()) {
			XYChart.Data<String, Double> ratingsdata3 = new XYChart.Data<>(resultSet3.getString(m),
					resultSet3.getDouble(n));
			series3.getData().add(ratingsdata3);
		}
		m++;
		n++;

		int o = 1;
		int p = 2;
		while (resultSet4.next()) {
			XYChart.Data<String, Double> ratingsdata4 = new XYChart.Data<>(resultSet4.getString(o),
					resultSet4.getDouble(p));
			series4.getData().add(ratingsdata4);
		}
		o++;
		p++;

		series1.setName("2011");
		series2.setName("2013");
		series3.setName("2016");
		series4.setName("2018");

		stackedBC.getData().addAll(series1, series2, series3, series4);
		stackedBC.setAnimated(false);

		pane.getChildren().add(stackedBC);

	}

	public static void main(String[] args) {
		launch(args);
	}
}