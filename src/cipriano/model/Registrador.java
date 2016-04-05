package cipriano.model;

/**
 * Created by Henrique on 04/04/2016.
 */
public class Registrador {
    /**
     * Valor em texto que representa o nome do Registrador
     * Valor único
     **/
    private String nome;

    /**
     * Objeto que representa o atual valor do Registrador
     **/
    private Double value;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
