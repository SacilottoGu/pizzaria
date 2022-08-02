package dio.pizzaria.service.Impl;

import dio.pizzaria.model.Cliente;
import dio.pizzaria.model.form.ClienteFormCreate;
import dio.pizzaria.model.form.ClienteFormUpdate;
import dio.pizzaria.repository.ClienteRepository;
import dio.pizzaria.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteImpl implements ClienteService {


    @Autowired
    private ClienteRepository repository;

    @Override
    public Cliente create(ClienteFormCreate formCreate) {

        Cliente cliente = new Cliente();

        cliente.setNome(formCreate.getNome());

        return repository.save(cliente);
    }

    @Override
    public Cliente update(Long id, ClienteFormUpdate formUpdate) {

        Optional <Cliente> cliente = repository.findById(id);

        cliente.get().setNome(formUpdate.getNome());

        return repository.save(cliente.get());
    }

    @Override
    public Cliente getCliente(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Cliente getClientesByNome(String nome) {
        return repository.getClientesByNome(nome);
    }

    @Override
    public List<Cliente> getAllCliente() {
        return repository.findAll();
    }

    @Override
    public Cliente delete(Long id) {
        repository.deleteById(id);
        return null;
    }
}
