package com.br.gov.ms.campogrande.apireme.model.dbpreme;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "historico_frequencia", schema = "profweb")
public class HistoryFrequency {

    @Id
    @Column(name = "historico_frequenciaid")
    private Long id;

    @Column(name = "usuario_alteracao")
    private String changeUser;

    @Column(name = "descricao")
    private String description;

    @Column(name = "numalu")
    private Long studentId;

    @Column(name = "numesc")
    private Long sector;

    @Column(name = "datainicial_ausencia")
    private Date startDate;

    @Column(name = "datafinal_ausencia")
    private Date endDate;
}
