package com.br.gov.ms.campogrande.apireme.dto.dbpreme.frequency;

import com.br.gov.ms.campogrande.apireme.model.dbpreme.DiaryGrade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FrequencyRequestDTO {
    private List<StudentFrequencyDTO> studentsFrequency;
    private DiaryGrade diaryGrade;
}
