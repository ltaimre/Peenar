/**
 * Created by liisi on 21.11.2015.
 */
public class Objekt {
    int pikkus = 10;
    int laius = 20;
    String staatus = "tühi";

    public void istuta() {
        if (staatus == "tühi") {
            staatus = "istutatud";
        }
        else {
            System.out.println("Siin juba on taim. Kas sa tahad midagi muud panna?");
                    // ja ideaalis võiks ta nüüd kasutaja käest küsida, et mis värk on.
        };


    };
}
