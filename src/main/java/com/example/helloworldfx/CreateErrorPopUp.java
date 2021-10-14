package com.example.helloworldfx;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Popup;

public class CreateErrorPopUp {

    private final Label label = new Label("Error");

    public Popup createAndGetPopUp() {

        label.setStyle(" -fx-background-color: lightcoral; -fx-padding: 15; -fx-font-size: 20;");
        label.setAlignment(Pos.CENTER);
        Border border = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
        label.setBorder(border);

        label.setMinWidth(100);
        label.setMinHeight(70);

        Popup popup = new Popup();
        popup.getContent().add(label);
        return popup;
    }
}
