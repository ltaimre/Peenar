import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.*;

/**
 * Created by Ülle on 27.12.2015.
 */
public class Peenar {

    //joonistab peenraruudu
    public static Rectangle looPeenar(double[] parameetrid) throws Exception {
        double laius = parameetrid[0];
        double pikkus = parameetrid[1];

        Rectangle peenar = new Rectangle(laius, pikkus, Color.SANDYBROWN);
        peenar.setStroke(Color.DARKGREEN);
        peenar.setStrokeWidth(5);
        peenar.setOnMouseClicked(event -> {
            peenar.setFill(Color.LAWNGREEN);
            peenar.setAccessibleText("Hmm!");
            try {
                new MidaKülvata();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        return peenar;
    }

    public static String loenüüd() {
    File f = new File("juurviljad.txt");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = null;
        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (line != null) {
        System.out.println(line);
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }
}
