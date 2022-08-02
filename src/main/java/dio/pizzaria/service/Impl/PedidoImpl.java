package dio.pizzaria.service.Impl;

import dio.pizzaria.model.Cliente;
import dio.pizzaria.model.Pedido;
import dio.pizzaria.model.Pizza;
import dio.pizzaria.model.Refrigerante;
import dio.pizzaria.model.form.PedidoFormCreate;
import dio.pizzaria.model.form.PedidoFormUpdate;
import dio.pizzaria.repository.ClienteRepository;
import dio.pizzaria.repository.PedidoRepository;
import dio.pizzaria.repository.PizzaRepository;
import dio.pizzaria.repository.RefrigeranteRepository;
import dio.pizzaria.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoImpl implements PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private RefrigeranteRepository refrigeranteRepository;

    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public Pedido create(PedidoFormCreate formCreate) {

        Pedido pedido = new Pedido();

        Optional<Pizza> pizza = pizzaRepository.findById(formCreate.getIdPizza());
        Optional<Refrigerante> refrigerante = refrigeranteRepository.findById(formCreate.getIdRefrigerante());
        Optional<Cliente> cliente = clienteRepository.findById(formCreate.getIdCliente());

        pedido.setCliente(cliente.get());
        pedido.setPizzas(pizza.get());
        pedido.setRefrigerantes(refrigerante.get());
        pedido.setQtdPizza(formCreate.getQtdPizza());
        pedido.setQtdRefrigerante(formCreate.getQtdRefrigerante());

        pedido.setPontos(pizza.get().getPontos() * pedido.getQtdPizza() + refrigerante.get().getPontos() * pedido.getQtdRefrigerante());
        pedido.setValor(pizza.get().getValor() * pedido.getQtdPizza() + refrigerante.get().getValor() * pedido.getQtdRefrigerante());

        cliente.get().setPontos(pedido.getPontos()+cliente.get().getPontos());

        clienteRepository.save(cliente.get());

        return repository.save(pedido);
    }

    @Override
    public Pedido update(Long id, PedidoFormUpdate formUpdate) {

        Optional<Pedido> pedido =  repository.findById(id);
        Optional<Pizza> pizza = pizzaRepository.findById(formUpdate.getIdPizza());
        Optional<Refrigerante> refrigerante = refrigeranteRepository.findById(formUpdate.getIdRefrigerante());
        Optional<Cliente> cliente = Optional.ofNullable(pedido.get().getCliente());

        cliente.get().setPontos(cliente.get().getPontos() - pedido.get().getPontos());
        clienteRepository.save(cliente.get());

        pedido.get().setPizzas(pizza.get());
        pedido.get().setRefrigerantes(refrigerante.get());
        pedido.get().setQtdRefrigerante(formUpdate.getQtdRefrigerante());
        pedido.get().setQtdPizza(formUpdate.getQtdPizza());
        pedido.get().setPontos(pizza.get().getPontos() * pedido.get().getQtdPizza() + refrigerante.get().getPontos() * pedido.get().getQtdRefrigerante());
        pedido.get().setValor(pizza.get().getValor() * formUpdate.getQtdPizza() + refrigerante.get().getValor() * formUpdate.getQtdRefrigerante());

        cliente.get().setPontos(pedido.get().getPontos() + cliente.get().getPontos());

        clienteRepository.save(cliente.get());

        return repository.save(pedido.get());
    }

    @Override
    public Pedido getPedido(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Pedido delete(Long id) {
        repository.deleteById(id);
        return null;
    }
}
