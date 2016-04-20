package cipriano.model;

/**
 * Created by Henrique on 04/04/2016.
 */
public class Linha implements Comparable<Linha>{
    /**
    * Valor inteiro que representa o rótulo da linha
    **/
    private Integer numero;

    /**
     * Objeto que armazena a ação
     **/
    private Instrucao instrucao;

    /**
     * Objeto que armazena a próxima instrução, caso a instrução retorne verdadeiro
     **/
    private Integer condicionalVerdadeira;

    /**
     * Objeto que armazena a próxima instrução, caso a instrução retorne falso
     **/
    private Integer getCondicionalFalsa;

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Instrucao getInstrucao() {
        return instrucao;
    }

    public void setInstrucao(Instrucao instrucao) {
        this.instrucao = instrucao;
    }

    public Integer getCondicionalVerdadeira() {
        return condicionalVerdadeira;
    }

    public void setCondicionalVerdadeira(Integer condicionalVerdadeira) {
        this.condicionalVerdadeira = condicionalVerdadeira;
    }

    public Integer getGetCondicionalFalsa() {
        return getCondicionalFalsa;
    }

    public void setGetCondicionalFalsa(Integer getCondicionalFalsa) {
        this.getCondicionalFalsa = getCondicionalFalsa;
    }

    /**
    * Método que compara a posição da linha. Usado no interpretador para ordenar a entrada do usuário, caso esteja desordenada
    **/
    @Override
    public int compareTo(Linha o) {
        if(this.numero < o.getNumero()){
            return -1;
        }
        if(this.numero > o.getNumero()){
            return 1;
        }
        return 0;
    }
}
