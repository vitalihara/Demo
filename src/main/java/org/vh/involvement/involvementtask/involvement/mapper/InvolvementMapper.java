package org.vh.involvement.involvementtask.involvement.mapper;

import org.mapstruct.Mapper;
import org.vh.involvement.involvementtask.common.mapper.ModelMapper;
import org.vh.involvement.involvementtask.involvement.dto.InvolvementDTO;
import org.vh.involvement.involvementtask.involvement.model.Involvement;


@Mapper
public interface InvolvementMapper extends ModelMapper<Involvement, InvolvementDTO> {

    @Override
    /*@Mapping(target = "id", ignore = true)
    @Mapping(target = "parentId", ignore = true)*/
    Involvement toEntity(InvolvementDTO dto);
}
