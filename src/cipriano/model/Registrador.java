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

    /**
     * Incrementa o valor do registrador em um.
     */
    public void ADD(){
        value++;
    }

    /**
     * Decrementa o valor do registrador em um.
     */
    public void SUB(){
        value--;
    }

    /**
     * Verifica se o registrador possui valor 0
     * @return Retorna verdadeiro caso seja verdade, falso caso possua qualquer valor diferente de 0.
     */
    public Boolean ZER(){
        if(value.equals(0)){
            return true;
        }
        return false;
    }

    public Registrador(String nome) {
        this.nome = nome;
        value = 0D;
    }

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

    @Override
    public String toString() {
        return "nome='" + nome + '\'' +
                ", valor=" + value + "\n";
    }
}
