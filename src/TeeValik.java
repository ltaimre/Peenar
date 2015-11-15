/**
 * Created by Liisi  on 15.11.2015.
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;



public class TeeValik {

    public static void display(String title, String message) {
        Stage aken = new Stage();
        aken.initModality(Modality.APPLICATION_MODAL);
        //aken.setScene("Pane kirja!");
        aken.setMinWidth(400);

        Label teadaanne = new Label("Tee, mis tahad!");
        Button paneKinni = new Button("Pane kinni");
        paneKinni.setOnAction(event -> aken.close());

        VBox vaade = new VBox(10);
        vaade.getChildren().addAll(teadaanne, paneKinni);
        vaade.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vaade);
        aken.setScene(scene);
        aken.showAndWait();

    }

}
