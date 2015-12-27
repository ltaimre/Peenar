import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import np.com.ngopal.control.AutoFillTextBox;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Ülle on 27.12.2015.
 */
public class MidaKülvata {

    Stage külvamisaken = new Stage();
    Scene midakülvata;



    MidaKülvata(){
        looAken();
    }

    private void looAken() {

        ObservableList data = FXCollections.observableArrayList();
        String[] s = new String[]{"apple","ball","cat","doll","elephant"};
        for(int j=0; j<s.length; j++) {
            data.add(s[j]);
        }

        File f = new File("juurviljad.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));
        String line = br.readLine();
        while (line != null) {
            System.out.println(line);
            line = br.readLine();
        }
        br.close();

        HBox külva = new HBox();
        külva.setSpacing(10);
        final AutoFillTextBox box = new AutoFillTextBox(data);
        Label a = new Label("AutoFillTextBox: ");
        a.translateYProperty().set(5);
        a.translateXProperty().set(5);
        külva.getChildren().addAll(a, box);


        midakülvata = new Scene(külva, 300, 300);
        külvamisaken.setScene(midakülvata);
        midakülvata.getStylesheets().add(getClass().getResource("control.css").toExternalForm());
        külvamisaken.show();




}
}
