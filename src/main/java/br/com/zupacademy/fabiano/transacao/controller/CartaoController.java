package br.com.zupacademy.fabiano.transacao.controller;

import br.com.zupacademy.fabiano.transacao.dto.TransacaoDto;
import br.com.zupacademy.fabiano.transacao.repository.CartaoRepository;
import br.com.zupacademy.fabiano.transacao.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {
    @Autowired
    CartaoRepository cartaoRepository;
    @Autowired
    TransacaoRepository transacaoRepository;

    @GetMapping("/{id}/compras")
    public Page<TransacaoDto> compras(@PathVariable("id") String id,
                                      @PageableDefault(sort="efetivadaEm", direction = Sort.Direction.DESC) Pageable paginacao) {
        if(cartaoRepository.findById(id).isPresent()){
            return TransacaoDto.converter(transacaoRepository.findByCartaoId(id,paginacao));
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
