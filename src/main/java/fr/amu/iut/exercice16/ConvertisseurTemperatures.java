package fr.amu.iut.exercice16;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class ConvertisseurTemperatures extends Application {

    @Override
    public void start(Stage primaryStage) {

        Slider celsiusSlider = new Slider(0, 100, 0);
        celsiusSlider.setOrientation(Orientation.VERTICAL);
        celsiusSlider.setShowTickLabels(true);
        celsiusSlider.setShowTickMarks(true);

        Slider fahrenheitSlider = new Slider(32, 212, 32);
        fahrenheitSlider.setOrientation(Orientation.VERTICAL);
        fahrenheitSlider.setShowTickLabels(true);
        fahrenheitSlider.setShowTickMarks(true);

        // Create text fields for displaying temperatures
        TextField celsiusField = new TextField();
        TextField fahrenheitField = new TextField();

        // Bind text fields to slider values
        celsiusField.textProperty().bindBidirectional(celsiusSlider.valueProperty(), new NumberStringConverter());
        fahrenheitField.textProperty().bindBidirectional(fahrenheitSlider.valueProperty(), new NumberStringConverter());

        // Create properties to hold the temperatures
        DoubleProperty celsiusProperty = new SimpleDoubleProperty();
        DoubleProperty fahrenheitProperty = new SimpleDoubleProperty();

        // Bind the properties to the slider values
        celsiusProperty.bindBidirectional(celsiusSlider.valueProperty());
        fahrenheitProperty.bindBidirectional(fahrenheitSlider.valueProperty());

        // Bind the properties with a conversion formula
        celsiusProperty.addListener((observable, oldValue, newValue) -> {
            double celsius = newValue.doubleValue();
            double fahrenheit = celsius * 9 / 5 + 32;
            fahrenheitProperty.set(fahrenheit);
        });

        fahrenheitProperty.addListener((observable, oldValue, newValue) -> {
            double fahrenheit = newValue.doubleValue();
            double celsius = (fahrenheit - 32) * 5 / 9;
            celsiusProperty.set(celsius);
        });

        // Create labels
        Label celsiusLabel = new Label("°C");
        Label fahrenheitLabel = new Label("°F");

        // Set up the layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(celsiusLabel, 0, 0);
        grid.add(fahrenheitLabel, 1, 0);
        grid.add(celsiusSlider, 0, 1);
        grid.add(fahrenheitSlider, 1, 1);
        grid.add(celsiusField, 0, 2);
        grid.add(fahrenheitField, 1, 2);

        // Set up the scene
        Scene scene = new Scene(grid, 200, 400);

        primaryStage.setTitle("Temperature Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
