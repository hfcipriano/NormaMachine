package cipriano.model;

/**
 * Created by Henrique on 04/04/2016.
 */
public class Linha {
    /**
    * Valor inteiro que representa o r�tulo da linha
    **/
    private int numero;

    /**
     * Objeto que armazena a a��o
     **/
    private Instrucao instrucao;

    /**
     * Objeto que armazena a pr�xima instru��o, caso a instru��o retorne verdadeiro
     **/
    private Linha condicionalVerdadeira;

    /**
     * Objeto que armazena a pr�xima instru��o, caso a instru��o retorne falso
     **/
    private Linha getCondicionalFalsa;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Instrucao getInstrucao() {
        return instrucao;
    }

    public void setInstrucao(Instrucao instrucao) {
        this.instrucao = instrucao;
    }

    public Linha getCondicionalVerdadeira() {
        return condicionalVerdadeira;
    }

    public void setCondicionalVerdadeira(Linha condicionalVerdadeira) {
        this.condicionalVerdadeira = condicionalVerdadeira;
    }

    public Linha getGetCondicionalFalsa() {
        return getCondicionalFalsa;
    }

    public void setGetCondicionalFalsa(Linha getCondicionalFalsa) {
        this.getCondicionalFalsa = getCondicionalFalsa;
    }
}
