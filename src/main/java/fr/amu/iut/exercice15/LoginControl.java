package fr.amu.iut.exercice15;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.regex.Pattern;

public class LoginControl extends GridPane {
    @FXML
    private TextField userId;

    @FXML
    private PasswordField pwd;

    @FXML
    private Button cancelBtn;

    @FXML
    private Button okBtn;

    @FXML
    private void initialize() {
        createBindings();
    }

    private void createBindings() {
        // Password field is not editable if userId is less than 6 characters
        pwd.editableProperty().bind(Bindings.createBooleanBinding(
                () -> userId.getText().length() >= 6,
                userId.textProperty()
        ));

        // Cancel button is not clickable if both fields are empty
        cancelBtn.disableProperty().bind(Bindings.createBooleanBinding(
                () -> userId.getText().isEmpty() && pwd.getText().isEmpty(),
                userId.textProperty(), pwd.textProperty()
        ));

        // OK button is not clickable if password doesn't meet the criteria
        BooleanBinding validPasswordBinding = Bindings.createBooleanBinding(
                () -> {
                    String password = pwd.getText();
                    return password.length() >= 8 &&
                            Pattern.compile("[A-Z]").matcher(password).find() &&
                            Pattern.compile("[0-9]").matcher(password).find();
                },
                pwd.textProperty()
        );

        okBtn.disableProperty().bind(validPasswordBinding.not());
    }

    @FXML
    private void okClicked() {
        System.out.print(userId.getText() + " ");
        for (char c : pwd.getText().toCharArray()) {
            System.out.print("*");
        }
        System.out.println();
    }

    @FXML
    private void cancelClicked() {
        userId.setText("");
        pwd.setText("");
    }
}