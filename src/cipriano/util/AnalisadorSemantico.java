package cipriano.util;

import cipriano.util.Enums.ExcecaoEnum;
import cipriano.util.Enums.OperacaoEnum;
import cipriano.util.Excecoes.SemanticException;
import javafx.collections.ObservableList;

import java.util.Collection;
import java.util.Observable;

/**
 * Created by Henrique on 04/04/2016.
 */
public class AnalisadorSemantico {
    /**
    *Analisa a entrada do usuário em busca de falhas na sintaxe
    *@param collection Lista que contem a entrada do usuário
    *Caso econtre alguma anormalidade, é lançada a exceção, que é tratada e exibida para o usuário
    **/
    public static void analisa(ObservableList<CharSequence> collection){
        int numLinha = 0;
        for(CharSequence cs : collection){
            String[] linha = cs.toString().split(" ");

            Boolean condicionalFalsaObrigatoria = false;
            if(linha.length >= 4 && linha.length <= 5) {
                if (!linha[0].endsWith(":")) {
                    throw new SemanticException(ExcecaoEnum.ROTULO.getExcecao(), numLinha, 0);
                }

                if (OperacaoEnum.validaSemLancarExcecao(linha[1].toUpperCase()) == null) {
                    throw new SemanticException(ExcecaoEnum.OPERACAO.getExcecao(), numLinha, 1);
                }

                if(OperacaoEnum.valueOf(linha[1].toUpperCase()).equals(OperacaoEnum.ZER)){
                    condicionalFalsaObrigatoria = true;
                }

                if (!linha[2].matches("[a-zA-Z\\s]+")) {
                    throw new SemanticException(ExcecaoEnum.REGISTRADOR.getExcecao(), numLinha, 2);
                }

                if (!linha[3].matches("^[-0-9._]+$")) {
                    throw new SemanticException(ExcecaoEnum.CONDICIONALVERDADEIRA.getExcecao(), numLinha, 3);
                }

                if (linha.length == 5 && !linha[4].matches("^[-0-9._]+$")) {
                    throw new SemanticException(ExcecaoEnum.CONDICIONALFALSA.getExcecao(), numLinha, 4);
                }

                if(condicionalFalsaObrigatoria && linha.length != 5){
                    throw new SemanticException(ExcecaoEnum.CONDICIONALFALSA.getExcecao(), numLinha, 4);
                }
            }
            else{
                throw new SemanticException(null, numLinha, 0);
            }

            numLinha++;
        }

    }
}
