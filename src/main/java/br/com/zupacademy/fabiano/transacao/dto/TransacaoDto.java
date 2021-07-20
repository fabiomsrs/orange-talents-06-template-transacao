package br.com.zupacademy.fabiano.transacao.dto;

import br.com.zupacademy.fabiano.transacao.modelo.Transacao;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoDto {
    private String id;
    private BigDecimal valor;
    private CartaoDto cartao;

    public TransacaoDto() {
    }

    public TransacaoDto(Transacao transacao) {
        this.id = transacao.getId();
        this.valor = transacao.getValor();
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setValor(BigDecimal valor){
        this.valor = valor;
    }

    public void setCartao(CartaoDto cartao) {
        this.cartao = cartao;
    }

    public Transacao converter(){
        return new Transacao(this.id, this.valor, this.cartao.converter());
    }

    public static Page<TransacaoDto> converter(Page<Transacao> transacoes) {
        return transacoes.map(TransacaoDto::new);
    }

}
