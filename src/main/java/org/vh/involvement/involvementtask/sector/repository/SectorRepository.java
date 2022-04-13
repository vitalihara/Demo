package org.vh.involvement.involvementtask.sector.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vh.involvement.involvementtask.involvement.model.Involvement;
import org.vh.involvement.involvementtask.sector.model.Sector;

@Repository
public interface SectorRepository extends JpaRepository<Sector, Long> {
}
