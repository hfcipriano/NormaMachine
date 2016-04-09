package cipriano.util.Excecoes;

/**
 * Created by Henrique on 08/04/2016.
 */
public abstract class NormaException extends RuntimeException {
    public NormaException(String mensagem) {
        super(mensagem);
    }
}
