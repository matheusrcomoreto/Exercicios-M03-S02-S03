package br.com.labschool.biblioteca.model.service.interfaces;

import java.util.List;

public interface DefautCrud <T>{

    T save (T object);

    List<T> showItens();

    T update (T object);

    void delete (Long id);
    T search (Long id);
}
