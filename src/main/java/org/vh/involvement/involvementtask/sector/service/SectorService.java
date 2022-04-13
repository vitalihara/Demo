package org.vh.involvement.involvementtask.sector.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vh.involvement.involvementtask.exception.RecordNotFoundException;
import org.vh.involvement.involvementtask.sector.dto.SectorDTO;
import org.vh.involvement.involvementtask.sector.mapper.SectorMapper;
import org.vh.involvement.involvementtask.sector.model.Sector;
import org.vh.involvement.involvementtask.sector.repository.SectorRepository;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class SectorService {
    private final SectorRepository sectorRepository;
    private final SectorMapper sectorMapper;

    public List<SectorDTO> getAllSectors() {
        List<Sector> sectors = sectorRepository.findAll();
        return sectors.stream().map(sectorMapper::toDTO).collect(toList());
    }

    public SectorDTO getSector(Long id) throws RecordNotFoundException {
        Optional<Sector> sector = sectorRepository.findById(id);
        if (sector.isEmpty()) {
            throw new RecordNotFoundException("Sector does not exist", "sector.not_found");
        }
        return sectorMapper.toDTO(sector.get());
    }

    public void createSector(SectorDTO dto) {
        Sector sector = sectorMapper.toEntity(dto);
        sectorRepository.save(sector);
    }

    public void createSector(Long parentId, SectorDTO dto) throws RecordNotFoundException {
        Optional<Sector> parentSector = sectorRepository.findById(parentId);
        if (parentSector.isEmpty()) {
            throw new RecordNotFoundException("Parent sector does not exist", "sector.parent.not_found");
        }
        Sector sector = sectorMapper.toEntity(dto);
        sector.setParent(parentSector.get());
        sectorRepository.saveAndFlush(sector);

    }

    public void deleteSector(Long id) throws RecordNotFoundException {
        if(!sectorRepository.existsById(id)){
            throw new RecordNotFoundException("Sector does not exist", "sector.not_found");
        }
        sectorRepository.deleteById(id);
    }

    public void updateSector(Long id, SectorDTO dto) throws RecordNotFoundException {
        Optional<Sector> sector = sectorRepository.findById(id);
        if (sector.isEmpty()) {
            throw new RecordNotFoundException("Sector does not exist", "sector.not_found");
        }
        Sector sectorToUpdate = sectorMapper.toEntity(dto);
        sectorToUpdate.setId(id);
        sectorToUpdate.setParent(sector.get().getParent());
        sectorRepository.saveAndFlush(sectorToUpdate);
    }
}
