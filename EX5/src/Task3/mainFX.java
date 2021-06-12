package Task3;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class mainFX extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = new Pane();
			YardenaController controller;
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("yardenaCSS.fxml"));
			root = loader.load();
			controller = loader.getController();
			Scene scene = new Scene(root);
			primaryStage.setTitle("Voting Maching");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
