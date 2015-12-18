
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



/**
 * Created by ltaimre on 12.12.15.
 */
public class Andmeaken {
    Stage programm = new Stage();
    Scene stseen1, stseen2;

    Andmeaken () {
        System.out.println("ANDMEAKEN");
        avaaken();

    }



    public void avaaken()  {
        System.out.println("AVAAKEN");
        programm.setTitle("Minu põld");

        /* Esimesel aknal olevad elemendid */
        Label tervitustekst = new Label("Teretulemast!");
        Label rida1 = new Label("Sisesta peenarde arv");
        Label rida2 = new Label("Sisesta ridade arv");

        /*sisestusread*/
        TextField peenardeArv = new TextField();
        TextField ridadeArv = new TextField();

        /*sisendi kättesaamine ja intiks tegemine */
        //String sisestusväli1 = peenardeArv.getText();
       //  int peenrad = Integer.parseInt(sisestusväli1);
        //String sisestusväli2= ridadeArv.getText();
        //int read = Integer.parseInt(sisestusväli2);


        /*sisendi kättesaamine, katse 2 */

     //   String katse = "123";
       // int read = Integer.parseInt(katse);
        //System.out.println(read);
        //int peenrad = Integer.parseInt(ridadeArv.getText());


        /*nupp, mis genereerib peenra */
        Button olulineNupp = new Button("Hakka pihta");
        olulineNupp.setOnAction(event -> {
            Põld.korja_andmed(peenardeArv, ridadeArv);
            //String sisestusväli1 = peenardeArv.getText();
            //String sisestusväli2= ridadeArv.getText();
            //System.out.println(sisestusväli1);



        });




         /*nupp, mis avab uue akna*/
        Button nupp = new Button("Teineaken");
        nupp.setOnAction(event -> TeeValik.display("Pealisaken", "Sain hakkama?"));



        /*lisan elemendid esimesele aknale */
        VBox avaleht = new VBox();
        avaleht.getChildren().addAll(tervitustekst, rida1, peenardeArv, rida2, ridadeArv, olulineNupp, nupp);



        /*Teise akna elemendid*/
        Button nupp2 = new Button("Tagasi avalehele");
        nupp2.setOnAction(event -> programm.setScene(stseen1));




        /*Esimese akna parameetrid */
        stseen1 = new Scene(avaleht, 500,500);
        programm.setScene(stseen1);
        programm.show();


        /*Teise akna parameetrid */
        StackPane teineleht = new StackPane();
        teineleht.getChildren().addAll(nupp2);
        stseen2 = new Scene(teineleht, 600, 300);




    }






}
