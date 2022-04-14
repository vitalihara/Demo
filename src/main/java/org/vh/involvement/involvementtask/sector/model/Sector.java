package org.vh.involvement.involvementtask.sector.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
public class Sector {
    @Id
/*    @SequenceGenerator(name = "sector_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sector_id")*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Sector parent;
}
