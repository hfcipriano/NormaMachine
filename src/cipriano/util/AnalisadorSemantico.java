package cipriano.util;

import cipriano.util.Enums.ExcecaoEnum;
import cipriano.util.Enums.OperacaoEnum;
import cipriano.util.Excecoes.SemanticException;

import java.util.Collection;

/**
 * Created by Henrique on 04/04/2016.
 */
public class AnalisadorSemantico {
    public static void analisa(Collection<CharSequence> collection){
        int numLinha = 0;
        for(CharSequence cs : collection){
            String[] linha = cs.toString().split(" ");

            if(linha.length >= 4 && linha.length <= 5) {
                if (!linha[0].endsWith(":")) {
                    throw new SemanticException(ExcecaoEnum.ROTULO.getExcecao(), numLinha, 0);
                }

                if (OperacaoEnum.validaSemLancarExcecao(linha[1].toUpperCase()) == null) {
                    throw new SemanticException(ExcecaoEnum.OPERACAO.getExcecao(), numLinha, 1);
                }

                if (!linha[2].matches("^[-\\w.]+$")) {
                    throw new SemanticException(ExcecaoEnum.REGISTRADOR.getExcecao(), numLinha, 2);
                }

                if (!linha[3].matches("^[-0-9._]+$")) {
                    throw new SemanticException(ExcecaoEnum.CONDICIONALVERDADEIRA.getExcecao(), numLinha, 3);
                }

                if (linha.length == 5 && !linha[4].matches("^[-0-9._]+$")) {
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
