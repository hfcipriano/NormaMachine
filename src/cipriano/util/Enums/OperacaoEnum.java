package cipriano.util.Enums;

import cipriano.util.Excecoes.SemanticException;

/**
 * Created by Henrique on 04/04/2016.
 */
public enum OperacaoEnum {
    /**
    * ADD: Incrementa em uma unidade um determinado registrador
    **/
    ADD("ADD"),

    /**
     * SUB: Decrementa em uma unidade um determinado registrador
     **/
    SUB("SUB"),

    /**
    * ZER: Testa se um determinado registrador cont�m o valor zero
    **/
    ZER("ZER");

    private String valorOperacao;
    OperacaoEnum(String valor) {
        this.valorOperacao = valor;
    }

    public String getValorOperacao() {
        return valorOperacao;
    }

    /*
    * Método utilizado no analisador semântico, para fazer tratamento interno de exceções
    **/
    public static OperacaoEnum validaSemLancarExcecao(final String operacao){
        try{
            OperacaoEnum operacaoEnum = valueOf(operacao);
            return operacaoEnum;
        }catch (IllegalArgumentException e){
            return null;
        }
    }
}
