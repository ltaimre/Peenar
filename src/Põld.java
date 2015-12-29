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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Created by Ülle on 27.12.2015.
 * http://blog.ngopal.com.np/2011/07/04/autofill-textbox-with-filtermode-in-javafx-2-0-custom-control/
 *
 */
public class Põld {

    Stage põllumaa = new Stage();
    Scene peenravaade;

    double PIIRDELAIUS = 5;
    double PÕLLU_PIKKUS = 500;
    double PÕLLU_LAIUS = 1000;
    double täisridade_arv;

    Põld(int[] a) {
        System.out.println(a[2]);

        if (a[2] == 1) {

        double [] mõõdud = arvutamõõdud(a);
        Scene põllujoonis = joonistapõld(mõõdud);
        põllumaa.setScene(põllujoonis);
        põllumaa.show();
        }
        else {
            System.out.println("ERROR!");
        }

    }


    private Scene joonistapõld(double[] parameetrid) {
        double laius = parameetrid[0];
        double pikkus = parameetrid[1];
        int read = (int) parameetrid[2];
        int peenradreas = (int)parameetrid[3];
        int viimanerida = (int)parameetrid[4];

        System.out.println(read + " joonistajaklassi ridadearv");
        System.out.println(peenradreas + " joonistajaklassi täisread");

        GridPane peenraruudustik = new GridPane();


        for (int i = 0; i < peenradreas; i++) {
            for (int j = 0; j < read; j++) {
                Rectangle peenar = new Rectangle(laius, pikkus, Color.BLUE);
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
                peenraruudustik.add(peenar, i, j);
                peenraruudustik.add(panekasvama, i, j);
            }
        }
       if (viimanerida > 0)  {
            for (int i = 0; i <viimanerida; i++) {
                Rectangle peenar = new Rectangle(laius, pikkus, Color.BLUE);
                peenraruudustik.add(peenar, i , read+1);
            }
        }


        peenravaade = new Scene(peenraruudustik, 1005, 600);
        return peenravaade;
    }

    private double[] arvutamõõdud(int [] andmed) {
        double viimanerida = 0;
        double peenra_Arv = andmed [0] * 1.0;
        double täisridade_arv = andmed [1] * 1.0;


        double jääk = peenra_Arv%täisridade_arv;
        System.out.println(jääk + " see, mis jääb üle");
        double terveRida = peenra_Arv - jääk;
        System.out.println(terveRida + " selle põhjalt arvutame terve rea peenrad");
        double tervereapeenrad = täisridade_arv - 1.0;
        System.out.println(tervereapeenrad + " niipalju on täisridu");
        double peenra_Arv_Reas = (terveRida/tervereapeenrad);
        System.out.println(peenra_Arv_Reas + " peenraarv reas");

        if (jääk > 0) {
            System.out.println(" ridade arv if funktsioonis " + täisridade_arv);
            täisridade_arv = täisridade_arv - 1;
            System.out.println(täisridade_arv + "lahutasin ühe");
            viimanerida = peenra_Arv_Reas - jääk;
        }


        double peenra_pikkus = (PÕLLU_PIKKUS - 2 * (int)PIIRDELAIUS)/täisridade_arv;
        double peenra_laius =  (PÕLLU_LAIUS - 2 * (int)PIIRDELAIUS)/peenra_Arv_Reas;
        double[] peenramõõdud = new double[5];
        peenramõõdud[0] = peenra_laius;
        peenramõõdud[1] = peenra_pikkus;
        peenramõõdud[2] = täisridade_arv;
        System.out.println(peenramõõdud[2] + "arvutuste järgi ridu");
        peenramõõdud[3] = peenra_Arv_Reas;
        System.out.println(peenramõõdud [3] + " reas asju");
        peenramõõdud[4] = viimanerida;
        System.out.println(peenramõõdud[4] + " viimases reas peenraid");

        return peenramõõdud;

    }


}
