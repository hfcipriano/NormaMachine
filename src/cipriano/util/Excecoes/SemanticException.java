package cipriano.util.Excecoes;

/**
 * Created by Henrique on 04/04/2016.
 */
public class SemanticException extends NormaException {

    public SemanticException(String msg, int linha, int coluna) {
        super("Erro de Syntaxe na linha " + linha + " e coluna " + coluna);
    }
}
