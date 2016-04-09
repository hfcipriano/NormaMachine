package cipriano.model;

/**
 * Created by Henrique on 04/04/2016.
 */
public class Linha implements Comparable<Linha>{
    /**
    * Valor inteiro que representa o r�tulo da linha
    **/
    private Integer numero;

    /**
     * Objeto que armazena a a��o
     **/
    private Instrucao instrucao;

    /**
     * Objeto que armazena a pr�xima instru��o, caso a instru��o retorne verdadeiro
     **/
    private Integer condicionalVerdadeira;

    /**
     * Objeto que armazena a pr�xima instru��o, caso a instru��o retorne falso
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
