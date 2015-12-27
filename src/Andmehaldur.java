import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.Arrays;

public class Andmehaldur {

        public static int[] korja_andmed(TextField esimene, TextField teine) {
            String peenrad = esimene.getText();
            String read = teine.getText();

            int[] peenraandmed = new int[2];
            try {
                peenraandmed[0] = Integer.parseInt(peenrad);
                peenraandmed[1] = Integer.parseInt(read);

                if (peenraandmed[0] < peenraandmed[1]) {
                    System.out.println("Ridu võiks ikka vähem kui peenraid olla!");
                } else {
                    System.out.println(Arrays.toString(peenraandmed));
                }
            } catch (Exception e) {
                System.out.println("Nii peenarde kui ridade arv võiks ikka number olla!");
            } finally {
                return peenraandmed;
            }

        }

        public static int[] asukohaandmed (GridPane ruudustik, Node element) {
            int[] asukohaindeks = new int[2];
            asukohaindeks[0]= ruudustik.getRowIndex(element);
            asukohaindeks[1]= ruudustik.getColumnIndex(element);
            return asukohaindeks;
        }
}

