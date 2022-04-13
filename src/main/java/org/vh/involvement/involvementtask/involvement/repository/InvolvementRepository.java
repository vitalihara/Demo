package org.vh.involvement.involvementtask.involvement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vh.involvement.involvementtask.involvement.model.Involvement;
import org.vh.involvement.involvementtask.sector.model.Sector;

@Repository
public interface InvolvementRepository extends JpaRepository<Involvement, Long> {
}
