package com.cardealer.services.impl;

import com.cardealer.models.dtos.PartAddDto;
import com.cardealer.models.entities.Part;
import com.cardealer.repositories.PartRepository;
import com.cardealer.services.PartService;
import com.cardealer.services.SupplierService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class PartServiceImpl implements PartService {
    private final PartRepository partRepository;
    private final ModelMapper modelMapper;
    private final SupplierService supplierService;

    public PartServiceImpl(PartRepository partRepository, ModelMapper modelMapper, SupplierService supplierService) {
        this.partRepository = partRepository;
        this.modelMapper = modelMapper;
        this.supplierService = supplierService;
    }

    @Override
    public void addPart(PartAddDto partAddDto) {
        if (this.partRepository.findByName(partAddDto.getName()) != null) {
            return;
        }
        Part part = this.modelMapper.map(partAddDto, Part.class);
        part.setSupplier(this.supplierService.getRandomSupplier());

        this.partRepository.saveAndFlush(part);
    }

    @Override
    public Part getRandomParts() {
        Set<Part> parts = new HashSet<>();
        Random random = new Random();
        long id = random.nextInt((int) this.partRepository.count()) + 1;
        Part part = this.partRepository.findById(id).get();
        return part;
    }
}
