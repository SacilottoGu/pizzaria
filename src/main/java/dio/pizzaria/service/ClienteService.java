package dio.pizzaria.service;

import dio.pizzaria.model.Cliente;
import dio.pizzaria.model.form.ClienteFormCreate;
import dio.pizzaria.model.form.ClienteFormUpdate;

import java.util.List;

public interface ClienteService {

    Cliente create(ClienteFormCreate formCreate);

    Cliente update(Long id, ClienteFormUpdate formUpdate);

    Cliente getCliente(Long id);

    Cliente getClientesByNome(String nome);

    List<Cliente> getAllCliente();

    Cliente delete(Long id);
}
