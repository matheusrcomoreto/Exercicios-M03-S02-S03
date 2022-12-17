package br.com.labschool.biblioteca.model.service;

import br.com.labschool.biblioteca.model.entity.Card;
import br.com.labschool.biblioteca.model.repository.CardRepository;
import br.com.labschool.biblioteca.model.service.interfaces.CardService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public Card save(Card card) {
        return this.cardRepository.save(card);
    }

    @Override
    public List<Card> showItens() {
        return null;
    }

    @Override
    public Card update(Card object) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Card search(Long id) {
        return null;
    }
}
