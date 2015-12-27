import com.sun.org.apache.xpath.internal.operations.And;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Arrays;

/**
 * Created by Ülle on 27.12.2015.
 */
public class Põld {

    Stage põllumaa = new Stage();
    Scene peenravaade;

    Põld(int[] a) {

        double [] mõõdud = arvutamõõdud(a);
        Scene põllujoonis = joonistapõld(mõõdud);
        põllumaa.setScene(põllujoonis);

        põllumaa.show();

    }


    private Scene joonistapõld(double[] parameetrid) {
        double laius = parameetrid[0];
        double pikkus = parameetrid[1];
        int read = (int) parameetrid[2];
        int peenradreas = (int)parameetrid[3];




        GridPane peenraruudustik = new GridPane();


        for (int i = 0; i < peenradreas; i++) {
            for (int j = 0; j < read; j++) {
                Rectangle peenar = new Rectangle(laius, pikkus, Color.BLUE);
                Button külva = new Button("Mida külvame?");
                külva.setAlignment(Pos.BOTTOM_CENTER);
                peenar.setStroke(Color.RED);
                peenar.setStrokeWidth(10);
                peenar.setOnMouseClicked(event -> {
                    peenar.setStroke(Color.BLACK);
                    new MidaKülvata();
                    System.out.println("Saab kasvama panna");
                    System.out.println(Arrays.toString(Andmehaldur.asukohaandmed(peenraruudustik, peenar)));

                });
                peenraruudustik.add(peenar, i, j);
                peenraruudustik.add(külva, i, j);
            }
        }

        peenravaade = new Scene(peenraruudustik, 1000, 600);
        return peenravaade;
    }

    private double[] arvutamõõdud(int [] andmed) {
        int peenra_Arv = andmed [0];
        int ridade_Arv = andmed [1];
        int PÕLLU_PIKKUS = 500;
        int PÕLLU_LAIUS = 1000;
        int peenra_Arv_Reas = peenra_Arv/ridade_Arv;
        int peenra_pikkus = PÕLLU_PIKKUS/peenra_Arv_Reas;
        int peenra_laius =  PÕLLU_LAIUS/peenra_Arv;
        double[] peenramõõdud = new double[4];
        peenramõõdud[0] = peenra_laius * 1.0;
        peenramõõdud[1] = peenra_pikkus * 1.0;
        peenramõõdud[2] = ridade_Arv * 1.0;
        peenramõõdud[3] = peenra_Arv_Reas * 1.0;


        String katse = "Ma olen peenar pikkusega " + peenra_pikkus +  " px ja laiusega " +
                peenra_laius + " px ja mind on ühes reas " + peenra_Arv_Reas + " tükki.";

        System.out.println(katse);
        return peenramõõdud;

    }


}
