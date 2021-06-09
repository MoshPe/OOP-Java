package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class MyController1 {
	private int widths, heights, minesAmounts;
	
    @FXML
    private Button resetButton;

    @FXML
    private Text width;

    @FXML
    private Text height;

    @FXML
    private Text minesAmount;

    @FXML
    void resetMines(ActionEvent event) {
    	widths = Integer.parseInt(width.getText());
    	heights = Integer.parseInt(minesAmount.getText());
    	minesAmounts = Integer.parseInt(minesAmount.getText());
    }

}
