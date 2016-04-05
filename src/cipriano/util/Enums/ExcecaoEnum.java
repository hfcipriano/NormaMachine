package cipriano.util.Enums;

/**
 * Created by Henrique on 04/04/2016.
 */
public enum ExcecaoEnum {
    ROTULO ("Rotulo inválido"),
    OPERACAO ("Operação inválida"),
    REGISTRADOR ("Registrador inválido"),
    CONDICIONALVERDADEIRA ("Condicional Verdadeira Inválida"),
    CONDICIONALFALSA ("Condicional Falsa inválida");

    private String excecao;
    ExcecaoEnum(String excecao) {
        this.excecao = excecao;
    }

    public String getExcecao() {
        return excecao;
    }
}
