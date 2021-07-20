package br.com.zupacademy.fabiano.transacao.dto;

import br.com.zupacademy.fabiano.transacao.modelo.Transacao;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoDto {
    private String id;
    private BigDecimal valor;
    private CartaoDto cartao;
    private LocalDateTime efetivadaEm;

    public TransacaoDto() {
    }

    public TransacaoDto(Transacao transacao) {
        this.id = transacao.getId();
        this.valor = transacao.getValor();
        this.efetivadaEm = transacao.getEfetivadaEm();
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
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

    public void setEfetivadaEm(LocalDateTime efetivadaEm) {
        this.efetivadaEm = efetivadaEm;
    }

    public Transacao converter(){
        return new Transacao(this.id, this.valor, this.cartao.converter(), this.efetivadaEm);
    }

    public static Page<TransacaoDto> converter(Page<Transacao> transacoes) {
        return transacoes.map(TransacaoDto::new);
    }

}
