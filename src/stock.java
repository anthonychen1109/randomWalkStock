/*
This program generates random Gaussian numbers and plots the points on a chart to simulate
a random walk in physics.
*/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;


import java.util.Random;

public class stock extends Application{

	double mu = 85; // expected return of the stock per annum (annual drift)
	double sigma = 100; // annualized volatility
	int tradingDays = 30; // number of trading days per year
	double dailyDrift = mu/tradingDays; // daily drift
	double dailyVolatility = sigma * (1/Math.sqrt(tradingDays)); // daily volatility

	@Override public void start(Stage stage) {
        stage.setTitle("Random Walk");


        //defining the axes
        final NumberAxis xAxis = new NumberAxis(); // CREATE X & Y SERIES
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("30 Trading Days"); // NAME X AXIS
        yAxis.setLabel("Price"); // NAME Y AXIS


        //creating the chart
        final LineChart<Number,Number> lineChart =
                new LineChart<Number,Number>(xAxis,yAxis);

        lineChart.setTitle("Random Walk Stock");


        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("Random Walk Stock");


        //populating the series with data
        Random rand = new Random();
        for(int i=0; i<tradingDays; i++){
        	series.getData().add(new XYChart.Data(i, rand.nextGaussian() * sigma + mu));
        } // for

        Scene scene  = new Scene(lineChart,800,600); // SET SIZE OF THE CHART
        lineChart.getData().add(series); // ADD DATA INTO CHART

        // DISPLAY THE CHART
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

} // stock class
