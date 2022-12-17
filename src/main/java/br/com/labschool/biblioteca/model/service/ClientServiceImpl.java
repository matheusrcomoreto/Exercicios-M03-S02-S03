package br.com.labschool.biblioteca.model.service;

import br.com.labschool.biblioteca.model.entity.Client;
import br.com.labschool.biblioteca.model.repository.ClientRepository;
import br.com.labschool.biblioteca.model.service.interfaces.ClientService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client save(Client client) {
        return this.clientRepository.save(client);
    }

    @Override
    public List<Client> showItens() {
        return this.clientRepository.findAll();
    }

    @Override
    public Client update(Client client) {
        Client clienteSeach = this.search(client.getId());

        BeanUtils.copyProperties(client, clienteSeach, "id");

        return this.clientRepository.save(clienteSeach);
    }

    @Override
    public void delete(Long id) {
        this.clientRepository.deleteById(id);

    }

    @Override
    public Client search(Long id) {
        return this.clientRepository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException("Não foi possível encontrar um cliente com id " + id);
        });
    }
}
