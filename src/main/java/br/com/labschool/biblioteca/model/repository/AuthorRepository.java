package br.com.labschool.biblioteca.model.repository;

import br.com.labschool.biblioteca.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository <Author, Long> {

    Boolean existsByName (String name);
}
