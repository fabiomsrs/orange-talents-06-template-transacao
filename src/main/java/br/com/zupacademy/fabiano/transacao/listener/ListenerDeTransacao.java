package br.com.zupacademy.fabiano.transacao.listener;

import br.com.zupacademy.fabiano.transacao.dto.TransacaoDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerDeTransacao {

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransacaoDto transacaoDto) {
        System.out.println(transacaoDto.toString());
    }

}