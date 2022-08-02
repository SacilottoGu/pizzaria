package dio.pizzaria.service.Impl;

import dio.pizzaria.model.Refrigerante;
import dio.pizzaria.model.form.RefrigeranteFormCreate;
import dio.pizzaria.model.form.RefrigeranteFormUpdate;
import dio.pizzaria.repository.PizzaRepository;
import dio.pizzaria.repository.RefrigeranteRepository;
import dio.pizzaria.service.RefrigeranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RefrigeranteImp implements RefrigeranteService {


    @Autowired
    private RefrigeranteRepository repository;

    @Override
    public Refrigerante create(RefrigeranteFormCreate formCreate) {
        Refrigerante refrigerante = new Refrigerante();

        refrigerante.setValor(formCreate.getValor());
        refrigerante.setNome(formCreate.getNome());
        refrigerante.setPontos(formCreate.getPontos());

        return repository.save(refrigerante);
    }

    @Override
    public Refrigerante update(Long id, RefrigeranteFormUpdate formUpdate) {

        Optional<Refrigerante> refrigerante = repository.findById(id);

        refrigerante.get().setValor(formUpdate.getValor());
        refrigerante.get().setPontos(formUpdate.getPontos());

        return repository.save(refrigerante.get());
    }

    @Override
    public Refrigerante getRefrigeranteById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Refrigerante> getRefrigeranteAll() {
        return repository.findAll();
    }

    @Override
    public Refrigerante delete(Long id) {
        repository.deleteById(id);
        return null;
    }
}
