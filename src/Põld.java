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
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.util.Arrays;

public class Põld {

    Stage põllumaa = new Stage();
    Scene peenravaade, jalus;

    //põllu konstantsed mõõdud
    double PIIRDELAIUS = 5;
    double PÕLLU_PIKKUS = 500;
    double PÕLLU_LAIUS = 1000;

    public static Rectangle looPeenar(double[] parameetrid) throws Exception {
        double laius = parameetrid[0];
        double pikkus = parameetrid[1];

        Rectangle peenar = new Rectangle(laius, pikkus, Color.SANDYBROWN);
        peenar.setStroke(Color.DARKGREEN);
        peenar.setStrokeWidth(5);

        return peenar;
    }

    Põld(int[]a) throws Exception {
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

    private void loojalus() {
        HBox alumisednupud = new HBox();
        Button salvesta = new Button();
        alumisednupud.getChildren().addAll(salvesta);

    }

    //joonistab peenraruudustiku
    private Scene joonistapõld(double[] parameetrid) throws Exception {
        double laius = parameetrid[0];
        double pikkus = parameetrid[1];
        int read = (int) parameetrid[2];
        int peenradreas = (int)parameetrid[3];
        int viimanerida = (int)parameetrid[4];

        GridPane peenraruudustik = new GridPane();

        for (int i = 0; i < peenradreas; i++) {
            for (int j = 0; j < (read-1); j++) {
                Label nupp = new Label("Kliki ja külva!");
                nupp.setTextAlignment(TextAlignment.CENTER);
                nupp.setAlignment(Pos.CENTER);
                Rectangle peenraruut = looPeenar(parameetrid);
                StackPane proovinruutu = new StackPane(peenraruut, nupp);
                peenraruut.setOnMouseClicked(event -> {
                    peenraruut.setFill(Color.LAWNGREEN);
                    try {
                        System.out.println("Tahan printida");
                        new MidaKülvata();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                        });
                        peenraruudustik.add(proovinruutu, i, j);

                //peenraruudustik.add(peenraruut, i, j);
                //AndmeKonvertija.asukohaandmed(i+1, j+1);
               // peenraruudustik.add(proovinruutu, i, j);

               // peenraruudustik.add(nupp, i, j);
            }

        }

        for (int i = 0; i <viimanerida; i++) {
            Label nupp = new Label("Kliki ja külva!");
            nupp.setTextAlignment(TextAlignment.CENTER);
            nupp.setAlignment(Pos.CENTER);
            Rectangle peenraruut = looPeenar(parameetrid);
            StackPane proovinruutu = new StackPane(peenraruut, nupp);
            peenraruudustik.add(proovinruutu, i, read);

                //peenraruudustik.add(Peenar.looPeenar(parameetrid), i , read);
              //  peenraruudustik.add(nupp, i, read);
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
