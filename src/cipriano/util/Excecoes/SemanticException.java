package cipriano.util.Excecoes;

/**
 * Created by Henrique on 04/04/2016.
 */
public class SemanticException extends RuntimeException {
    private int linha;
    private int coluna;

    public SemanticException(String msg, int linha, int coluna) {
        super(msg);
        this.linha = linha;
        this.coluna = coluna;
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    public String posicao(){
        return "Erro de Syntaxe na linha " + getLinha() + " e coluna " + getColuna();
    }
}
