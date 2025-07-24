package com.br.gov.ms.campogrande.apireme.model.dbpreme;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tempo_aula", schema = "profweb")
public class ClassTime {

    @Id
    @Column(name = "tempoaulaid")
    private Long id;

    @Column(name = "turnoid")
    private Long shiftId;

    @Column(name = "tempo")
    private Long time;
}
