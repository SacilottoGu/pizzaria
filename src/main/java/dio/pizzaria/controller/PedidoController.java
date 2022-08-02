package dio.pizzaria.controller;

import dio.pizzaria.model.Pedido;
import dio.pizzaria.model.form.PedidoFormCreate;
import dio.pizzaria.model.form.PedidoFormUpdate;
import dio.pizzaria.service.Impl.PedidoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/request")
@RestController
public class PedidoController {

    @Autowired
    private PedidoImpl service;

    @PostMapping
    public Pedido create(@RequestBody PedidoFormCreate form){
        return service.create(form);
    }

    @PutMapping("/{id}")
    public Pedido update(@PathVariable("id") Long id, @RequestBody PedidoFormUpdate form){
        return service.update(id, form);
    }

    @GetMapping("/{id}")
    public Pedido getPedido(@PathVariable("id")Long id ){
        return service.getPedido(id);
    }

    @DeleteMapping("/{id}")
    public Pedido delete(@PathVariable("id") Long id){
        return service.delete(id);
    }
}
