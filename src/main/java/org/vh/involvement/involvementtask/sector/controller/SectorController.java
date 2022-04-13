package org.vh.involvement.involvementtask.sector.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.vh.involvement.involvementtask.exception.RecordNotFoundException;
import org.vh.involvement.involvementtask.sector.dto.SectorDTO;
import org.vh.involvement.involvementtask.sector.service.SectorService;

import java.util.List;

@RestController
@RequestMapping("/sectors")
@RequiredArgsConstructor
public class SectorController {

    private final SectorService sectorService;

    @GetMapping
    public List<SectorDTO> getAllSectors(){
        return sectorService.getAllSectors();
    }

    @GetMapping("/{id}")
    public SectorDTO getSector(@PathVariable Long id) throws RecordNotFoundException {
        return sectorService.getSector(id);
    }

    @PostMapping
    public void createSector(@RequestBody SectorDTO dto) {
        sectorService.createSector(dto);
    }

    @PostMapping("/{id}/sectors")
    public void createSector(@PathVariable Long id, @RequestBody SectorDTO dto) throws RecordNotFoundException {
        sectorService.createSector(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteSector(@PathVariable Long id) throws RecordNotFoundException {
        sectorService.deleteSector(id);
    }

    @PutMapping("/{id}")
    public void updateSector(@PathVariable Long id, @RequestBody SectorDTO dto) throws RecordNotFoundException {
        sectorService.updateSector(id, dto);
    }
}
