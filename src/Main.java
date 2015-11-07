import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Created by Liisi on 7.11.2015.
 */
public class Main extends Application {
    Rectangle rohelineKast = new Rectangle(20, 20, 50, 50);



    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage stage = new Stage();
        stage.setTitle("Minu põld");
        stage.show();
        avaStseen();

    }





    private void avaStseen() {
        BorderPane avaleht = new BorderPane();
        avaleht.setTop(rohelineKast);

    }


}
