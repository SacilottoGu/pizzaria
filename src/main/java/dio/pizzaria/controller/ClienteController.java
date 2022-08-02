package dio.pizzaria.controller;

import dio.pizzaria.model.Cliente;
import dio.pizzaria.model.form.ClienteFormCreate;
import dio.pizzaria.model.form.ClienteFormUpdate;
import dio.pizzaria.service.Impl.ClienteImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/customer")
@RestController
public class ClienteController {

    @Autowired
    private ClienteImpl service;

    @PostMapping
    public Cliente create(@RequestBody ClienteFormCreate form){
        return  service.create(form);
    }

    @PutMapping("/{id}")
    public Cliente update(@PathVariable("id")Long id, @RequestBody ClienteFormUpdate form){
        return service.update(id, form);
    }

   @GetMapping("/{id}")
   public Cliente getCliente(@PathVariable("id") Long id){
        return service.getCliente(id);
   }

   @GetMapping
   public List<Cliente> getAllCliente(){
        return service.getAllCliente();
    }

   @GetMapping("/name/{id}")
   public Cliente getClientesByNome(@PathVariable("id") String nome){
        return service.getClientesByNome(nome);
   }
    @DeleteMapping("/{id}")
    public Cliente delete(@PathVariable("id") Long id){
        return service.delete(id);
    }

}
