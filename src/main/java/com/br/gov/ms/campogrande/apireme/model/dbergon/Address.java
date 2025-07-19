package com.br.gov.ms.campogrande.apireme.model.dbergon;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Address {

    @Column(name = "TIPOLOGENDER")
    private String addressType;

    @Column(name = "NOMELOGENDER")
    private String streetName;

    @Column(name = "NUMENDER")
    private Integer streetNumber;

    @Column(name = "COMPLENDER")
    private String complement;

    @Column(name = "BAIRROENDER")
    private String neighborhood;

    @Column(name = "CIDADEENDER")
    private String city;

    @Column(name = "UFENDER")
    private String state;

    @Column(name = "CEPENDER")
    private Integer zipCode;
}