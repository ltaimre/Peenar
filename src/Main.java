import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Created by Liisi on 7.11.2015.
 */
public class Main extends Application {

    Stage programm;
    Scene stseen1, stseen2;

    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void start(Stage primaryStage) throws Exception  {
        programm = primaryStage;
        programm.setTitle("Minu põld");

        Label tervitustekst = new Label("Teretulemast!");
        Button nupp = new Button("Loo oma põld");
        nupp.setOnAction(event -> TeeValik.display("Pealisaken", "Sain hakkama?"));

        Button nupp2 = new Button("Tagasi avalehele");
        nupp2.setOnAction(event -> programm.setScene(stseen1));

        VBox avaleht = new VBox();
        avaleht.getChildren().addAll(tervitustekst, nupp);


        stseen1 = new Scene(avaleht, 300,250);
        programm.setScene(stseen1);
        programm.show();

        StackPane teineleht = new StackPane();
        teineleht.getChildren().addAll(nupp2);
        stseen2 = new Scene(teineleht, 600, 300);
       // küsiKasutajalt();//


        kasPeenartöötab();

    }

    public void mituOnreas()
    public void kasPeenartöötab () {
        Peenar esimeneP = new Peenar(2, 3, true, "porgand");

        System.out.println(esimeneP.kasOnHaritud());
        System.out.println("niisama prindid?");

    }


}












