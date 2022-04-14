package org.vh.involvement.involvementtask.sector.controller.validator;

import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.vh.involvement.involvementtask.sector.dto.SectorDTO;

@Component
public class SectorValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return SectorDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SectorDTO sector = (SectorDTO) target;
        String name = sector.getName();
        if(StringUtils.isEmpty(name) || name.length() <= 1){
            errors.rejectValue("name", "sector.name.incorrect", "Name is incorrect");
        }

    }
}
