package test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class MyController {
	private int widths = 10, heights = 10, minesAmounts = 10;
	private HBox root;
	private MainMain test;
	
	public void setRootApplication(HBox root,MainMain test) {
	    this.root = root;
	    //setGlobalEventHandler(root);
	    this.test = test;
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
    	widths = Integer.parseInt(widthText.getText());
    	heights = Integer.parseInt(heightText.getText());
    	minesAmounts = Integer.parseInt(minesText.getText());
    	test.newGrid(widths, heights, minesAmounts);
    }
    
    private void setGlobalEventHandler(Node root) {
        
    }
}
