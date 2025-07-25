package com.br.gov.ms.campogrande.apireme.dto.dbpreme.frequency;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryFrequencyDTO {
    private Long id;
    private String changeUser;
    private String description;
    private Long studentId;
    private Long sector;
    private Date startDate;
    private Date endDate;
}
