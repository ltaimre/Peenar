import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Põld {
    double peenardeArv;
    double ridadeArv;
    Stage põllumaa = new Stage();
    Scene peenravaade, jalus;
    Peenar peenar;
    double peenraidReas;
    int peenradreas;
    int read;
    GridPane peenraruudustik;
    int [] siinkasvab;


    //põllu konstantsed mõõdud
    double PIIRDELAIUS = 5;
    double PÕLLU_PIKKUS = 500;
    double PÕLLU_LAIUS = 1000;
    String kiri = "Kliki ja külva";


    Põld(int[] andmedSisestusväljalt) throws Exception {
        double pikkus = PÕLLU_PIKKUS;
        double laius = PÕLLU_LAIUS;
        int peenraidpõllul = (int)peenardeArv;
        int peenidreas = read;
       if (andmedSisestusväljalt[2] == 1) { // sisend andmedSisestusväljalt[2] on vajalik selleks, et programm käivituks vaid siis kui andmed on korrektsed
          joonistaPõlluaken(andmedSisestusväljalt);
       }

    }
    private void joonistaPõlluaken(int[]andmedSisestusväljalt) throws Exception {
        VBox aknakast = new VBox();
        HBox jalus = loojalus();
        GridPane peenramaa = joonistapõld(arvutamõõdud(andmedSisestusväljalt), kiri);
        aknakast.getChildren().addAll(peenramaa, jalus);
        Scene põlluaken = new Scene(aknakast, 1005, 600);
        põllumaa.setScene(põlluaken);
        põllumaa.show();

    }




    //joonistab peenraruudustiku
    private GridPane joonistapõld(double[] parameetrid, String põllul) throws Exception {
        //loeb sissetulnud massiivist andmed ja vajadusel teisendab nad intideks
        double laius = parameetrid[0];
        double pikkus = parameetrid[1];
        int read = (int)parameetrid[2];
        int peenradreas = (int)parameetrid[3];
        int viimanerida = (int)parameetrid[4];

        GridPane peenraruudustik = new GridPane();
        peenraruudustik.setStyle("-fx-background-color: DARKGREEN;");
        int järjekorranumber = 0;
        //täidab ruudustiku täiread uute peenardega

        //if (peenradreas == viimanerida) {
            for (int i = 0; i < peenradreas; i++) {
                for (int j = 0; j < (read); j++) {
                    int[] koht = new int[2];
                    koht[0]= i;
                    koht[1]= j;
                    peenar = new Peenar(parameetrid, "tekst", koht, peenraruudustik);
        }

            }
        return peenraruudustik;
    }

        //täidab ruudustiku viimase (teatud juhtudel pooliku) rea uute peenardega
      /*  for (int i = 0; i < viimanerida; i++) {
            int[] koht = new int[2];
            koht[0]= i;
            koht[1]= read;
            peenar = new Peenar(parameetrid, "tekst", koht,  peenraruudustik);
           // peenar.looPeenraAla(parameetrid, peenar.missiinkasvab, i, viimanerida, peenraruudustik);

        } */

   public double[] arvumaatriks(int[] andmedSisestusväljalt) {

       double peenardeArvsee = andmedSisestusväljalt[0] * 1.0;
       int ridadeArvsee = andmedSisestusväljalt[1];
       double ridadeArvD = andmedSisestusväljalt[1]* 1.0;
       double reamaatriks[] = new double[ridadeArvsee];
       double peenraidReassee = Math.ceil(peenardeArvsee / ridadeArvsee);
       double pungil = peenraidReassee * ridadeArvD;


       for (int i = 0; i<ridadeArvsee; i++) {
           reamaatriks[i] = peenraidReassee;
       }
       if (pungil > peenardeArvsee) {
           double jääk = pungil-peenardeArvsee;
           reamaatriks[ridadeArvsee-1] = peenraidReassee-jääk;
       }
       System.out.println(Arrays.toString(reamaatriks));
       return reamaatriks;
   }





   public double[] arvutamõõdud(int[] andmedSisestusväljalt) {
        peenardeArv = andmedSisestusväljalt[0] * 1.0;
        ridadeArv = andmedSisestusväljalt[1] * 1.0;

        // ümardab ritta mineva peenarde arvu üles lähima täisarvuni, et ritta jõuaksid täispeenrad
        peenraidReas = Math.ceil(peenardeArv / ridadeArv);



        // lahutab peenarde koguavust täisritta läinud peenarde arvu
        double viimasesReas = peenardeArv - (peenraidReas * (ridadeArv - 1));

        double peenraPikkus = (PÕLLU_PIKKUS - 2 * (int) PIIRDELAIUS) / ridadeArv;
        double peenraLaius = (PÕLLU_LAIUS - 2 * (int) PIIRDELAIUS) / peenraidReas;

        //koondab kõik tagastatavad andmed ühte massiivi
        double[] peenramõõdud = new double[5];
        peenramõõdud[0] = peenraLaius;
        peenramõõdud[1] = peenraPikkus;
        peenramõõdud[2] = ridadeArv;
        peenramõõdud[3] = peenraidReas;
        peenramõõdud[4] = viimasesReas;

        arvumaatriks(andmedSisestusväljalt);
        return peenramõõdud;
    }




    private HBox loojalus() {
        HBox alumisednupud = new HBox();
        alumisednupud.setSpacing(30);
        Button salvesta = new Button("Salvesta");
        Button sulge = new Button("Sulge");
        sulge.setOnAction(event -> põllumaa.close());
        alumisednupud.getChildren().addAll(salvesta, sulge);
        return alumisednupud;

    }



}


