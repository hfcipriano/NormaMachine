package cipriano.view;

import javafx.beans.property.*;

/**
 * Created by Henrique on 09/04/2016.
 */
public class RegistradorViewModel {
    private final StringProperty nome;
    private final IntegerProperty valor;

    public RegistradorViewModel(){
        this(null, null);
    }

    public RegistradorViewModel(String nome, Integer valor) {
        this.nome = new SimpleStringProperty(nome);
        this.valor = new SimpleIntegerProperty(valor);
    }

    public StringProperty propriedadeNome() {
        return nome;
    }

    public String getNome() {
        return nome.get();
    }

    public StringProperty nomeProperty() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public Integer getValor() {
        return valor.get();
    }

    public IntegerProperty valorProperty() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor.set(valor);
    }

    public void setValor(int valor) {
        this.valor.set(valor);
    }
}
