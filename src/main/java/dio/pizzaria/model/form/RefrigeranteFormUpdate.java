package dio.pizzaria.model.form;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
public class RefrigeranteFormUpdate {

    @Positive
    private double valor;

    @Positive
    private int pontos;
}
