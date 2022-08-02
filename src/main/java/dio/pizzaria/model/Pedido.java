package dio.pizzaria.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "request")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_request")
    private long id;

    @OneToOne
    @JoinColumn(name = "id_code_pizza")
    private Pizza pizzas;

    @Column(name = "amount_pizza")
    private int qtdPizza;

    @OneToOne
    @JoinColumn(name = "id_code_soda")
    private Refrigerante refrigerantes;

    @Column(name = "amount_refrigerante")
    private int qtdRefrigerante;

    @OneToOne
    @JoinColumn(name = "id_customer")
    private Cliente cliente;

    @Column(name = "value")
    private double valor = 0;

    @Column(name = "points ")
    private int pontos = 0;


}
