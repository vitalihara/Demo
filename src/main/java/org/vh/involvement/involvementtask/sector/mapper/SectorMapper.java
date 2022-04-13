package org.vh.involvement.involvementtask.sector.mapper;

import org.mapstruct.Mapping;
import org.vh.involvement.involvementtask.common.mapper.ModelMapper;
import org.vh.involvement.involvementtask.sector.dto.SectorDTO;
import org.vh.involvement.involvementtask.sector.model.Sector;


public interface SectorMapper extends ModelMapper<Sector, SectorDTO> {
    @Override
    @Mapping(target = "id", ignore = true)
    Sector toEntity(SectorDTO dto);
}
