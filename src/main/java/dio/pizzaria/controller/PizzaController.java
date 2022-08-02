package dio.pizzaria.controller;

import dio.pizzaria.model.Pizza;
import dio.pizzaria.model.form.PizzaFormCreate;
import dio.pizzaria.model.form.PìzzaFormUpdate;
import dio.pizzaria.service.Impl.PizzaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/pizza")
@RestController
public class PizzaController {

    @Autowired
    private PizzaImpl service;

    @PostMapping
    public Pizza create(@RequestBody PizzaFormCreate form){
        return service.create(form);
    }

    @PutMapping("/{id}")
    public Pizza update(@PathVariable("id") Long id,@RequestBody PìzzaFormUpdate form){
        return service.update(id, form);
    }

    @GetMapping("/{id}")
    public Pizza getPizzaById(@PathVariable("id") Long id){
        return service.getPizzaById(id);
    }

    @GetMapping
    public List <Pizza> getPizzaAll(){
        return service.getPizzaAll();
    }

    @DeleteMapping("/{id}")
    public Pizza delete(@PathVariable("id") Long id){
        return service.delete(id);
    }
}
