package test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class MyController {
	private int widths = 10, heights = 10, minesAmounts = 10;
	private MainMain root;
	
	public void setRootApplication(MainMain root) {
	    this.root = root;
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
    void resetMines(ActionEvent event) {
    	widths = Integer.parseInt(widthText.getText());
    	heights = Integer.parseInt(heightText.getText());
    	//minesAmounts = Integer.parseInt(minesAmount.getText());
    	root.newGrid(widths, heights);
    	System.out.println(""+widths+heights+"");
    
    }
    
    @Override
	public String toString() {
    	return "hello m8";
    }

}
