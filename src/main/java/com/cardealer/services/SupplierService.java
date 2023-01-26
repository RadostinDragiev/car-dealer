package com.cardealer.services;

import com.cardealer.models.dtos.SupplierAddDto;
import com.cardealer.models.entities.Supplier;

public interface SupplierService {
    void addSupplier(SupplierAddDto supplierAddDto);

    Supplier getRandomSupplier();
}
