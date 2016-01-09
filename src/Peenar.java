
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Peenar {
    double[] mõõdud;
    String missiinkasvab;
    GridPane asukoht;
    int[] kohtpõllul;
    Boolean kaskülvatud;


    Peenar(double[] parameetrid, Boolean külv, String tekst, int[] kohaindeks, GridPane sihtkoht) {
        mõõdud = parameetrid;
        missiinkasvab = tekst;
        kohtpõllul = kohaindeks;
        asukoht = sihtkoht;
        kaskülvatud = külv;
        looPeenraAla(mõõdud, kaskülvatud, missiinkasvab, kohaindeks, sihtkoht);
    }

    //joonistab peenrakasti põhjal peenraala, kuspeal kuvatakse ka see, mis seal kasvab
    public static void looPeenraAla(double[] parameetrid, Boolean kasvab, String tekst, int[] indeks, GridPane sihtkoht) {
        Rectangle peenar1 = new Rectangle(parameetrid[0], parameetrid[1], Color.SANDYBROWN);
        if (kasvab == true ) {
            peenar1.setFill(Color.YELLOWGREEN);
        }
        peenar1.setStroke(Color.DARKGREEN);
        peenar1.setStrokeWidth(5);

        Label siinkasvab = new Label(tekst);
        siinkasvab.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        StackPane peenraala = new StackPane(peenar1, siinkasvab);
        peenraala.setOnMouseClicked(event -> {
            peenar1.setFill(Color.LAWNGREEN);
            try {
                new MidaKülvata(parameetrid, indeks, sihtkoht);

            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        sihtkoht.add(peenraala, indeks[0], indeks[1]);
    }

}

