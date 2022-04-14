package org.vh.involvement.involvementtask.involvement.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.vh.involvement.involvementtask.sector.dto.SectorDTO;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InvolvementDTO {
    private Long id;
    private String name;
    private SectorDTO sector;
    private Boolean agreement;
}
