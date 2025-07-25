package com.br.gov.ms.campogrande.apireme.dto.dbpreme.frequency;

import com.br.gov.ms.campogrande.apireme.model.dbpreme.DiaryGrade;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FrequencySaveDTO {
    private List<StudentFrequencySaveDTO> frequencies;
    private DiaryGrade diaryGrade;
}
