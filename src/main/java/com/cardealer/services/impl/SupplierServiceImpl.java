package com.cardealer.services.impl;

import com.cardealer.models.dtos.SupplierAddDto;
import com.cardealer.models.dtos.SuppliersLocalJsonDto;
import com.cardealer.models.entities.Supplier;
import com.cardealer.repositories.SupplierRepository;
import com.cardealer.services.SupplierService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, ModelMapper modelMapper) {
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addSupplier(SupplierAddDto supplierAddDto) {
        if (this.supplierRepository.findSupplierByNameAndImporterEquals(supplierAddDto.getName(), supplierAddDto.isImporter()) != null) {
            return;
        }
        Supplier supplier = this.modelMapper.map(supplierAddDto, Supplier.class);
        this.supplierRepository.saveAndFlush(supplier);
    }

    @Override
    public Supplier getRandomSupplier() {
        Random random = new Random();
        long id = random.nextInt((int) this.supplierRepository.count()) + 1;
        return this.supplierRepository.findById(id).get();
    }

    @Override
    public List<SuppliersLocalJsonDto> getLocalSuppliers() {
        this.modelMapper.createTypeMap(Supplier.class, SuppliersLocalJsonDto.class)
                .addMappings(new PropertyMap<Supplier, SuppliersLocalJsonDto>() {
                    @Override
                    protected void configure() {
                        using(ctx -> ((Supplier) ctx.getSource()).getParts().size())
                                .map(source, destination.getPartsCount());
                    }
                });
        SuppliersLocalJsonDto[] suppliersLocalJsonDto = this.modelMapper.map(this.supplierRepository.findAllByImporterFalse(), SuppliersLocalJsonDto[].class);
        return Arrays.stream(suppliersLocalJsonDto).collect(Collectors.toList());
    }
}
