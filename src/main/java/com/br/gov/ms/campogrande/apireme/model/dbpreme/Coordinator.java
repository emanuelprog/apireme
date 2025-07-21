package com.br.gov.ms.campogrande.apireme.model.dbpreme;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "coordenadores_escolas", schema = "profweb")
public class Coordinator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "matricula")
    private Long enrollment;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "nome")
    private String name;

    @Column(name = "ativo")
    private String active;
}
