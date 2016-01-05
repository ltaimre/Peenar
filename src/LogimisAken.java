import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by liisi on 5.01.2016.
 */
public class LogimisAken {
    TextField kasutajanimi;
    PasswordField parool;
    Button loginButton;
    Button registerButton;
    Stage stage = new Stage();

    LogimisAken() {
        setupScene();
        setupLogin();
        setupRegister();
    }

    private void setupScene() {
        VBox vbox = new VBox();
        Scene scene = new Scene(vbox);

        Label l1 = new Label("Kasutajanimi");
        kasutajanimi = new TextField();
        Label l2 = new Label("Parool");
        parool = new PasswordField();
        loginButton = new Button("logi sisse");
        registerButton = new Button("registreeri");
        vbox.getChildren().addAll(l1, kasutajanimi, l2, parool, loginButton, registerButton);

        stage.setScene(scene);
        stage.show();
    }

    private void setupLogin() {
        loginButton.setOnAction(event -> {
            String nimi = kasutajanimi.getText();
            String p = parool.getText();
            Andmebaas a = new Andmebaas();
            boolean result = a.login(nimi, p);
            a.sulgeYhendus();
            if (result) {
                KasutajaAndmed ud = new KasutajaAndmed(nimi);
                stage.close();
            }
        });
    }

    private void setupRegister() {
        registerButton.setOnAction(event -> {
            String nimi = kasutajanimi.getText();
            String p = parool.getText();
            Andmebaas a = new Andmebaas();
            a.registreeriKasutaja(nimi, p);
            a.sulgeYhendus();
        });
    }
}
