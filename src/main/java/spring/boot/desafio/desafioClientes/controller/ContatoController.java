package spring.boot.desafio.desafioClientes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.desafio.desafioClientes.dto.ContatosDto;
import spring.boot.desafio.desafioClientes.model.Clientes;
import spring.boot.desafio.desafioClientes.model.Contatos;
import spring.boot.desafio.desafioClientes.repository.ClienteRepository;
import spring.boot.desafio.desafioClientes.repository.ContatoRepository;

import java.util.Optional;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody ContatosDto dto){

        Optional<Clientes> clientesOptional = clienteRepository.findById(dto.getClienteId());
        if(clientesOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cliente não encontrado");
        }

        Contatos contato = new Contatos();
        contato.setTelefone(dto.getTelefone());
        contato.setEmail(dto.getEmail());
        contato.setClientes(clientesOptional.get());

        contatoRepository.save(contato);

        return ResponseEntity.status(HttpStatus.CREATED).body(contato);


    }


    
}
