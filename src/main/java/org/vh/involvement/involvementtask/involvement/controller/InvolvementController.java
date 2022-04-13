package org.vh.involvement.involvementtask.involvement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.vh.involvement.involvementtask.exception.BadRequestException;
import org.vh.involvement.involvementtask.exception.RecordNotFoundException;
import org.vh.involvement.involvementtask.involvement.dto.InvolvementDTO;
import org.vh.involvement.involvementtask.involvement.service.InvolvementService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class InvolvementController {

    private final InvolvementService involvementService;

    @GetMapping("/involvements")
    public List<InvolvementDTO> getAllInvolvements() {
        return involvementService.getAllInvolvements();
    }

    @GetMapping("/involvements/{id}")
    public InvolvementDTO getInvolvement(@PathVariable Long id) throws RecordNotFoundException {
        return involvementService.getInvolvement(id);
    }

    @GetMapping("user/involvements/")
    public InvolvementDTO getInvolvement() {
        return involvementService.getUserInvolvement();
    }

    @PostMapping("/involvements")
    public void createInvolvement(@RequestBody InvolvementDTO dto) throws RecordNotFoundException, BadRequestException {
        involvementService.createInvolvement(dto);
    }

    @DeleteMapping("/involvements/{id}")
    public void deleteInvolvement(@PathVariable Long id) throws RecordNotFoundException {
        involvementService.deleteInvolvement(id);

    }

    @PutMapping("/involvements/{id}")
    public void updateInvolvement(@PathVariable Long id, @RequestBody InvolvementDTO dto) throws RecordNotFoundException, BadRequestException {
        involvementService.updateInvolvement(id, dto);
    }
}
