package com.vcx.api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vcx.api.entity.Company;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class Note implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private Long number;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Company taker;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Company provider;

    @Column(nullable = false)
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date date;

    @Column(nullable = false)
    private BigDecimal value;
}
