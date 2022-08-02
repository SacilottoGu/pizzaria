package dio.pizzaria.model.form;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
public class PedidoFormCreate {

    @Positive(message = "The value cannot be negative")
    private long idPizza;

    @Positive(message = "The value cannot be negative")
    private long idRefrigerante;

    @Positive(message = "The value cannot be negative")
    private int qtdPizza;

    @Positive(message = "The value cannot be negative")
    private int qtdRefrigerante;

    @Positive(message = "The value cannot be negative")
    private long idCliente;


}
