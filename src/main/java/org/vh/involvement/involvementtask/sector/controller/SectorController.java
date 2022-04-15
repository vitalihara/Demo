package org.vh.involvement.involvementtask.sector.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.vh.involvement.involvementtask.exception.RecordNotFoundException;
import org.vh.involvement.involvementtask.sector.controller.validator.SectorValidator;
import org.vh.involvement.involvementtask.sector.dto.SectorDTO;
import org.vh.involvement.involvementtask.sector.service.SectorService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/sectors")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ADMIN')")
public class SectorController {

    private final SectorService sectorService;
    private final SectorValidator sectorValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(sectorValidator);
    }

    @GetMapping
    public List<SectorDTO> getAllSectors() {
        return sectorService.getAllSectors();
    }

    @GetMapping("/{id}")
    public SectorDTO getSector(@PathVariable Long id) throws RecordNotFoundException {
        return sectorService.getSector(id);
    }

    @PostMapping
    public void createSector(@RequestBody @Valid SectorDTO dto) {
        sectorService.createSector(dto);
    }

    @PostMapping("/{id}/sectors")
    public void createSector(@PathVariable Long id, @RequestBody @Valid SectorDTO dto) throws RecordNotFoundException {
        sectorService.createSector(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteSector(@PathVariable Long id) throws RecordNotFoundException {
        sectorService.deleteSector(id);
    }

    @PutMapping("/{id}")
    public void updateSector(@PathVariable Long id, @RequestBody @Valid SectorDTO dto) throws RecordNotFoundException {
        sectorService.updateSector(id, dto);
    }
}
