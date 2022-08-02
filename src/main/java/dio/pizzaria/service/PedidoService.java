package dio.pizzaria.service;

import dio.pizzaria.model.Pedido;
import dio.pizzaria.model.form.PedidoFormCreate;
import dio.pizzaria.model.form.PedidoFormUpdate;

public interface PedidoService {

    Pedido create(PedidoFormCreate formCreate);

    Pedido update(Long id, PedidoFormUpdate formUpdate);

    Pedido getPedido(Long id);

    Pedido delete(Long id);
}
