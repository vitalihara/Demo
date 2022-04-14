package org.vh.involvement.involvementtask.sector.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SectorDTO {
    private Long id;
    private String name;
    private Long parentId;
}
