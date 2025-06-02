package spring.boot.desafio.desafioClientes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ContatosDto {
    private String telefone;
    private String email;
    private Long clienteId;
}
