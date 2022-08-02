package dio.pizzaria.controller;

import dio.pizzaria.model.Refrigerante;
import dio.pizzaria.model.form.RefrigeranteFormCreate;
import dio.pizzaria.model.form.RefrigeranteFormUpdate;
import dio.pizzaria.service.Impl.RefrigeranteImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/soda")
@RestController
public class RefrigeranteController {

    @Autowired
    private RefrigeranteImp service;

    @PostMapping
    public Refrigerante create(@RequestBody RefrigeranteFormCreate form){
        return service.create(form);
    }

    @PutMapping("/{id}")
    public Refrigerante update(@PathVariable("id") Long id, @RequestBody RefrigeranteFormUpdate form){
        return service.update(id, form);
    }

    @GetMapping("/{id}")
    public Refrigerante getRefrigeranteById(@PathVariable("id") long id){
        return service.getRefrigeranteById(id);
    }

    @GetMapping
    public List<Refrigerante> getRefrigeranteAll(){
        return service.getRefrigeranteAll();
    }

    @DeleteMapping("/{id}")
    public Refrigerante delete(@PathVariable("id") Long id){
        return service.delete(id);
    }

}
