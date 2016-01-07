import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AvaLeht {
    Stage programm = new Stage();
    Scene küsiandmeid;
    Label sisestapeenrad;
    Label sisestaread;
    Button korjaAndmed;


    AvaLeht() {
        avaAken();
    }


    private void avaAken() {
        programm.setTitle("Peenraplaneerija");

        //lisatekstid
        Label alusta = new Label("LOO OMA PÕLD:");
        sisestapeenrad = new Label("Sisesta peenarde arv");
        sisestaread = new Label("Sisesta ridade arv");

        //sisestusväljad
        TextField peenardeArv = new TextField("Sisesta peenarde arv");
        TextField ridadeArv = new TextField("Sisesta ridade arv");

        //veatekstid
        String ridurohkem = "Peenraid võiks ikka rohkem kui ridu olla";
        String polenumber = "Nii peenarde arv kui read võiksid ikka numbrid olla";

        //nupp
        korjaAndmed = new Button("Hakka pihta");
        korjaAndmed.setOnAction(event -> {
            try {
                Põld minupõld = new Põld(AndmeKonvertija.korjaAndmed(peenardeArv, ridadeArv, ridurohkem, polenumber), "Kliki"); //saadud andmete põhjal joonistab põllumaa
                System.out.println(minupõld.peenardeArv);
            } catch (Exception e) {
                e.printStackTrace();
            }
            programm.close();
        });

        //vasakpool
        VBox vasak = new VBox();
        vasak.setPadding(new Insets(15, 20, 15, 20));
        vasak.setSpacing(5);
        vasak.setMinWidth(200);
        vasak.getChildren().addAll(alusta, peenardeArv, ridadeArv, korjaAndmed);

        //parempool
        VBox parem = new VBox();
        parem.setPadding(new Insets(15, 20, 15, 20));
        parem.setSpacing(10);
        parem.setMinWidth(200);
        Label laepõld = new Label("NÄITA MINU PÕLDU:");
        Button logisisse = new Button("Logi sisse");
        logisisse.setAlignment(Pos.CENTER);
        parem.getChildren().addAll(laepõld, logisisse);

        //avaaken
        VBox avaleht = new VBox();
        avaleht.setStyle("-fx-background-color: GREENYELLOW;");
        avaleht.getChildren().addAll(vasak, parem);



        //seadista esimene vaade ja ava programm
        küsiandmeid = new Scene(avaleht, 200, 275);
        programm.setScene(küsiandmeid);
        programm.show();

    }
}


