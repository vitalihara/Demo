package org.vh.involvement.involvementtask.involvement.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.vh.involvement.involvementtask.sector.dto.SectorDTO;
import org.vh.involvement.involvementtask.sector.model.Sector;

import javax.persistence.*;

@Data
@Entity
public class Involvement {
    @Id
/*    @SequenceGenerator(name = "involvement_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "involvement_id")*/

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Sector sector;
    private Boolean agreement = false;
}
