package spring.boot.desafio.desafioClientes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClienteResponseDto {
    private Long id;
    private String nome;
    private List<ContatosResponseDto> contatos;
}
