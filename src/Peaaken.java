

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


import java.security.PublicKey;

/**
 * Created by ltaimre on 12.12.15.
 */
public class Peaaken {

    Scene põlluvaade;


    public void vahetaakent() {
        VBox katsetan = new VBox();
        Label proov = new Label("test");
        põlluvaade = new Scene(katsetan, 500, 500);
        programm.setScene(põlluvaade);
    }

    public void joonistapeenraid(double[] parameetrid){
        double laius = parameetrid[0];
        double pikkus = parameetrid[1];

        GridPane peenraruudustik = new GridPane();
        Label silt = new Label("katsesilt");

      for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Rectangle peenar = new Rectangle(laius, pikkus, Color.BLUE);
                peenar.setStroke(Color.RED);
                peenar.setStrokeWidth(10);
                peenar.setOnMouseClicked(event -> {
                    System.out.println("Saab kasvama panna");
                });
                peenraruudustik.add(peenar, i, j);

            }
        }







    }




}
