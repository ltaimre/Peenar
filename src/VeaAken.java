import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class VeaAken {
    Stage hoiatusaken = new Stage();
    Scene hoiatuseks;
    Label hoiatussilt;
    Button suleaken;

    VeaAken(String tekst) {

        looAken(tekst);
    }

    private void looAken(String tekst) {
        String hoiatustekst = tekst;
        hoiatussilt = new Label(hoiatustekst);
        hoiatussilt.setFont(Font.font("Verdana", 12));
        suleaken = new Button("Sain aru!");
        suleaken.setOnAction(event -> {
                    hoiatusaken.close();
                    new AvaLeht();
                }
        );

        StackPane aken = new StackPane();
        aken.setAlignment(suleaken, Pos.BOTTOM_CENTER);
        aken.setStyle("-fx-background-color: GREENYELLOW;");
        Insets piirid = new Insets(10, 10, 10, 10);
        aken.setPadding(piirid);
        aken.getChildren().addAll(hoiatussilt, suleaken);
        hoiatuseks = new Scene(aken, 300, 100);
        hoiatusaken.setScene(hoiatuseks);
        hoiatusaken.show();


    }
}
