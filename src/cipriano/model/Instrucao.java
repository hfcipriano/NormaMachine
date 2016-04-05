package cipriano.model;

import cipriano.util.Enums.OperacaoEnum;

/**
 * Created by Henrique on 04/04/2016.
 */
public class Instrucao {
    /**
     * Enum que representa a opera��o da instru��o
     **/
    private OperacaoEnum operacaoEnum;

    /**
     * Objeto que representa o registrador utilizado na instru��o
     **/
    private Registrador registrador;

    public OperacaoEnum getOperacaoEnum() {
        return operacaoEnum;
    }

    public void setOperacaoEnum(OperacaoEnum operacaoEnum) {
        this.operacaoEnum = operacaoEnum;
    }

    public Registrador getRegistrador() {
        return registrador;
    }

    public void setRegistrador(Registrador registrador) {
        this.registrador = registrador;
    }
}
