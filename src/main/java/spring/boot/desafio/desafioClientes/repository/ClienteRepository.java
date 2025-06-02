package spring.boot.desafio.desafioClientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.boot.desafio.desafioClientes.model.Clientes;

@Repository
public interface ClienteRepository extends JpaRepository<Clientes, Long> {

}
