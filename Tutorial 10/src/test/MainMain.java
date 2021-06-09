package test;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainMain extends Application {

	private GridPane mines;
	private SplitPane minesGame;
	private MyController controller;
	private int width = 10, height = 10;


	@Override
	public void start(Stage stage) {
		resize();
		Scene scene = new Scene(minesGame);
		controller.setRootApplication(this);
		stage.setTitle("Mines");
		newGrid(width, height);
		stage.setScene(scene);
		stage.show();
		String text = controller.toString();
		System.out.println(text);

	}

	public void newGrid(int width, int height) {
		mines = new GridPane();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				mines.add(new Button() {
					{
						setMinWidth(30);
						setMinHeight(30);
					}
				}, i, j);
			}
		}
		resizeApp();
		// minesGame = new SplitPane();
		// minesGame.getItems().addAll(mines,menu);
		// minesGame.getItems().add(mines);
		minesGame.getItems().set(1, mines);
		// minesGame.getItems().set(0,menu);
		System.out.println(minesGame.isResizable());

	}

	private void resizeApp() {
		minesGame.setPrefSize(mines.getPrefWidth(), mines.getPrefHeight());

	}

	public void resize() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("mineFX.fxml"));
			minesGame = loader.load();
			controller = loader.getController();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

	}

	public void newSceneSet(int width, int height, Stage stage) {
		newGrid(width, height);
		stage.setScene(new Scene(minesGame));
		stage.show();
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	public void setHeight(int width) {
		this.width = width;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
