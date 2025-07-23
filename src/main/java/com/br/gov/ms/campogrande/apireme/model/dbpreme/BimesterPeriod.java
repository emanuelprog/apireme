package com.br.gov.ms.campogrande.apireme.model.dbpreme;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "periodo_bimestre", schema = "profweb")
public class BimesterPeriod {

    @Id
    @Column(name = "periodobimestreid")
    private Long id;

    @Column(name = "bimestre")
    private String bimester;

    @Column(name = "data_inicio")
    private Date startDate;

    @Column(name = "data_fim")
    private Date endDate;

    @Column(name = "usualt")
    private String changeUser;

    @Column(name = "data_gravou")
    private Date createdAt;
}
