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
@Table(name = "soda")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Refrigerante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_code_soda")
    private long codigo;

    @Column(name = "name")
    private String nome;

    @Column(name = "value")
    private double valor;

    @Column(name = "points")
    private int pontos;
}
