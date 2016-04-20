package cipriano.view;

import cipriano.NormaMachine;
import cipriano.model.Registrador;
import cipriano.util.AnalisadorSemantico;
import cipriano.util.Excecoes.NormaException;
import cipriano.util.Excecoes.SemanticException;
import cipriano.util.Interpretador;
import cipriano.util.Log;
import javafx.scene.control.*;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

import javax.xml.soap.Text;
import java.util.List;


public class EditorController {

	@FXML
	BorderPane borderMenu;

	@FXML
	TextArea textArea;

	@FXML
	TextArea textAreaResultado;

	@FXML
	Label labelMessage;

	@FXML
	CheckBox checkBox;

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

			List<Registrador> registradores = Interpretador.populaLinhas(textArea.getParagraphs());

			if(checkBox.isSelected()){
				run(registradores);
			}
			else{
				exibeModalRegistradores(registradores);
			}
		}catch (NormaException e){
			labelMessage.setText(e.getMessage());
		}
	}

	public void run(List<Registrador> registradores){
		try{
			for(Registrador r : Interpretador.getRegistradores()){
				for(Registrador registrador : registradores){
					if(r.getNome().equals(registrador.getNome())){
						r.setValue(registrador.getValue());
						break;
					}
				}
			}

			String retorno = Interpretador.interpreta();

			labelMessage.setText(retorno);
			StringBuilder sb = new StringBuilder();
			for(Log l : Interpretador.getLOGGER()){
				sb.append(l);
				sb.append("\n");
			}
			textAreaResultado.setText(sb.toString());
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

	@FXML
	public void macroSoma(){
		String sb = "1: ADD A 2\n" +
				"2: SUB B 3\n" +
				"3: ADD C 4\n" +
				"4: ZER B 5 1";
		textArea.setText(sb);
	}

	@FXML
	public void macroProduto(){
		String string = "1: SUB A 2\n" +
						"2: SUB B 3\n" +
						"3: ADD C 4\n" +
						"4: ADD D 5\n" +
						"5: ZER B 6 2\n" +
						"6: ZER A 10 7\n" +
						"7: SUB C 8\n" +
						"8: ADD B 9\n" +
						"9: ZER C 1 7";
		textArea.setText(string);
	}

	@FXML
	public void macroFatorial(){
		String string = "1: ADD B 2\n" +
						"2: ADD C 3\n" +
						"3: SUB A 4\n" +
						"4: ZER A 5 1\n" +
						"5: SUB C 6\n" +
						"6: ADD A 7\n" +
						"7: ZER C 8 5\n" +
						"8: SUB B 9\n" +
						"9: ZER B 25 10\n" +
						"10: ZER A 13 11\n" +
						"11: ADD C 12\n" +
						"12: SUB A 10\n" +
						"13: ZER C 24 14\n" +
						"14: ZER D 16 15\n" +
						"15: SUB D 14\n" +
						"16: ZER B 20 17\n" +
						"17: ADD A 18\n" +
						"18: SUB B 19\n" +
						"19: ADD D 16\n" +
						"20: ZER D 23 21\n" +
						"21: ADD B 22\n" +
						"22: SUB D 20\n" +
						"23: SUB C 13\n" +
						"24: SUB B 9\n" +
						"25: ZER A 26 28\n" +
						"27: ADD A 28";
		textArea.setText(string);

	}

	public void exibeModalRegistradores(List<Registrador> registradores){
		normaMachine.showDialog(registradores);
	}

	public void setNormaMachine(NormaMachine normaMachine) {
		this.normaMachine = normaMachine;
	}
}
