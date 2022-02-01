package co.com.plantinfo.jpa.entity;

import co.com.plantinfo.model.TypePlant;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "plant")
public class PlantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private TypePlant type;

    @Column(name = "description", nullable = false, length = 500)
    private String description;

    @Column(name = "image", nullable = true, length = 500)
    private String image;
}
