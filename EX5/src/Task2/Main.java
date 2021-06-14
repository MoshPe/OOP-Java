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
            ofraFans.setPrefWidth(100);
            yardenaFans.setPrefWidth(100);
            ofraFans.setPrefHeight(50);
            yardenaFans.setPrefHeight(50);
            initCounterLabel();
            initHbox();
            root.getChildren().addAll(buttons, counterLabel);

            class counterIncrease implements EventHandler<ActionEvent>{
                @Override
                public void handle(ActionEvent event) {
                    counter++;
                    if(counter > 0)
                        imageView.setImage(ofra);
                    if(counter == 0)
                        imageView.setImage(questionMark);
                    counterLabel.setText(""+counter);
                }
            }
            class counterDecrease implements EventHandler<ActionEvent>{
                @Override
                public void handle(ActionEvent event) {
                    counter--;
                    if(counter < 0)
                        imageView.setImage(yardena);
                    if(counter == 0)
                        imageView.setImage(questionMark);
                    counterLabel.setText(""+counter);
                }
            }
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

    private void initHbox(){
        imageView = new ImageView(questionMark);
        imageView.setFitHeight(120);
        imageView.setFitWidth(120);
        buttons.setSpacing(40);
        buttons.getChildren().addAll(ofraFans,imageView,yardenaFans);
    }

    private void initRoot(){
        root.setPrefWidth(400);
        root.setPrefHeight(200);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));
    }

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
