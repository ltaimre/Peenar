

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


import java.security.PublicKey;

/**
 * Created by ltaimre on 12.12.15.
 */
public class Peaaken {

    Stage programm2 = new Stage();
    Scene stseen3;

    Peaaken () {
        System.out.println("PEAAKEN");
        joonistapeenraid();

    }


    public void joonistapeenraid(){

        GridPane peenraruudustik = new GridPane();
        Label silt = new Label("katsesilt");
        //Rectangle peenar = new Rectangle(50, 50, Color.BLUE);
        Rectangle peenar2 = new Rectangle(50, 50, Color.BLUE);
        //peenraruudustik.add(peenar, 0, 1);
        //peenraruudustik.add(peenar2, 1, 2);



      for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Rectangle peenar = new Rectangle(50, 50, Color.BLUE);
                peenar.setStroke(Color.RED);
                peenar.setStrokeWidth(10);
                peenar.setOnMouseClicked(event -> {
                    System.out.println("Saab kasvama panna");
                });
                peenraruudustik.add(peenar, i, j);

            }
        }


       stseen3 = new Scene(peenraruudustik,500,500);
       programm2.setScene(stseen3);
       programm2.show();






    }




}
