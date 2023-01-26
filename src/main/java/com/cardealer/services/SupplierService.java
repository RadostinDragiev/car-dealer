package com.cardealer.services;

import com.cardealer.models.dtos.SupplierAddDto;
import com.cardealer.models.dtos.SuppliersLocalJsonDto;
import com.cardealer.models.entities.Supplier;

import java.util.List;

public interface SupplierService {
    void addSupplier(SupplierAddDto supplierAddDto);

    Supplier getRandomSupplier();

    List<SuppliersLocalJsonDto> getLocalSuppliers();
}
