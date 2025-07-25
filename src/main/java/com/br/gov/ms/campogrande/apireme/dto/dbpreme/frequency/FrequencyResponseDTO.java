package com.br.gov.ms.campogrande.apireme.dto.dbpreme.frequency;

import com.br.gov.ms.campogrande.apireme.dto.dbpreme.diary.DiaryGradeDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FrequencyResponseDTO {
    private List<StudentFrequencyDTO> studentsFrequency;
    private List<String> dateColumns;
    private DiaryGradeDTO diaryGrade;
}
