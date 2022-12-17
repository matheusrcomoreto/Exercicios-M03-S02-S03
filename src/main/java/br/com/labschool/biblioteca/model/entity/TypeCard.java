package br.com.labschool.biblioteca.model.entity;

import lombok.Getter;

@Getter
public enum TypeCard {

    DEBITO("Débito"),
    CREDITO("Crédito");

    private String typeCard;

    private TypeCard(String typeCard) {
        this.typeCard = typeCard;
    }
}
