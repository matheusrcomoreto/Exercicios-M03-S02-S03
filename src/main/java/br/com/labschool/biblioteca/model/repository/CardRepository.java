package br.com.labschool.biblioteca.model.repository;

import br.com.labschool.biblioteca.model.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository <Card , Long>{
}
