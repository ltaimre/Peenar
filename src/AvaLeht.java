import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by liisi on 29.12.2015.
 */
public class AvaLeht {
    Stage programm = new Stage();
    Scene küsiandmeid;

    AvaLeht() {
        avaAken();
    }


    private void avaAken()  {
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
            int[] a = AndmeKonvertija.korja_andmed(peenardeArv, ridadeArv);
            try {
                new Põld(a);
            } catch (Exception e) {
                e.printStackTrace();
            }
            programm.close();
        });

        //kujundus
        VBox avaleht = new VBox();
        avaleht.getChildren().addAll(sisestapeenrad, peenardeArv, sisestaread, ridadeArv, korjaAndmed);

        //seadista esimene vaade ja ava programm
        küsiandmeid = new Scene(avaleht, 1000, 600);
        programm.setScene(küsiandmeid);
        programm.show();

    }
}


