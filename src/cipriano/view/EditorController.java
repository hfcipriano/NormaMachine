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
	public void ajuda(){
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Manual do jNormaMachine");
		alert.setHeaderText("O programa jNormaMachine é uma ferramenta interativa que demonstra o funcionamento da Máquina de Norma.");
		alert.setContentText("Syntaxe: \"<Número do rótulo>: <Operação> <Registrador> <Condicional verdadeira> <Condicional falsa>\"\n\n" +
				"<Número do rótulo>: Qualquer número inteiro não negativo. Representa a identificação do rótulo.\n" +
				"<Operação>: Operação a ser executa pelo rótulo. Por definição, existem três operações possíveis sobre o valor do registrador. Incrementar um(ADD), decrementar um(SUB) e verificar se é igual a 0 (ZER).\n" +
				"<Registrador>: Qualquer palavra formada por a-z. Representa o variável que armazenará o valor.\n" +
				"<Condicional verdadeira>: Indica o próximo rótulo a ser executado caso a operação retorne verdadeiro\n" +
				"<Condicional falsa>: Valor obrigatório apenas quando a Operação for ZER. Indica o próximo rótulo a ser executado caso a operação retorne falso.\n\n" +
				"Exemplos: \n" +
				"\"1: ADD A 2\"\n" +
				"\"2: ADD B 3 3\"\n" +
				"\"3: ZER A 2 2\"\n");

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
