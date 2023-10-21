package kodlamaio.rentACar.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name = "models")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "brand_id") //Brand entities ile ilişkilendirildi
    private Brand brand;

    @OneToMany(mappedBy = "model") //Car entities ile ilişkilendirildi -> Car entitiesindeki model ile ilişkilendirildi
    private List<Car> cars;
}
