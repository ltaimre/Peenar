

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Andmeaken {
    Stage programm = new Stage();
    Scene küsiandmeid;

    Andmeaken () {
        avaaken();
    }


    public void avaaken()  {
        programm.setTitle("Peenraplaneerija");

        //lisatekstid
        Label sisestapeenrad = new Label("Sisesta peenarde arv");
        Label sisestaread = new Label("Sisesta ridade arv");

        //sisestusväljad
        TextField peenardeArv = new TextField();
        TextField ridadeArv = new TextField();

        //nupp
        Button korjaAndmed = new Button("Hakka pihta");
        korjaAndmed.setOnAction(event -> {
            Andmehaldur.korja_andmed(peenardeArv, ridadeArv);
        });

        //ajutine nupp stseenivahetuseks
        Button abiNupp = new Button("Hakka joonisama!");
        abiNupp.setOnAction(event -> new Andmeaken.Peaaken());

        //kujundus
        VBox avaleht = new VBox();
        avaleht.getChildren().addAll(sisestapeenrad, peenardeArv, sisestaread, ridadeArv, korjaAndmed, abiNupp );

        //seadista esimene vaade ja ava programm
        küsiandmeid = new Scene(avaleht, 500, 500);
        programm.setScene(küsiandmeid);
        programm.show();

        //teine vaade












}
}
