package com.example.going_green;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.application.Platform;
import java.util.Random;

public class gameController {

    Random random = new Random();

    @FXML
    private Button rollButton;

    @FXML
    private ImageView diceImage;

    public void roll(ActionEvent event) {

        rollButton.setDisable(true);
        Thread thread = new Thread() {
            public void run() {
                int diceNumber = 1;
                try {
                    for (int i = 0; i < 15; i++) {
                        diceNumber = random.nextInt(6) + 1;
                        String path = "/com/example/image/dice" + diceNumber + ".png";
                        Image image = new Image(getClass().getResourceAsStream(path));
                        Platform.runLater(() -> diceImage.setImage(image));
                        Thread.sleep(50);
                        //System.out.println(diceNumber);
                    }
                    System.out.println(diceNumber);
                    Platform.runLater(() -> rollButton.setDisable(false));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    @FXML
    private Label welcomeText;

}