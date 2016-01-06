import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import np.com.ngopal.control.AutoFillTextBox;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liisi on 29.12.2015.
 */
public class AndmeKonvertija { //klass erinevate abimeetoditega, peamiselt andmetöötluseks

    //meetod, mis loeb tekstfieldedist teksti ja tagastab neist andmetest massiivi.
    public static int[] korja_andmed(TextField esimene, TextField teine) {
        String peenrad = esimene.getText();
        String read = teine.getText();
        int[] peenraandmed = new int[3];
        peenraandmed[2] = 0;
        try {
            peenraandmed[0] = Integer.parseInt(peenrad);
            peenraandmed[1] = Integer.parseInt(read);
            if (peenraandmed[0] < peenraandmed[1]) {
                new VeaAken("Ridu võiks ikka vähem kui peenraid olla!"); //juhuks kui kasutaja sisestab rohkem ridu kui tal peenraid on
            }else {
                peenraandmed[2] = 1; //kui on õnnestunud andmed vigadeta kätte saada, on massiivi 3 number 1 ja joonistatakse aken.
            }
        } catch (NumberFormatException e) {
            new VeaAken("Nii peenarde kui ridade arv võiks ikka number olla!");
        } finally {
            return peenraandmed;

        }

    }


    //nummerdab gridpanes olevad peenrad
    public static int asukohaandmed (int rida, int tulp) {
        int reanumber = rida;
        int tulbanumber = tulp;
        int asukoht = rida * tulp;
        System.out.println(asukoht);
        return asukoht;
    }

    //meetod failist andmete kättesaamiseks
    public static List<String> loefailist(String failinimi) throws Exception {
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
    public static String loeAutoFillkastist (AutoFillTextBox kast) {
        String kasv = kast.getText();
        return kasv;

    }


}



