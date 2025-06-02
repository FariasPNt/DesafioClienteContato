package spring.boot.desafio.desafioClientes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClientesDto {

    private String nome;
    private List<ContatosDto> contatos;
}
