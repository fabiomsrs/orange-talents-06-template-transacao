package br.com.zupacademy.fabiano.transacao.repository;

import br.com.zupacademy.fabiano.transacao.modelo.Transacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, String> {
    Page<Transacao> findByCartaoId(String id, Pageable paginacao);
}
