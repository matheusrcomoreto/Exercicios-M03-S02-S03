package br.com.labschool.biblioteca.model.repository;

import br.com.labschool.biblioteca.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
