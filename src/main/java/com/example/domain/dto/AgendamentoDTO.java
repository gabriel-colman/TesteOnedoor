package com.example.domain.dto;


import com.example.domain.model.Cliente;
import com.example.domain.model.Servico;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoDTO implements BaseDTO {

    private LocalDateTime dataHora;
    private String observacao;
    private Cliente cliente;
    private Servico servico;
}
