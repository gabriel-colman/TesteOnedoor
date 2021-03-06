package com.example.resource;

import com.example.domain.dto.ServicoDTO;
import com.example.repository.ServicoRepository;
import com.example.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.util.Objects.isNull;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.*;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/servicos")
public class ServicoResource {

    @Autowired
    private final ServicoService servicoService;

    @Autowired
    private final ServicoRepository servicoRepository;

    public ServicoResource(ServicoService servicoService, ServicoRepository servicoRepository) {
        this.servicoService = servicoService;
        this.servicoRepository = servicoRepository;
    }

    @GetMapping
    public ResponseEntity<List<ServicoDTO>> listarTodosServicos() {
        return ok(servicoService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<ServicoDTO> salvar(@Valid @RequestBody ServicoDTO servicoDTO) {
        ServicoDTO retorno = servicoService.salvar(servicoDTO);
        return status(CREATED).body(retorno);
    }

    @PutMapping("/{id:[1-9][0-9]*}")
    public ResponseEntity<ServicoDTO> update(@PathVariable("id") long id,
                                             @RequestBody ServicoDTO servicoDTO) {
        ServicoDTO retorno = servicoService.update(id, servicoDTO);
        if (!isNull(retorno)) {
            return ok().body(retorno);
        } else {
            return notFound().build();
        }
    }

    @DeleteMapping("/{id:[1-9][0-9]*}")
    public ResponseEntity <?> deletar(@PathVariable long id) {
        return servicoRepository.findById(id)
                .map(servico -> {
                    servicoRepository.deleteById(id);
                    return ok().build();
                }).orElse(notFound().build());
    }
}
