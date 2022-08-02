package dio.pizzaria.service.Impl;

import dio.pizzaria.model.Pizza;
import dio.pizzaria.model.form.PizzaFormCreate;
import dio.pizzaria.model.form.PìzzaFormUpdate;
import dio.pizzaria.repository.PizzaRepository;
import dio.pizzaria.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class PizzaImpl implements PizzaService {

    @Autowired
    private PizzaRepository repository;

    @Override
    public Pizza create(PizzaFormCreate formCreate) {

        Pizza pizza = new Pizza();

        pizza.setNome(formCreate.getNome());
        pizza.setValor(formCreate.getValor());
        pizza.setPontos(formCreate.getPontos());

        return repository.save(pizza);
    }

    @Override
    public Pizza update(Long id, PìzzaFormUpdate formUpdate) {

        Optional <Pizza> pizza = repository.findById(id);

        pizza.get().setValor(formUpdate.getValor());
        pizza.get().setPontos(formUpdate.getPontos());

        return repository.save(pizza.get());
    }

    @Override
    public Pizza getPizzaById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Pizza> getPizzaAll() {
        return repository.findAll();
    }


    @Override
    public Pizza delete(Long id) {
        repository.deleteById(id);
        return null;
    }
}
