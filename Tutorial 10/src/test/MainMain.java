package test;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class MainMain extends Application {

	private GridPane mines;
	private HBox minesGame;
	private Mines newGame;
	private MyController controller;
	private Image flag, bomb;
	private Alert win,lose;
	//private Node test;
	private boolean mineOpened = false;


	@Override
	public void start(Stage stage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("mineFX.fxml"));
			minesGame = loader.load();
			controller = loader.getController();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		Scene scene = new Scene(minesGame);
		controller.setRootApplication(minesGame, this);
		flag = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/8/8c/Flag_icon_orange_4.svg/547px-Flag_icon_orange_4.svg.png");
		bomb = new Image("https://w7.pngwing.com/pngs/220/369/png-transparent-minesweeper-pro-classic-mine-sweeper-minesweeper-plus-likeminesweeper-bomb-game-computer-wallpaper-video-game-thumbnail.png");
		
		win = new Alert(AlertType.INFORMATION);
		win.setTitle("Results");
		win.setHeaderText(null);
		win.setContentText("OHH MY!\n	 YoU WoN!!");
		
		lose = new Alert(AlertType.INFORMATION);
		lose.setTitle("Results");
		lose.setHeaderText(null);
		lose.setContentText("HAHA!\n	 You Lost!!");
		stage.setTitle("Mines");
		newGrid(20,20,100);
		stage.setScene(scene);
		stage.show();
	}

	public void newGrid(int width, int height, int minesAmount) {
		newGame = new Mines(width,height,minesAmount);
		mines = new GridPane();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				mines.add(new button(i,j), i, j);
			}
		}
			try {
				minesGame.getChildren().set(1, mines);
			}
			catch(Exception e) {
				minesGame.getChildren().add(mines);
			}
		resizeApp();
	}

	private class button extends Button{
		private int i, j;
		
		private button(int i, int j) {
			this.i = i;
			this.j = j;
			setText(newGame.get(i, j));
			setMinWidth(40);
			setMinHeight(40);
			setFont(Font.font("System", FontWeight.BOLD, 15));
			setOnMouseClicked(new leftButton());
		}
			class leftButton implements EventHandler<MouseEvent>{

				@Override
				public void handle(MouseEvent event) {
					if(event.getButton() == MouseButton.SECONDARY) {
						newGame.toggleFlag(i, j);
						if(newGame.get(i, j).equals("F")) {
							setText("");
							setGraphic(new ImageView(flag) {{
								setFitWidth(10);
								setFitHeight(10);
							}});
						}
						else if(!newGame.get(i, j).equals("X")){
							setGraphic(null);
							setText(newGame.get(i, j));
						}	
					}
					else {
						if(!newGame.open(i,j)) {
							newGame.setShowAll(true);
							mineOpened = true;	
						}
						for (Node node : mines.getChildren()) {
							button b = (button) node;
							if(newGame.get(b.i, b.j).equals("X")) {
								b.setText("");
								b.setGraphic(new ImageView(bomb) {{
									setFitWidth(20);
									setFitHeight(20);
								}});
							}
							else
								b.setText(newGame.get(b.i, b.j));
						}
					}
					if(newGame.isDone()) {
						win.showAndWait();
						newGrid(20,20,100);
						mineOpened = false;
					}
					else if(mineOpened) {
						lose.showAndWait();
						newGrid(20,20,100);
						mineOpened = false;
					}
				}
			}
		}
	private void resizeApp() {
		minesGame.setPrefWidth(mines.getPrefWidth());
		minesGame.setPrefWidth(mines.getPrefHeight());
		//minesGame.resize(minesGame.getWidth() + ((VBox)test).getWidth(),minesGame.getHeight()+ ((VBox)test).getHeight());
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
