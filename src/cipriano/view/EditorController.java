package cipriano.view;

import cipriano.NormaMachine;
import cipriano.util.AnalisadorSemantico;
import cipriano.util.Excecoes.SemanticException;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import org.controlsfx.dialog.Dialogs;


public class EditorController {

	@FXML
	BorderPane borderMenu;

	@FXML
	TextArea textArea;

	@FXML
	Label labelMessage;

	private NormaMachine normaMachine;

	@FXML
	public void fileClose(){
		System.exit(0);
	}

	@FXML
	public void helpAbout(){
		Dialogs.create()
        .title("About the Program")
        .masthead("jNormaMachine v1.0")
        .message("Developed by Henrique Cipriano\n hfcipriano@gmail.com")
        .showInformation();
	}

	@FXML
	public void compileAndRun(){
		//TODO: implentar a chamada ao interpretador
	}

	@FXML
	public void analisaSemantica(){
		try{
			AnalisadorSemantico.analisa(textArea.getParagraphs());
			labelMessage.setText("Compilado com sucesso!");
		}catch (SemanticException e){
			labelMessage.setText(e.posicao());
		}
	}

	public void setNormaMachine(NormaMachine normaMachine) {
		this.normaMachine = normaMachine;
	}
}
