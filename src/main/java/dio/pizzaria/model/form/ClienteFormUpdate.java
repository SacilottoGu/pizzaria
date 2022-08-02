package dio.pizzaria.model.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class ClienteFormUpdate {

    @NotBlank(message = "Message cannot be empty")
    private String nome;

    @Positive
    private int qtdPizza;

    @Positive
    private int qtdRefrigerante;
}
