package spring.boot.desafio.desafioClientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.boot.desafio.desafioClientes.model.Contatos;

@Repository
public interface ContatoRepository extends JpaRepository<Contatos, Long> {

}
