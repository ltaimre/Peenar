import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import np.com.ngopal.control.AutoFillTextBox;

import java.util.*;

public class MidaKülvata {



    MidaKülvata(double[] üks, GridPane koht, int rida, int tulp) throws Exception {

        looAken(üks, koht, rida, tulp);



    }

    public void looAken(double[] üks, GridPane koht, int rida, int tulp) throws Exception {
        Stage külvamisaken = new Stage();
        Scene midakülvata;

        ObservableList data = FXCollections.observableArrayList();
        List<String> juurviljad = AndmeKonvertija.loefailist("juurviljad.txt");
        for(int j=0; (j<juurviljad.size()-1); j++) {
            data.add(juurviljad.get(j));
        }


        HBox külva = new HBox();
        külva.setSpacing(10);
        final AutoFillTextBox box = new AutoFillTextBox(data);
        Label a = new Label("Mida külvame? ");
        Button b = new Button("Sobib!");
        b.setOnAction(event -> {
                String eh = AndmeKonvertija.loeAutoFillkastist(box);
                Rectangle p = Peenar.looPeenar(üks);
                StackPane pa = Peenar.looPeenraAla(p, eh);
                pa.setOnMouseClicked(event1 -> {
                try {
                        new MidaKülvata(üks, koht, rida, tulp);
                    } catch (Exception e) {
                  e.printStackTrace();
                 }
                    koht.add(pa, rida, tulp);
                        }
                    );
        koht.add(pa, rida, tulp);
        külvamisaken.close();
        });

        a.translateYProperty().set(5);
        a.translateXProperty().set(5);
        külva.getChildren().addAll(a, box, b);


        midakülvata = new Scene(külva, 300, 100);
        külvamisaken.setScene(midakülvata);
        midakülvata.getStylesheets().add(getClass().getResource("control.css").toExternalForm());
        külvamisaken.show();
}

}
