package com.cardealer.services;

import com.cardealer.models.dtos.PartAddDto;
import com.cardealer.models.entities.Part;

import java.util.Set;

public interface PartService {
    void addPart(PartAddDto partAddDto);

    Part getRandomParts();
}
