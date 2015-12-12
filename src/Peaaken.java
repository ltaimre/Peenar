

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
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
       // Rectangle ruut = new Rectangle(20, 20, 70, 50);
        GridPane.setConstraints(silt, 3, 3);
        peenraruudustik.getChildren().addAll( silt);



       /* for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                peenraruudustik.add(ruut, i, j);

            }
        } */


       stseen3 = new Scene(peenraruudustik,500,500);
       programm2.setScene(stseen3);
       programm2.show();






    }




}
