package cipriano.util.Enums;

/**
 * Created by Henrique on 04/04/2016.
 */
public enum ExcecaoEnum {
    ROTULO ("Rotulo inv�lido"),
    OPERACAO ("Opera��o inv�lida"),
    REGISTRADOR ("Registrador inv�lido"),
    CONDICIONALVERDADEIRA ("Condicional Verdadeira Inv�lida"),
    CONDICIONALFALSA ("Condicional Falsa inv�lida");

    private String excecao;
    ExcecaoEnum(String excecao) {
        this.excecao = excecao;
    }

    public String getExcecao() {
        return excecao;
    }
}
