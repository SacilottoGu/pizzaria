package dio.pizzaria.service;

import dio.pizzaria.model.Refrigerante;
import dio.pizzaria.model.form.RefrigeranteFormCreate;
import dio.pizzaria.model.form.RefrigeranteFormUpdate;

import java.util.List;

public interface RefrigeranteService {

    Refrigerante create(RefrigeranteFormCreate formCreate);

    Refrigerante update(Long id, RefrigeranteFormUpdate formUpdate);

    Refrigerante getRefrigeranteById(Long id);

    List<Refrigerante> getRefrigeranteAll();

    Refrigerante delete(Long id);
}
