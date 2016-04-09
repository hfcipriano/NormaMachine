package cipriano.view;

import cipriano.NormaMachine;
import cipriano.util.AnalisadorSemantico;
import cipriano.util.Excecoes.NormaException;
import cipriano.util.Excecoes.SemanticException;
import cipriano.util.Interpretador;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;


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
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Sobre o programa");
		alert.setHeaderText("jNormaMachine v1.0");
		alert.setContentText("Desenvolvido por Henrique Cipriano \n hfcipriano@gmail.com");

		alert.showAndWait();
	}

	@FXML
	public void compileAndRun(){
		try{
			AnalisadorSemantico.analisa(textArea.getParagraphs());
			labelMessage.setText("Compilado com sucesso!");

			Interpretador.populaLinhas(textArea.getParagraphs());
			String retorno = Interpretador.interpreta();
			labelMessage.setText(retorno);

		}catch (NormaException e){
			labelMessage.setText(e.getMessage());
		}
	}

	@FXML
	public void analisaSemantica(){
		try{
			AnalisadorSemantico.analisa(textArea.getParagraphs());
			labelMessage.setText("Compilado com sucesso!");
		}catch (SemanticException e){
			labelMessage.setText(e.getMessage());
		}
	}

	public void setNormaMachine(NormaMachine normaMachine) {
		this.normaMachine = normaMachine;
	}
}
