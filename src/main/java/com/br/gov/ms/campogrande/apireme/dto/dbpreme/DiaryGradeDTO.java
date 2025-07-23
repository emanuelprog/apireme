package com.br.gov.ms.campogrande.apireme.dto.dbpreme;

import lombok.Data;

import java.util.Date;

@Data
public class DiaryGradeDTO {
    private Long id;
    private String sector;
    private GroupDTO group;
    private ShiftDTO shift;
    private GradeDTO grade;
    private TeachingTypeDTO teachingType;
    private Long substituteTeacherId;
    private String enrollment;
    private Long employmentLink;
    private BimesterPeriodDTO bimesterPeriod;
    private DisciplineDTO discipline;
    private Long teacherScheduleId;
    private String diaryType;
    private Long assessmentTypeId;
    private String changeUser;
    private Boolean term;
    private Date createdAt;
}
