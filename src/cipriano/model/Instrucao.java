package cipriano.model;

import cipriano.util.Enums.OperacaoEnum;

/**
 * Created by Henrique on 04/04/2016.
 */
public class Instrucao {
    /**
     * Enum que representa a operação da instrução
     **/
    private OperacaoEnum operacaoEnum;

    /**
     * Objeto que representa o registrador utilizado na instrução
     **/
    private Registrador registrador;

    public Boolean executa(){
        if(OperacaoEnum.ADD.equals(operacaoEnum)){
            registrador.ADD();
        }
        else if(OperacaoEnum.SUB.equals(operacaoEnum)){
            registrador.SUB();
        }
        else if(OperacaoEnum.ZER.equals(operacaoEnum)){
            return registrador.ZER();
        }
        return null;
    }


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
