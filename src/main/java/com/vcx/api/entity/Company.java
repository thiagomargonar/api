package com.vcx.api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vcx.api.entity.enuns.TypeEnum;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Company implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String company_name;

    private String fantasy_name;

    @Column(nullable = false, unique = true)
    private String CNPJ;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private TypeEnum typeEnum;

}
