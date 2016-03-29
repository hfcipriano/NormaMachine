package cipriano.view;

import cipriano.NormaMachine;
import javafx.scene.control.TextArea;
import org.controlsfx.dialog.Dialogs;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

import java.util.Iterator;


public class EditorController {

	@FXML
	BorderPane borderMenu;

	@FXML
	TextArea textArea;

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
		for(CharSequence cs : textArea.getParagraphs()){
			String linha = cs.toString();
			if(!linha.isEmpty()){
				System.out.println(linha);
			}
		}
	}

	public void setNormaMachine(NormaMachine normaMachine) {
		this.normaMachine = normaMachine;
	}
}
