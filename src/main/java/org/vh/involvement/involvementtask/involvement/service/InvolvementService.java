package org.vh.involvement.involvementtask.involvement.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vh.involvement.involvementtask.config.security.UserProvider;
import org.vh.involvement.involvementtask.exception.BadRequestException;
import org.vh.involvement.involvementtask.exception.RecordNotFoundException;
import org.vh.involvement.involvementtask.involvement.dto.InvolvementDTO;
import org.vh.involvement.involvementtask.involvement.mapper.InvolvementMapper;
import org.vh.involvement.involvementtask.involvement.model.Involvement;
import org.vh.involvement.involvementtask.involvement.repository.InvolvementRepository;
import org.vh.involvement.involvementtask.sector.model.Sector;
import org.vh.involvement.involvementtask.sector.repository.SectorRepository;
import org.vh.involvement.involvementtask.sector.service.SectorService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class InvolvementService {
    private final InvolvementRepository involvementRepository;
    private final SectorRepository sectorRepository;
    private final InvolvementMapper involvementMapper;
    private final UserProvider userProvider;

    public List<InvolvementDTO> getAllInvolvements() {
        List<Involvement> involvements = involvementRepository.findAll();
        return involvements.stream().map(involvementMapper::toDTO).collect(toList());
    }

    public InvolvementDTO getInvolvement(Long id) throws RecordNotFoundException {
        Optional<Involvement> involvement = involvementRepository.findById(id);
        if(involvement.isEmpty()){
            throw new RecordNotFoundException("Involvement does not exist", "involvement.not_found");
        }
        return involvementMapper.toDTO(involvement.get());
    }

    public InvolvementDTO getUserInvolvement() {
        return null;
    }

    public void createInvolvement(InvolvementDTO dto) throws RecordNotFoundException, BadRequestException {
        Involvement involvement = involvementMapper.toEntity(dto);
        validateSector(involvement.getSector());
        involvementRepository.saveAndFlush(involvement);
    }

    private void validateSector(Sector sector) throws BadRequestException, RecordNotFoundException {
        if(Objects.isNull(sector) || Objects.isNull(sector.getId())){
            throw new BadRequestException("Sector is required", "involvement.sector.required", "sector");
        }
        if(!sectorRepository.existsById(sector.getId())){
            throw new RecordNotFoundException("Assigned sector does not exist", "involvement.sector.not_found");
        }

    }

    public void deleteInvolvement(Long id) throws RecordNotFoundException {
        if (!involvementRepository.existsById(id)) {
            throw new RecordNotFoundException("Involvement does not exist", "involvement.not_found");
        }
        involvementRepository.deleteById(id);
    }

    public void updateInvolvement(Long id, InvolvementDTO dto) throws RecordNotFoundException, BadRequestException {
        if (!involvementRepository.existsById(id)) {
            throw new RecordNotFoundException("Involvement does not exist", "involvement.not_found");
        }
        Involvement involvement = involvementMapper.toEntity(dto);
        validateSector(involvement.getSector());
        involvement.setId(id);
        involvementRepository.saveAndFlush(involvement);
    }
}
