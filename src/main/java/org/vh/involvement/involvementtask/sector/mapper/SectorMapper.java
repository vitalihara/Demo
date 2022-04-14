package org.vh.involvement.involvementtask.sector.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.vh.involvement.involvementtask.common.mapper.ModelMapper;
import org.vh.involvement.involvementtask.sector.dto.SectorDTO;
import org.vh.involvement.involvementtask.sector.model.Sector;

@Mapper(componentModel = "spring")
public interface SectorMapper extends ModelMapper<Sector, SectorDTO> {
    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "parent.id", source = "parentId")
    Sector toEntity(SectorDTO dto);

    @Override
    @Mapping(source = "parent.id", target = "parentId")
    SectorDTO toDTO(Sector entity);
}
