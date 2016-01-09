import com.sun.corba.se.spi.ior.ObjectKey;
import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import np.com.ngopal.control.AutoFillTextBox;

import javax.imageio.ImageIO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AndmeKonvertija { //klass erinevate abimeetoditega, peamiselt andmetöötluseks

    //meetod, mis loeb tekstfieldist teksti ja tagastab neist andmetest massiivi.
    public static int[] korjaAndmed(TextField esimene, TextField teine, String veatekst1, String veatekst2) {
        String esimeseltrealt = esimene.getText();
        String teiselttrealt = teine.getText();
        int[] andmed = new int[3];
        andmed[2] = 0;
        try {
            andmed[0] = Integer.parseInt(esimeseltrealt);
            andmed[1] = Integer.parseInt(teiselttrealt);
            if (andmed[0] < andmed[1]) {
                new VeaAken(veatekst1); //juhuks kui kasutaja sisestab rohkem ridu kui tal peenraid on
            } else {
                andmed[2] = 1; //kui on õnnestunud andmed vigadeta kätte saada, on saab kolmanda liikme väärtuseks 1, mis lubab joonistada põlluakna.
            }
        } catch (NumberFormatException e) {
            new VeaAken(veatekst2);
        } finally {
            return andmed;

        }

    }

    //meetod failist andmete kättesaamiseks
    public static List<String> loeFailist(String failinimi) throws Exception {
        List<String> nimekiri = new ArrayList<>();
        File minufail = new File(failinimi);
        BufferedReader lugeja = new BufferedReader(new FileReader(minufail));
        String rida = lugeja.readLine();
        while (rida != null) {
            rida = lugeja.readLine();
            nimekiri.add(rida);
        }
        lugeja.close();
        return nimekiri;
    }

    //meetod AutoFillkastist andmete kättesaamieks
    public static String loeAutoFillkastist(AutoFillTextBox kast) {
        String tekstkastist = kast.getText();
        return tekstkastist;

    }

    public static void salvestaPilt(GridPane ala) {
        WritableImage snapshot = ala.getScene().snapshot(null);
        File file = new File("minupeenrad.png");
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", file);
        } catch (IOException e) {
        }
    }

}








