import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
        VBox külva = new VBox();
        ChoiceBox cb = new ChoiceBox(FXCollections.observableArrayList(
                "Esimene", "Teine", "Kolmas")
        );
        cb.getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        (ObservableValue observable, Object oldValue, Object newValue) -> {
                            // Do stuff
                            System.out.println(newValue);
                        });
        külva.getChildren().add(cb);
        midakülvata = new Scene(külva, 300, 300);
        külvamisaken.setScene(midakülvata);
        külvamisaken.show();

    }
}
