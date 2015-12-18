import javafx.scene.shape.Rectangle;

/**
 * Created by liisi on 26.11.2015.
 */
public class Peenar {



    public static void joonista_peenar(int [] andmed) {
        int peenra_Arv = andmed [0];
        int ridade_Arv = andmed [1];
        int PÕLLU_PIKKUS = 800;
        int PÕLLU_LAIUS = 600;
        int peenra_Arv_Reas = peenra_Arv/ridade_Arv;
        int peenra_pikkus = PÕLLU_PIKKUS/peenra_Arv_Reas;
        int peenra_laius =  PÕLLU_LAIUS/peenra_Arv;



        String katse = "Ma olen peenar pikkusega " + peenra_pikkus +  " px ja laiusega " +
                peenra_laius + " px ja mind on ühes reas " + peenra_Arv_Reas + " tükki.";

        System.out.println(katse);


    //asukoht



}
}
