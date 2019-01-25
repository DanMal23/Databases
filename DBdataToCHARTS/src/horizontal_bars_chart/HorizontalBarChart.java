package horizontal_bars_chart;

/**
 * The application takes data 
 * from MySQL Workbench databases
 * and inserts it into the BarChart.
 * The bars are horizontal.
 * 
 * */

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HorizontalBarChart extends Application {

	final NumberAxis xAxis = new NumberAxis();
	final CategoryAxis yAxis = new CategoryAxis();
	BarChart<Number, String> barChart = new BarChart<>(xAxis, yAxis);
	Parent root = barChart;
	Pane pane = new Pane();

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("from MySQL database");
		primaryStage.setScene(new Scene(root, 400, 500));
		primaryStage.show();

		pane.setPrefSize(500, 600);

		Scene scene = new Scene(pane);
		scene.getStylesheets().add(getClass().getResource("hbarchartStyle.css").toExternalForm());
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
	String selectSQLData = "SELECT * FROM SOHORIZ";

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

		barChart.setTitle("Stack Overflow Ratings 2018");
		barChart.setPrefSize(500, 600);
		barChart.setAnimated(false);
		barChart.setLegendVisible(false);

		xAxis.setLabel("% Ratings");
		yAxis.setLabel("Languages");
		yAxis.setTickLabelGap(5);

		XYChart.Series series1 = new XYChart.Series();

		int i = 1;
		int j = 2;

		while (resultSet.next()) {
			XYChart.Data<Double, String> ratingsdata = new XYChart.Data<>(resultSet.getDouble(i),
					resultSet.getString(j));
			series1.getData().add(ratingsdata);

			ratingsdata.nodeProperty().addListener(new ChangeListener<Node>() {
				public void changed(ObservableValue<? extends Node> ov, Node oldNode, final Node node) {
					if (node != null) {
						if (ratingsdata.getXValue().doubleValue() > 60) {
							node.setStyle("-fx-bar-fill:#ccb882");
						} else {
							node.setStyle("-fx-bar-fill:#82b1cc");
						}
					}
				}
			});
		}
		i++;
		j++;

		barChart.getData().addAll(series1);
		pane.getChildren().add(barChart);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
