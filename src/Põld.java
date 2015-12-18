import javafx.scene.control.TextField;

import java.util.Arrays;

/**
 * Created by liisi on 26.11.2015.
 */
public class Põld {

    public static int[] korja_andmed(TextField esimene, TextField teine) {
        String peenrad = esimene.getText();
        String read = teine.getText();

        int[] peenraandmed = new int[2];
        try {
            peenraandmed[0] = Integer.parseInt(peenrad);
            peenraandmed[1] = Integer.parseInt(read);

            if (peenraandmed[0] < peenraandmed[1]) { //ridade arv ei tohi olla suurem kui peenarde arv
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


    public static void joonista_peenar(int [] andmed) {
        int peenra_Arv = andmed [0]; //tegelt tuleb sisend kasutajalt, praegu lihtsalt katsetuseks
        int ridade_Arv = andmed [1];//tegelt tuleb sisend kasutajalt, praegu lihtsalt katsetuseks
        int PÕLLU_PIKKUS = 800;
        int PÕLLU_LAIUS = 600;


        int peenra_Arv_Reas = peenra_Arv/ridade_Arv;
        int peenra_pikkus = PÕLLU_PIKKUS/peenra_Arv_Reas;
        int peenra_laius =  PÕLLU_LAIUS/peenra_Arv;

        String katse = "Ma olen peenar pikkusega " + peenra_pikkus +  " px ja laiusega " +
                peenra_laius + " px ja mind on ühes reas " + peenra_Arv_Reas + " tükki.";

        System.out.println(katse);



    }







}
