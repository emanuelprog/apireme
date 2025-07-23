package com.br.gov.ms.campogrande.apireme.dto.dbpreme;

import lombok.Data;

import java.util.Date;

@Data
public class BimesterPeriodDTO {
    private Long id;
    private String bimester;
    private Date startDate;
    private Date endDate;
    private String changeUser;
    private Date createdAt;
}
