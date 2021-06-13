package mines;

import javafx.animation.AnimationTimer;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class MyController {
	private int widths = 10, heights = 10, minesAmounts = 10;
	private MainMain root;
	private Alert alert;



	@FXML
	private Button resetButton;

	@FXML
	private Text width;

	@FXML
	private Text height;

	@FXML
	private Text minesAmount;

	@FXML
	private TextField widthText;

	@FXML
	private TextField heightText;

	@FXML
	private TextField minesText;
	
    @FXML
    private ImageView pic;
    
	public void setRootApplication(MainMain root, HBox test) {
		this.root = root;
		test.addEventHandler(KeyEvent.KEY_PRESSED, ev -> {
			if (ev.getCode() == KeyCode.ENTER) {
				resetButton.fire();
				ev.consume();
			}
		});
		
		Image i = new Image("https://giffiles.alphacoders.com/266/2669.gif");
        pic.setImage(i);
        pic.setFitWidth(260);
        pic.setFitHeight(700);
        Rectangle clip = new Rectangle();
        clip.setWidth(260);
        clip.setHeight(300);
        clip.setArcHeight(200);
        clip.setArcWidth(200);
        pic.setClip(clip);
        
        
        //
        //
        Label label = new Label();
        DoubleProperty time = new SimpleDoubleProperty();
        label.textProperty().bind(time.asString("%.3f seconds"));

        BooleanProperty running = new SimpleBooleanProperty();
        AnimationTimer timer = new AnimationTimer() {

            private long startTime ;

            @Override
            public void start() {
                startTime = System.currentTimeMillis();
                super.start();
            }

            @Override
            public void handle(long timestamp) {
                long now = System.currentTimeMillis();
                time.set((now - startTime) / 1000.0);
            }
        };
	}

	@FXML
	void resetMines(ActionEvent event) {
		try {
			widths = Integer.parseInt(widthText.getText());
			heights = Integer.parseInt(heightText.getText());
			minesAmounts = Integer.parseInt(minesText.getText());
			if(widths <= 0 || heights <= 0 || minesAmounts <= 0)
				throw new NumberFormatException();
		} catch (NumberFormatException e) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Wrong numbers!!");
			alert.showAndWait();
			root.newGrid(10	, 10, 20);
			return;
		}
		root.newGrid(widths, heights, minesAmounts);
	}
}
