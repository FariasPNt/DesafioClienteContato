package spring.boot.desafio.desafioClientes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.desafio.desafioClientes.dto.ClienteResponseDto;
import spring.boot.desafio.desafioClientes.dto.ClientesDto;
import spring.boot.desafio.desafioClientes.dto.ContatosResponseDto;
import spring.boot.desafio.desafioClientes.model.Clientes;
import spring.boot.desafio.desafioClientes.model.Contatos;
import spring.boot.desafio.desafioClientes.repository.ClienteRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Clientes salvarCliente(ClientesDto dto){
        Clientes clientes = new Clientes();
        clientes.setNome(dto.getNome());

        if(dto.getContatos() != null && dto.getContatos().size() > 0){
            List<Contatos> contatos = dto.getContatos().stream().map(c -> {
                Contatos contato = new Contatos();
                contato.setTelefone(c.getTelefone());
                contato.setEmail(c.getEmail());
                contato.setClientes(clientes);
                return contato;
            }).collect(Collectors.toList());
            clientes.setContatos(contatos);
        }

        return clienteRepository.save(clientes);
    }

    public List<ClienteResponseDto> listarTodos(){
        return clienteRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<ContatosResponseDto> listarContatosPorCliente(Long clienteId){
        Clientes client = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        return client.getContatos().stream().map(c -> {
            ContatosResponseDto contatoDTO = new ContatosResponseDto();
            contatoDTO.setId(c.getId());
            contatoDTO.setTelefone(c.getTelefone());
            contatoDTO.setEmail(c.getEmail());
            return contatoDTO;
        }).collect(Collectors.toList());
    }

    private ClienteResponseDto toDTO(Clientes cliente){
        ClienteResponseDto dto = new ClienteResponseDto();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());

        List<ContatosResponseDto> contatos = cliente.getContatos().stream().map(c-> {
            ContatosResponseDto contatoDTO = new ContatosResponseDto();
            contatoDTO.setId(c.getId());
            contatoDTO.setTelefone(c.getTelefone());
            contatoDTO.setEmail(c.getEmail());
            return contatoDTO;
        }).collect(Collectors.toList());
        dto.setContatos(contatos);
        return dto;
    }

}
