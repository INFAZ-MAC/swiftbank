package lk.ijse.hdse77javafx;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Hdse77javafx extends  Application{
    
    private static Scene scene;

    

    @Override
    public void start(Stage stage) throws Exception {
        scene=new Scene(LoadFxml("Layout"),1000,600);
        stage.setScene(scene);
        stage.show();
    }
    public static Parent LoadFxml(String fxml) throws IOException{
        FXMLLoader fxmlloader = new FXMLLoader(Hdse77javafx.class.getResource("/views/"+fxml+".fxml"));
        return fxmlloader.load();
    }
    
    public static void main(String[] args) {
        launch();
    }
}