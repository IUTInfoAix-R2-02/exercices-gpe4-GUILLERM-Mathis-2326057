package fr.amu.iut.exercice7;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class CounterController implements Initializable {

    @FXML
    private Label counterLabel;

    @FXML
    private Button incrementButton;

    @FXML
    private Button decrementButton;

    private int counter = 0;

    

    @FXML
    public void increment() {
        counter++;
        counterLabel.setText(Integer.toString(counter));
    }

    @FXML
    public void decrement() {
        counter--;
        counterLabel.setText(Integer.toString(counter));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Initializing CounterController...");
   }
}
