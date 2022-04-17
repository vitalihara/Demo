package org.vh.involvement.involvementtask.sector.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.vh.involvement.involvementtask.common.mapper.ModelMapper;
import org.vh.involvement.involvementtask.sector.dto.SectorDTO;
import org.vh.involvement.involvementtask.sector.dto.SectorXmlDTO;
import org.vh.involvement.involvementtask.sector.model.Sector;

@Mapper(componentModel = "spring")
public interface SectorXmlMapper extends ModelMapper<Sector, SectorXmlDTO> {
    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "parent.id", source = "parentId")
    Sector toEntity(SectorXmlDTO dto);

    @Override
    @Mapping(source = "parent.id", target = "parentId")
    SectorXmlDTO toDTO(Sector entity);
}
