package com.br.gov.ms.campogrande.apireme.payload;

import com.br.gov.ms.campogrande.apireme.dto.dbpreme.FrequencyEntryDTO;
import lombok.Data;

import java.util.List;

@Data
public class StudentFrequencyPayload {
    private Long id;
    private String name;
    private Integer callNumber;
    private List<FrequencyEntryDTO> frequencies;
}
