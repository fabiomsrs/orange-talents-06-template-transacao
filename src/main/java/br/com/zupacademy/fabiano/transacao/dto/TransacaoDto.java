package br.com.zupacademy.fabiano.transacao.dto;

import java.math.BigDecimal;

public class TransacaoDto {
    private String id;
    private BigDecimal valor;


    public void setId(String id) {
        this.id = id;
    }

    public void setValor(BigDecimal valor){
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "TransacaoDto{" +
                "id='" + this.id + '\'' +
                ", valor=" + this.valor.toString() +
                '}';
    }
}
