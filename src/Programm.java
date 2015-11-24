/**
 * Created by liisi on 21.11.2015.
 */

public class Programm {



    public static int joonistaPeenar() {

        int pollu_laius = 300;
        int pollu_pikkus = 700;
        int ridade_arv = 3;
        int peenarde_arv = 20;

        int peenra_laius = pollu_laius/ridade_arv;
        int peenarde_arv_reas = pollu_laius/ (peenarde_arv /ridade_arv) ;
        int peenra_pikkus = pollu_pikkus / peenarde_arv_reas;

        return peenra_laius;


    };



    };


