package dio.pizzaria.service;

import dio.pizzaria.model.Pizza;
import dio.pizzaria.model.form.PizzaFormCreate;
import dio.pizzaria.model.form.PìzzaFormUpdate;

import java.util.List;

public interface PizzaService {

    Pizza create(PizzaFormCreate formCreate);

    Pizza update(Long id, PìzzaFormUpdate formUpdate);

    Pizza getPizzaById(Long id);

    List <Pizza> getPizzaAll();

    Pizza delete(Long id);
}
