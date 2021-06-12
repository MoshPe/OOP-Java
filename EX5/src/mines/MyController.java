package mines;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class MyController {
	private int widths = 10, heights = 10, minesAmounts = 10;
	private MainMain root;
	private Alert alert;

	public void setRootApplication(MainMain root, HBox test) {
		this.root = root;
		test.addEventHandler(KeyEvent.KEY_PRESSED, ev -> {
			if (ev.getCode() == KeyCode.ENTER) {
				resetButton.fire();
				ev.consume();
			}
		});
	}
	
	private void enterPressed(KeyEvent event) {
		
	}

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
