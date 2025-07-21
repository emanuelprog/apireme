package com.br.gov.ms.campogrande.apireme.dto.dbergon;

import lombok.Data;

@Data
public class AddressDTO {

    private String addressType;
    private String streetName;
    private Integer streetNumber;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private Integer zipCode;
}
