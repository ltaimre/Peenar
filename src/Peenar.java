import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by liisi on 6.01.2016.
 */
public class Peenar {

    Peenar(double[] andmed){
        looPeenraAla(looPeenar(andmed), "Kliki ja külva");

           }
        //joonistab peenraruudu
        public static Rectangle looPeenar(double[] parameetrid)  {
             double laius = parameetrid[0];
            double pikkus = parameetrid[1];
            Rectangle peenar = new Rectangle(laius, pikkus, Color.SANDYBROWN);
            peenar.setStroke(Color.DARKGREEN);
            peenar.setStrokeWidth(5);
          return peenar;
        }

        public static StackPane looPeenraAla(Rectangle ruut, String tekst) {
            Label siinkasvab = new Label(tekst);
            StackPane peenraala = new StackPane(ruut, siinkasvab);

            return peenraala;
        }
}