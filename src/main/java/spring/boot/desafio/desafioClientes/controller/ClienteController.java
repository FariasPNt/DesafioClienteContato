package spring.boot.desafio.desafioClientes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.boot.desafio.desafioClientes.dto.ClienteResponseDto;
import spring.boot.desafio.desafioClientes.dto.ClientesDto;
import spring.boot.desafio.desafioClientes.dto.ContatosResponseDto;
import spring.boot.desafio.desafioClientes.model.Clientes;
import spring.boot.desafio.desafioClientes.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Clientes> criar(@RequestBody ClientesDto dto){
        Clientes clienteSalvo = clienteService.salvarCliente(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDto>> listarTodos(){
        return ResponseEntity.ok(clienteService.listarTodos());
    }

    @GetMapping("/{id}/contatos")
    public ResponseEntity<List<ContatosResponseDto>> listarContatos(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.listarContatosPorCliente(id));
    }
}
