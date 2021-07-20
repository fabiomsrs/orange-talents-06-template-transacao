package br.com.zupacademy.fabiano.transacao.dto;

import br.com.zupacademy.fabiano.transacao.modelo.Cartao;

public class CartaoDto {
    private String id;
    private String email;

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cartao converter(){
        return new Cartao(this.id, this.email);
    }
}
