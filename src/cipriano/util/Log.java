package cipriano.util;

import cipriano.model.Registrador;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Henrique on 18/04/2016.
 */

/*
* Classe que registra as operações feitas pela Máquina Norma
**/
public class Log {
    private List<Integer> registradores = new ArrayList<>();
    private Integer condicionalProxima;

    public Log(List<Registrador> registradores, Integer condicionalProxima) {
        setRegistradores(registradores);
        this.condicionalProxima = condicionalProxima;
    }

    public List<Integer> getRegistradores() {
        return registradores;
    }

    public void setRegistradores(List<Registrador> registradores) {
        for(Registrador r : registradores){
            this.registradores.add(r.getValue());
        }
    }

    public Integer getCondicionalProxima() {
        return condicionalProxima;
    }

    public void setCondicionalProxima(Integer condicionalProxima) {
        this.condicionalProxima = condicionalProxima;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for(Integer i : registradores){
            sb.append(i);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("),");
        sb.append(condicionalProxima);
        sb.append(")");
        return sb.toString();
    }
}
