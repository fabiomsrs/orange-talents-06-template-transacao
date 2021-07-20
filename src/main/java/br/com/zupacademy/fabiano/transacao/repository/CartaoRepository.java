package br.com.zupacademy.fabiano.transacao.repository;

import br.com.zupacademy.fabiano.transacao.modelo.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepository extends JpaRepository<Cartao, String> {
}
