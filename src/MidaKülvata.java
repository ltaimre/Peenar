

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import np.com.ngopal.control.AutoFillTextBox;

import java.util.*;

public class MidaKülvata {

    //Loob akna, kust saab määrata, mida peenrale külvatakse. Saadud andmete põhjal joonistab uue peenraruudu
    MidaKülvata(double[] parameetrid, int rida, int tulp, GridPane väli) throws Exception {
        looAken(parameetrid, väli, rida, tulp);
    }

    public void looAken(double[] parameetrid, GridPane väli, int rida, int tulp) throws Exception {
        Stage külvamisaken = new Stage();
        Scene midakülvata;

        ObservableList data = FXCollections.observableArrayList();
        List<String> juurviljad = AndmeKonvertija.loeFailist("juurviljad.txt");
        for (int j = 0; (j < juurviljad.size() - 1); j++) {
            data.add(juurviljad.get(j));
        }

        /* AutoFill textbox pärineb:
         http://blog.ngopal.com.np/2011/07/04/autofill-textbox-with-filtermode-in-javafx-2-0-custom-control/
          */

        HBox külva = new HBox();
        külva.setSpacing(10);
        final AutoFillTextBox box = new AutoFillTextBox(data);
        Label a = new Label("Mida külvame? ");
        Button salvesta = new Button("Sobib!");
       salvesta.setOnAction(event -> {
            String külvatu = AndmeKonvertija.loeAutoFillkastist(box); //loetakse andmed külvamise sisestuskastist
            Peenar peenar = new Peenar(parameetrid, külvatu, rida, tulp, väli);
            System.out.println(peenar.kohttulbas);
            Peenar.looPeenraAla(parameetrid, külvatu, rida, tulp, väli);
            külvamisaken.close();

        });

        a.translateYProperty().set(5);
        a.translateXProperty().set(5);
        külva.getChildren().addAll(a, box, salvesta);
        midakülvata = new Scene(külva, 300, 100);
        külvamisaken.setScene(midakülvata);
        midakülvata.getStylesheets().add(getClass().getResource("control.css").toExternalForm());
        külvamisaken.show();
    }

}
