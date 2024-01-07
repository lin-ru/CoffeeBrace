package com.github.linru.CoffeeBrace.entities;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.*;
import jdk.dynalink.linker.LinkerServices;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "roles")
public class Role extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<User> users;
}
