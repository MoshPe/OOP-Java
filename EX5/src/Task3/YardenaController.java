package Task3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class YardenaController {
	private Integer counterFans = 0;
	@FXML
	private Button yardena;

	@FXML
	private Button ofra;

	@FXML
	private Label counter;

	@FXML
	void decCounter(ActionEvent event) {
		counterFans--;
		counter.setText(counterFans.toString());
	}

	@FXML
	void incCounter(ActionEvent event) {
		counterFans++;
		counter.setText(counterFans.toString());
	}

}
