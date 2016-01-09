import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.omg.CORBA.PUBLIC_MEMBER;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Põld {
    int peenardeArv;
    int ridadeArv;
    Stage põllumaa = new Stage();
    Peenar peenar;
    GridPane peenrastik;

    //põllu vaikimisi ja konstantsed mõõdud
    double PIIRDELAIUS = 5;
    double PÕLLU_PIKKUS = 500;
    double PÕLLU_LAIUS = 1000;
    String VAIKIMISIKIRI = "Kliki ja külva";
    Boolean VAIKIMISIKÜLV = false;


    Põld(int[] andmedSisestusväljalt) throws Exception {
        if (andmedSisestusväljalt[2] == 1) { // sisend andmedSisestusväljalt[2] on vajalik selleks, et programm käivituks vaid siis kui andmed on korrektsed
            peenardeArv = andmedSisestusväljalt[0];
            ridadeArv = andmedSisestusväljalt[1];
            double[] peenrasuurus = arvutaPeenramõõdud(peenardeArv, ridadeArv);
            peenrastik = joonistapõld(peenardeArv, ridadeArv, peenrasuurus);
            joonistaPõlluaken(peenrastik);
        }
    }


    private void joonistaPõlluaken(GridPane ruudustik) throws Exception {
        VBox aknakast = new VBox();
        HBox jalus = loojalus();
        aknakast.getChildren().addAll(ruudustik, jalus);
        Scene põlluaken = new Scene(aknakast, 1005, 600);
        põllumaa.setScene(põlluaken);
        põllumaa.show();
    }

    //joonistab peenraruudustiku
    private GridPane joonistapõld(int p, int r, double[] parameetrid) throws Exception {
        //vajalikud parameetrid põlluruudustiku joonistamiseks
        double pD = p * 1.0;
        double rD = r * 1.0;
        double peenraidRitta = Math.ceil(pD / rD);
        int peenraidRittaI = (int) peenraidRitta;
        double viimasesReas = pD - (peenraidRitta * (rD - 1));

        GridPane peenraruudustik = new GridPane();
        peenraruudustik.setStyle("-fx-background-color: DARKGREEN;");

        //paneb ruudustikule paika peenrad
        for (int i = 0; i < peenraidRittaI; i++) {
            for (int j = 0; j < r - 1; j++) {
                int[] koht = new int[2];
                koht[0] = i;
                koht[1] = j;
                peenar = new Peenar(parameetrid, VAIKIMISIKÜLV, VAIKIMISIKIRI, koht, peenraruudustik);
            }
        }
        //paneb viimasesse (ebastandartsesse) ritta paika peenrad
        for (int i = 0; i < viimasesReas; i++) {
            int[] koht = new int[2];
            koht[0] = i;
            koht[1] = r;
            peenar = new Peenar(parameetrid, VAIKIMISIKÜLV, VAIKIMISIKIRI, koht, peenraruudustik);
        }
        return peenraruudustik;
    }


    private double[] arvutaPeenramõõdud(int p, int r) {
        double pD = p * 1.0;
        double rD = r * 1.0;
        double peenraidRitta = Math.ceil(pD / rD);

        double peenraPikkus = (PÕLLU_PIKKUS - 2 * (int) PIIRDELAIUS) / rD;
        double peenraLaius = (PÕLLU_LAIUS - 2 * (int) PIIRDELAIUS) / peenraidRitta;

        //koondab kõik tagastatavad andmed ühte massiivi
        double[] peenramõõdud = new double[2];
        peenramõõdud[0] = peenraLaius;
        peenramõõdud[1] = peenraPikkus;
        return peenramõõdud;
    }


    private HBox loojalus() {
        HBox alumisednupud = new HBox();
        alumisednupud.setSpacing(30);
        alumisednupud.setMinHeight(100);
        alumisednupud.setPadding(new Insets(20, 50, 15, 50));
        alumisednupud.setStyle("-fx-background-color: GREENYELLOW;");
        Button salvesta = new Button("Salvesta");
        salvesta.setOnAction(event1 -> {
            AndmeKonvertija.salvestaPilt(peenrastik);
        });
        Button sulge = new Button("Sulge");
        sulge.setOnAction(event -> põllumaa.close());
        alumisednupud.getChildren().addAll(salvesta, sulge);
        return alumisednupud;

    }


}


