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
    private VBox root;
    private HBox buttons;
    private Button yardenaFans;
    private Button ofraFans;
    private Image questionMark;
    private Image ofra;
    private Image yardena;
    private ImageView imageView;
    private Label counterLabel;

    //constructor to init all the components
    public yarVsOfra(){
        counterLabel = new Label("0");
        root = new VBox();
        buttons = new HBox();
        yardenaFans = new Button("Yardena Arazi");
        ofraFans = new Button("Ofra Haza");
        questionMark = new Image("http://www.mazor-law.co.il/wp-content/uploads/2019/12/question-mark.png");
        ofra = new Image("https://img.mako.co.il/2020/08/14/KHKADAD506_i.jpg");
        yardena = new Image("https://yt3.ggpht.com/ytc/AAUvwnjwETzDEFrFfFXHXCMh-cI2FmdHa1wRNTck2N8w=s900-c-k-c0x00ffffff-no-rj");
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            initRoot();
            //resize Ofra button
            ofraFans.setPrefWidth(100);
            ofraFans.setPrefHeight(50);
             //resize Yardena button
            yardenaFans.setPrefWidth(100);
            yardenaFans.setPrefHeight(50);
            initCounterLabel();
            initHbox();
            //adding all components to a VBox
            root.getChildren().addAll(buttons, counterLabel);
            
            //class for increase the counter if Ofra was chosen
            class counterIncrease implements EventHandler<ActionEvent>{
                @Override
                public void handle(ActionEvent event) {
                    counter++;
                    //change the image based on the fans counter
                    if(counter > 0)
                        imageView.setImage(ofra);
                     //Reseting the image to question mark
                    if(counter == 0)
                        imageView.setImage(questionMark);
                    counterLabel.setText(""+counter);
                }
            }
            //class for decrease the counter if Yardena was chosen
            class counterDecrease implements EventHandler<ActionEvent>{
                @Override
                public void handle(ActionEvent event) {
                    counter--;
                    //change the image based on the fans counter
                    if(counter < 0)
                        imageView.setImage(yardena);
                     //Reseting the image to question mark
                    if(counter == 0)
                        imageView.setImage(questionMark);
                    counterLabel.setText(""+counter);
                }
            }
            //setting the button action to each handler
            ofraFans.setOnAction(new counterIncrease());
            yardenaFans.setOnAction(new counterDecrease());
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
    
    //Initiating HBox properties
    private void initHbox(){
        imageView = new ImageView(questionMark);
        imageView.setFitHeight(120);
        imageView.setFitWidth(120);
        buttons.setSpacing(40);
        buttons.getChildren().addAll(ofraFans,imageView,yardenaFans);
    }
    
    //Initiating root properties(VBox)
    private void initRoot(){
        root.setPrefWidth(400);
        root.setPrefHeight(200);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));
    }
//Initiating the label properties that display the counter
    private void initCounterLabel(){
        counterLabel.setText(""+counter);
        counterLabel.setStyle("-fx-background-color:red;");
        counterLabel.setFont(Font.font("System", FontWeight.BOLD, 20));
        counterLabel.setTextFill(Color.BLACK);
        counterLabel.setPrefWidth(Double.MAX_VALUE);
        counterLabel.setAlignment(Pos.CENTER);
        counterLabel.setPrefHeight(50);
    }
}
