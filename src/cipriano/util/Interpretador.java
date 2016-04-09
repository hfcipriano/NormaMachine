package cipriano.util;

import cipriano.model.Instrucao;
import cipriano.model.Linha;
import cipriano.model.Registrador;
import cipriano.util.Enums.OperacaoEnum;
import cipriano.util.Excecoes.InterpreterException;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Henrique on 08/04/2016.
 */
public class Interpretador {
    private static List<Linha> linhas = new ArrayList<>();
    private static List<Registrador> registradores = new ArrayList<>();

    public static String interpreta(){
        Collections.sort(linhas);

        Boolean continua = Boolean.TRUE;
        Linha linha = linhas.get(0);
        while(linha != null){
            Boolean retorno = linha.getInstrucao().executa();

            if(retorno != null && retorno.equals(Boolean.FALSE)){
                linha = obtemLinhaPorNumero(linha.getGetCondicionalFalsa());
            }
            else{
                linha = obtemLinhaPorNumero(linha.getCondicionalVerdadeira());
            }
        }
        return montaRetorno();
    }

    private static String montaRetorno() {
        StringBuilder sb = new StringBuilder();
        for(Registrador r : registradores){
            sb.append(r);
        }
        return sb.toString();
    }

    private static Linha obtemLinhaPorNumero(final Integer numero) {
        for(Linha linha: linhas){
            if(linha.getNumero().equals(numero)){
                return linha;
            }
        }
        return null;
    }

    public static void populaLinhas(ObservableList<CharSequence> paragrafos) {
        linhas.clear();
        registradores.clear();
        for(CharSequence cs : paragrafos){
            Linha linha = new Linha();

            String[] elementos = cs.toString().split(" ");

            linha.setNumero(verificaLinha(new Integer(elementos[0].split("")[0])));

            Instrucao instrucao = new Instrucao();
            instrucao.setOperacaoEnum(OperacaoEnum.valueOf(elementos[1].toUpperCase()));
            instrucao.setRegistrador(buscaRegistrador(elementos[2].toUpperCase()));
            linha.setInstrucao(instrucao);

            linha.setCondicionalVerdadeira(new Integer(elementos[3]));

            if(linha.getInstrucao().getOperacaoEnum().equals(OperacaoEnum.ZER)){
                linha.setGetCondicionalFalsa(new Integer(elementos[4]));
            }

            linhas.add(linha);
        }
    }

    private static Integer verificaLinha(Integer numero) {
        for(Linha linha : linhas){
            if(linha.getNumero().equals(numero)){
                throw new InterpreterException("Linha numero (" + numero + ") repetida");
            }
        }
        return  numero;
    }

    public static Registrador buscaRegistrador(String nome){
        for(Registrador registrador : registradores){
            if(registrador.getNome().equals(nome)){
                return registrador;
            }
        }
        registradores.add(new Registrador(nome));
        return new Registrador(nome);
    }
}
