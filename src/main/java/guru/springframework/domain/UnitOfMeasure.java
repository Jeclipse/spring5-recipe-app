package guru.springframework.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "unit_of_measure")
public class UnitOfMeasure {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "description")
    private String description;

}