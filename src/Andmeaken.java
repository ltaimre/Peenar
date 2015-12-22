
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;



/**
 * Created by ltaimre on 12.12.15.
 */
public class Andmeaken {
    Stage programm = new Stage();
    Scene stseen1, stseen2, uusstseen;

    Andmeaken () {
        System.out.println("ANDMEAKEN");
        avaaken();

    }



    public void avaaken()  {
        System.out.println("AVAAKEN");
        programm.setTitle("Minu põld");
        //Image p6llupilt = new Image("/p6ld.jpg");

        /* Esimesel aknal olevad elemendid */
        Label tervitustekst = new Label("Teretulemast!");
       // BackgroundImage taustapilt = new BackgroundImage (p6llupilt, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
               // BackgroundSize.DEFAULT);
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


        /*nupp, mis genereerib peenra  */
        Button olulineNupp = new Button("Hakka pihta");
        olulineNupp.setOnAction(event -> {
            Põld.korja_andmed(peenardeArv, ridadeArv);
            //String sisestusväli1 = peenardeArv.getText();
            //String sisestusväli2= ridadeArv.getText();
            //System.out.println(sisestusväli1);



        });






        /*nupp, mis avab uue akna */
        Button nupp = new Button("Teineaken");
        //nupp.setOnAction(event -> TeeValik.display("Pealisaken", "Sain hakkama?"));
       // nupp.setOnAction(event1 -> Peenraaken.näitapeenraid());

        nupp.setOnAction(event1 -> new Peaaken());


        Button nupp2 = new Button("Vaheta akent");
      //  nupp2.setOnAction(event1 -> programm.setScene(uusstseen));


        /*lisan elemendid esimesele aknale */
        VBox avaleht = new VBox();
       // avaleht.setBackground(new Background(taustapilt));
        avaleht.getChildren().addAll(tervitustekst, rida1, peenardeArv, rida2, ridadeArv,  nupp, olulineNupp );



        /*Teise akna elemendid*/
        Button nupp3 = new Button("Tagasi avalehele");
        nupp3.setOnAction(event -> programm.setScene(stseen1));

        // kolmanda aknda elemendid
        VBox kolmasaken = new VBox();
        Label jee = new Label("Ma vahetasin stseeni");
        kolmasaken.getChildren().add(jee);





        /*Esimese akna parameetrid */
        stseen1 = new Scene(avaleht, 500, 500);
        programm.setScene(stseen1);
        programm.show();


        /*Teise akna parameetrid */
        StackPane teineleht = new StackPane();
        teineleht.getChildren().addAll(nupp2);
        stseen2 = new Scene(teineleht, 600, 300);

        //Kolmas aken
        uusstseen = new Scene(kolmasaken, 500, 500);












}
}
