package br.com.zupacademy.fabiano.transacao.listener;

import br.com.zupacademy.fabiano.transacao.dto.TransacaoDto;
import br.com.zupacademy.fabiano.transacao.modelo.Transacao;
import br.com.zupacademy.fabiano.transacao.repository.CartaoRepository;
import br.com.zupacademy.fabiano.transacao.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerDeTransacao {
    @Autowired
    CartaoRepository cartaoRepository;
    @Autowired
    TransacaoRepository transacaoRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransacaoDto transacaoDto) {
        Transacao transacao = transacaoDto.converter();
        if(cartaoRepository.findById(transacao.getCartao().getId()).isEmpty()){
            cartaoRepository.save(transacao.getCartao());
        }
        transacaoRepository.save(transacao);
    }

}