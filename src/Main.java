
import javafx.application.Application;
import javafx.stage.Stage;



/**
 * Created by Liisi on 7.11.2015.
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
       new AvaLeht();
        double kolmD = 3.0;
        double kaksD = 2.0;
        int kolmI = 3;
        int kaksI = 2;
        double lahend = kolmD/kaksD;
        double ümardus = kolmD%kaksD;
        double jääk = lahend - ümardus;
    }
}
















