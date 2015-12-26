import javafx.scene.control.TextField;
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
                joonista_peenar(peenraandmed);
                return peenraandmed;
            }

        }

    public static double[] joonista_peenar(int [] andmed) {
        int peenra_Arv = andmed [0];
        int ridade_Arv = andmed [1];
        int PÕLLU_PIKKUS = 800;
        int PÕLLU_LAIUS = 600;
        int peenra_Arv_Reas = peenra_Arv/ridade_Arv;
        int peenra_pikkus = PÕLLU_PIKKUS/peenra_Arv_Reas;
        int peenra_laius =  PÕLLU_LAIUS/peenra_Arv;
        double[] peenraparameetrid = new double[2];
        peenraparameetrid[0] = peenra_laius * 1.0;
        peenraparameetrid[1] = peenra_pikkus * 1.0;

        String katse = "Ma olen peenar pikkusega " + peenra_pikkus +  " px ja laiusega " +
                peenra_laius + " px ja mind on ühes reas " + peenra_Arv_Reas + " tükki.";

        System.out.println(katse);
        return peenraparameetrid;
    }
    }


