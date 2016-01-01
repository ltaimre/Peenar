import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by Ülle on 27.12.2015.
 */
public class Peenar {

    //joonistab peenraruudu
    public static Rectangle looPeenar(double[] parameetrid) {
        double laius = parameetrid[0];
        double pikkus = parameetrid[1];

        Rectangle peenar = new Rectangle(laius, pikkus, Color.SANDYBROWN);
        peenar.setStroke(Color.DARKGREEN);
        peenar.setStrokeWidth(5);
        peenar.setOnMouseClicked(event -> {
            peenar.setFill(Color.LAWNGREEN);
            peenar.setAccessibleText("Hmm!");
            new MidaKülvata();
        });

        return peenar;
    }
}
