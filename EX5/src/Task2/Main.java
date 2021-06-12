package Task2;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class Main extends Application {
	private int counter = 0;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox root = new VBox();
			HBox buttons = new HBox();
			Button yardena = new Button("Yardena Arazi");
			Button ofra = new Button("Ofra Hava");
			Image questionMark = new Image("http://www.mazor-law.co.il/wp-content/uploads/2019/12/question-mark.png");
			Image Of = new Image("https://img.mako.co.il/2020/08/14/KHKADAD506_i.jpg");
			Image yar = new Image("https://yt3.ggpht.com/ytc/AAUvwnjwETzDEFrFfFXHXCMh-cI2FmdHa1wRNTck2N8w=s900-c-k-c0x00ffffff-no-rj");
			ImageView imageView = new ImageView(questionMark);
			imageView.setX(10);
		    imageView.setY(10);
		    imageView.setFitWidth(120);
		    imageView.setFitHeight(120);
			Label label = new Label("0");
			label.setText(""+counter);
			root.setPrefWidth(400);
			root.setPrefHeight(200);
			root.setAlignment(Pos.CENTER);
			root.setPadding(new Insets(10));
			buttons.setSpacing(40);
			ofra.setPrefWidth(100);
			yardena.setPrefWidth(100);
			ofra.setPrefHeight(50);
			yardena.setPrefHeight(50);
			buttons.getChildren().addAll(ofra,imageView,yardena);
			root.getChildren().addAll(buttons, label);
			
			class counterIncrease implements EventHandler<ActionEvent>{
				@Override
				public void handle(ActionEvent event) {
					counter++;
					if(counter > 0)
						imageView.setImage(Of);
					if(counter == 0)
						imageView.setImage(questionMark);
					label.setText(""+counter);
				}
			}
			
			class counterDecrease implements EventHandler<ActionEvent>{
				@Override
				public void handle(ActionEvent event) {
					counter--;
					if(counter < 0)
						imageView.setImage(yar);
					if(counter == 0)
						imageView.setImage(questionMark);
					label.setText(""+counter);
				}
			}
			ofra.setOnAction(new counterIncrease());
			yardena.setOnAction(new counterDecrease());
			label.setStyle("-fx-background-color:red;");
			label.setFont(Font.font("System", FontWeight.BOLD, 20));
			label.setTextFill(Color.BLACK);
			label.setPrefWidth(Double.MAX_VALUE);
			label.setAlignment(Pos.CENTER);
			label.setPrefHeight(50);
			root.setSpacing(5);
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
