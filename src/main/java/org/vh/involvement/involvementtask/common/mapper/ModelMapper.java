package org.vh.involvement.involvementtask.common.mapper;

public interface ModelMapper<E, D> {
    E toEntity(D dto);

    D toDTO(E entity);
}
