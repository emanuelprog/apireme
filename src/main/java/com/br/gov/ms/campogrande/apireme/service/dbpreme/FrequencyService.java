package com.br.gov.ms.campogrande.apireme.service.dbpreme;

import com.br.gov.ms.campogrande.apireme.dto.dbpreme.FrequencyResponseDTO;
import com.br.gov.ms.campogrande.apireme.payload.FrequencySavePayload;

import java.util.Date;

public interface FrequencyService {
    FrequencyResponseDTO getFrequencyResponse(Long teacherScheduleId, Long disciplineId, String sector, String group, String grade, String shift, Long year, Date from, Date to);

    FrequencySavePayload saveFrequencies(FrequencySavePayload payload);
}
