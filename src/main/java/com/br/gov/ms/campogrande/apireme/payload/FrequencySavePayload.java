package com.br.gov.ms.campogrande.apireme.payload;

import com.br.gov.ms.campogrande.apireme.model.dbpreme.DiaryGrade;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FrequencySavePayload {
    private List<StudentFrequencyPayload> frequencies;
    private DiaryGrade diaryGrade;
}
