package com.example.helloworldfx;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalculatorFX extends Application {

    private final Calculation calculation = new Calculation();
    private final CreateErrorPopUp errorPopUp = new CreateErrorPopUp();
    @Override
    public void start(Stage stage) {

        stage.setTitle("Calculator");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(15));
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setStyle("-fx-background-color: lightgrey; -fx-padding: 20; -fx-font-size: 20;");

        Scene scene = new Scene(gridPane, 400, 250);

        gridPane.add(new Label("Equation:"), 0, 0);
        TextField equation = new TextField();
        gridPane.add(equation, 1, 0);
        gridPane.add(new Label("Result:"), 0, 3);
        Button aButton = new Button("Calculate");
        gridPane.add(aButton, 1, 2);
        GridPane.setHalignment(aButton, HPos.LEFT);
        TextField result = new TextField();
        result.setEditable(false);
        gridPane.add(result, 1, 3);

        aButton.setOnAction(e -> {
            String eq = equation.getText();
            result.setText(doCalculation(stage, eq));
        });

        stage.setScene(scene);

        stage.show();

    }

    private String doCalculation(Stage stage, String eq) {

        String s = calculation.doCalculation(eq);

        if(eq.matches(".*[a-zA-Z.].*")){
            errorPopUp.createAndGetPopUp().show(stage);
            return "";
        }
        else{
            if(s.contains(".0")){
                s = s.substring(0, s.indexOf("."));
            }
            return s;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}