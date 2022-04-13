package org.vh.involvement.involvementtask.involvement.dto;

import lombok.Data;
import org.vh.involvement.involvementtask.sector.dto.SectorDTO;

@Data
public class InvolvementDTO {
    private Long id;
    private String name;
    private SectorDTO sector;
    private Boolean agreement;
}
