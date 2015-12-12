import javafx.scene.control.TextField;

/**
 * Created by liisi on 26.11.2015.
 */
public class Põld {


    public static void joonista_peenar() {
        int peenra_Arv = 12; //tegelt tuleb sisend kasutajalt, praegu lihtsalt katsetuseks
        int ridade_Arv = 3; //tegelt tuleb sisend kasutajalt, praegu lihtsalt katsetuseks
        int PÕLLU_PIKKUS = 800;
        int PÕLLU_LAIUS = 600;


        int peenra_Arv_Reas = peenra_Arv/ridade_Arv;
        int peenra_pikkus = PÕLLU_PIKKUS/peenra_Arv_Reas;
        int peenra_laius =  PÕLLU_LAIUS/peenra_Arv;

        String katse = "Ma olen peenar pikkusega " + peenra_pikkus +  " px ja laiusega " +
                peenra_laius + " px ja mind on ühes reas " + peenra_Arv_Reas + " tükki.";

        System.out.println(katse);



    }

    public static String korja_andmed(TextField m) {
        String kasutajatekst = m.getText();
        System.out.println(kasutajatekst);

        return kasutajatekst;


    }





}
