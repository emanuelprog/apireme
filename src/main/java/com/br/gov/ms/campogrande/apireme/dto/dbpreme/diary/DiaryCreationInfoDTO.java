package com.br.gov.ms.campogrande.apireme.dto.dbpreme.diary;

import com.br.gov.ms.campogrande.apireme.dto.dbpreme.BimesterPeriodDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DiaryCreationInfoDTO {
    private Long teacherScheduleId;
    private BimesterPeriodDTO bimesterPeriod;
}
