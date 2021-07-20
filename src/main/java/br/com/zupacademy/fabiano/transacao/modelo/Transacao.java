package br.com.zupacademy.fabiano.transacao.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
public class Transacao {
    @Id
    private String id;
    private BigDecimal valor;
    @ManyToOne
    Cartao cartao;

    public Transacao() {
    }

    public Transacao(String id, BigDecimal valor, Cartao cartao) {
        this.id = id;
        this.valor = valor;
        this.cartao = cartao;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Cartao getCartao() {
        return cartao;
    }
}
