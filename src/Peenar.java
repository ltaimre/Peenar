

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Peenar {
    double[] mõõdud;
    String missiinkasvab = "kliki ja külva";
    GridPane asukoht;
    int kohtreas;
    int kohttulbas;
    double laius;
    double pikkus;
    int peenranumber;



    Peenar (double[] parameetrid, String tekst, int rida, int tulp, GridPane sihtkoht) {
        mõõdud = parameetrid;
        missiinkasvab = tekst;
        kohtreas = rida;
        kohttulbas = tulp;
        asukoht = sihtkoht;
        peenranumber = kohtreas + 1 * kohttulbas;
    }

    //joonistab peenrakasti põhjal peenraala, millele on võimalik lisada
    public static void looPeenraAla(double[] parameetrid, String tekst, int rida, int tulp, GridPane sihtkoht) {
        double laius = parameetrid[0];
        double pikkus = parameetrid[1];
        Rectangle peenar1 = new Rectangle(laius, pikkus, Color.SANDYBROWN);
        peenar1.setStroke(Color.DARKGREEN);
        peenar1.setStrokeWidth(5);



        Label siinkasvab = new Label(tekst);
        StackPane peenraala = new StackPane(peenar1, siinkasvab);
        peenraala.setOnMouseClicked(event -> {
            peenar1.setFill(Color.LAWNGREEN);
          try {
                new MidaKülvata(parameetrid, rida, tulp, sihtkoht);

            } catch (Exception e) {
                e.printStackTrace();
            }

        });
       sihtkoht.add(peenraala, rida, tulp);
    }





    }
