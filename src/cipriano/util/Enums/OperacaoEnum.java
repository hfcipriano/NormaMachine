package cipriano.util.Enums;

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
    * ZER: Testa se um determinado registrador contém o valor zero
    **/
    ZER("ZER");

    private String valorOperacao;
    OperacaoEnum(String valor) {
        this.valorOperacao = valor;
    }

    public String getValorOperacao() {
        return valorOperacao;
    }
}
