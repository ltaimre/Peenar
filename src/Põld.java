import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.org.apache.xpath.internal.operations.And;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.util.Arrays;

public class Põld {

    Stage põllumaa = new Stage();
    Scene peenravaade;

    //põllu konstantsed mõõdud
    double PIIRDELAIUS = 5;
    double PÕLLU_PIKKUS = 500;
    double PÕLLU_LAIUS = 1000;

    Põld(int[]a) {
        if (a[2] == 1) { // sisend a on vajalik selleks, et programm käivituks vaid siis kui andmed on korrektsed
        double [] mõõdud = arvutamõõdud(a);
        Scene põllujoonis = joonistapõld(mõõdud);
        põllumaa.setScene(põllujoonis);
        põllumaa.show();
        }
        else {
            System.out.println("ERROR!");
        }

    }

    //joonistab peenraruudustiku
    private Scene joonistapõld(double[] parameetrid) {
        double laius = parameetrid[0];
        double pikkus = parameetrid[1];
        int read = (int) parameetrid[2];
        int peenradreas = (int)parameetrid[3];
        int viimanerida = (int)parameetrid[4];

        GridPane peenraruudustik = new GridPane();



        for (int i = 0; i < peenradreas; i++) {
            for (int j = 0; j < (read-1); j++) {
                /* Rectangle peenar = new Rectangle(laius, pikkus, Color.BLUE);
                TextField panekasvama = new TextField("Voot?");
                panekasvama.setAlignment(Pos.BOTTOM_CENTER);
                peenar.setStroke(Color.RED);
                peenar.setStrokeWidth(PIIRDELAIUS);
                peenar.setOnMouseClicked(event -> {
                    peenar.setStroke(Color.BLACK);
                    new MidaKülvata();
                    System.out.println("Saab kasvama panna");
                    System.out.println(Arrays.toString(AndmeKonvertija.asukohaandmed(peenraruudustik, peenar)));

                });
                */
                peenraruudustik.add(Peenar.looPeenar(parameetrid), i, j);
                Label nupp = new Label("Kliki ja külva!");
                nupp.setTextAlignment(TextAlignment.CENTER);
                nupp.setAlignment(Pos.CENTER);
                peenraruudustik.add(nupp, i, j);

            }
        }

        for (int i = 0; i <viimanerida; i++) {
                peenraruudustik.add(Peenar.looPeenar(parameetrid), i , read);
            }

        peenravaade = new Scene(peenraruudustik, 1005, 600);
        return peenravaade;
    }

    private double[] arvutamõõdud(int [] andmed) {
    //Arvutab peenarde mõõdud vastavalt kasutaja käest saadud sisendile
        double peenardeArv = andmed [0] * 1.0;
        double ridadeArv = andmed [1] * 1.0;

        double peenraidReas = Math.ceil(peenardeArv/ridadeArv);
        double viimasesReas = peenardeArv - (peenraidReas * (ridadeArv-1));

        double peenraPikkus = (PÕLLU_PIKKUS - 2 * (int)PIIRDELAIUS)/ridadeArv;
        double peenraLaius =  (PÕLLU_LAIUS - 2 * (int)PIIRDELAIUS)/peenraidReas;

        double[] peenramõõdud = new double[5];
        peenramõõdud[0] = peenraLaius;
        peenramõõdud[1] = peenraPikkus;
        peenramõõdud[2] = ridadeArv;
        peenramõõdud[3] = peenraidReas;
        peenramõõdud[4] = viimasesReas;

        return peenramõõdud;
    }
}
