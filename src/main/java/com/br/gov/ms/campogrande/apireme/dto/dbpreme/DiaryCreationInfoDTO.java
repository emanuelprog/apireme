package com.br.gov.ms.campogrande.apireme.dto.dbpreme;

import com.br.gov.ms.campogrande.apireme.model.dbpreme.BimesterPeriod;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DiaryCreationInfoDTO {
    private Long teacherScheduleId;
    private BimesterPeriodDTO bimesterPeriod;
}
