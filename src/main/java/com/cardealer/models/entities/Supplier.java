package com.cardealer.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "suppliers")
public class Supplier extends BaseEntity {
    private String name;

    @Column(name = "is_importer")
    private boolean isImporter;
}
