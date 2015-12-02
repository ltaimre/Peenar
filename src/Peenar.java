/**
 * Created by liisi on 26.11.2015.
 */
public class Peenar {
    private double pikkus;
    private double laius;
    private boolean haritus;
    private String sisu;
    //asukoht

    public Peenar(double pPikkus, double pLaius, boolean algseis, String sisu){
    pikkus = pPikkus;
    laius = pLaius;
        haritus = algseis;
        sisu = "tühi";
    }

    public String kasOnHaritud() {
        String a = "Siin juba kasvab";
        if (haritus == true) {
            a = a;
        }
        else {
            a = "Istuta midagi";
        }
        return a;

    }

    public String misKasvab() {
        System.out.println("prindi midagigi");
        System.out.println(sisu);
        return sisu;
    }


}
