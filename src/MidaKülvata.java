import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import np.com.ngopal.control.AutoFillTextBox;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Ülle on 27.12.2015.
 */
public class MidaKülvata {

    Stage külvamisaken = new Stage();
    Scene midakülvata;



    MidaKülvata() throws Exception {
        looAken();
    }

    private void looAken() throws Exception {

        ObservableList data = FXCollections.observableArrayList();
        /*String[] s = new String[]{"apple","ball","cat","doll","elephant"};
        for(int j=0; j<s.length; j++) {
            data.add(s[j]);
        }*/

        List<String> juurviljad = AndmeKonvertija.loefailist("juurviljad.txt");
        for(int j=0; (j<juurviljad.size()-1); j++) {
            data.add(juurviljad.get(j));
        }





        HBox külva = new HBox();
        külva.setSpacing(10);
        final AutoFillTextBox box = new AutoFillTextBox(data);
        Label a = new Label("Mida külvame? ");
        Button b = new Button("Sobib!");
        final String[] siinkasvab = new String[1];
        b.setOnAction(event -> {
                    siinkasvab[0] = box.getText();
                    System.out.println(Arrays.toString(siinkasvab));
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
