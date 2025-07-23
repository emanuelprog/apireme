package com.br.gov.ms.campogrande.apireme.dto.dbpreme;

import lombok.Data;

@Data
public class TeacherScheduleDTO {

    private Long id;
    private String enrollment;
    private Long schoolNumber;
    private Long year;
    private TeachingTypeDTO teachingType;
    private ShiftDTO shift;
    private GradeDTO grade;
    private GroupDTO groupId;
    private DisciplineDTO disciplineId;
}
