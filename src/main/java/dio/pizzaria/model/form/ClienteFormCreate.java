package dio.pizzaria.model.form;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
public class ClienteFormCreate {


    @NotBlank (message = "Message cannot be empty")
    private String nome;

    @Positive
    private int qtdPizza;

    @Positive
    private int qtdRefrigerante;

}
