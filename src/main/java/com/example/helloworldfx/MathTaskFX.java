package com.example.helloworldfx;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class MathTaskFX extends Application {
    @Override
    public void start(Stage stage){

        MathTaskGenerator mathTaskGenerator = new MathTaskGenerator();
        Calculation calculation = new Calculation();

        stage.setTitle("Math Task Game");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(15));
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setStyle("-fx-background-color: lightgrey; -fx-padding: 20; -fx-font-size: 20;");

        Scene scene = new Scene(gridPane, 400, 250);

        gridPane.add(new Label("Equation:"), 0, 0);
        TextField equation = new TextField();
        equation.setText(mathTaskGenerator.getRandomEquation());
        equation.setEditable(false);
        gridPane.add(equation, 1, 0);
        gridPane.add(new Label("Result:"), 0, 2);
        Button aButton = new Button("Submit");
        gridPane.add(aButton, 1, 3);
        GridPane.setHalignment(aButton, HPos.LEFT);
        TextField result = new TextField();
        gridPane.add(result, 1, 2);

        Label label = new Label();
        label.setAlignment(Pos.CENTER);
        Border border = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
        label.setBorder(border);

        label.setMinWidth(100);
        label.setMinHeight(70);

        Popup popup = new Popup();
        popup.getContent().add(label);

        aButton.setOnAction(e -> {

            doCalculation(stage, calculation, equation, result, label, popup);
        });

        stage.setScene(scene);

        stage.show();
    }

    private void doCalculation(Stage stage, Calculation calculation, TextField equation, TextField result, Label label, Popup popup) {
        String s = calculation.doCalculation(equation.getText());

        if(s.contains(".")) {
            s = s.substring(0, s.indexOf("."));
        }
        System.out.println(s);

        if(result.getText().equals(s)){
            label.setText("Correct");
            label.setStyle(" -fx-background-color: darkseagreen; -fx-padding: 15; -fx-font-size: 20;");
        }else{
            label.setText("False");
            label.setStyle(" -fx-background-color: lightcoral; -fx-padding: 15; -fx-font-size: 20;");
        }
        popup.show(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
