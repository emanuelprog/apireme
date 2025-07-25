package com.br.gov.ms.campogrande.apireme.service.dbpreme;

import com.br.gov.ms.campogrande.apireme.dto.dbpreme.frequency.StudentFrequencyDTO;
import com.br.gov.ms.campogrande.apireme.model.dbedu.Student;
import com.br.gov.ms.campogrande.apireme.model.dbpreme.StudentFrequency;
import com.br.gov.ms.campogrande.apireme.dto.dbpreme.frequency.StudentFrequencySaveDTO;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface StudentFrequencyService {
    List<StudentFrequency> findByParams(List<Long> studentIds, Date start, Date end);

    List<StudentFrequencyDTO> buildStudentFrequencyDTOs(List<Student> students, List<String> dateColumns, Map<Long, List<StudentFrequency>> frequencies);

    List<StudentFrequencySaveDTO> saveStudentFrequencies(List<StudentFrequencySaveDTO> frequencies, Long diaryGradeId, String changeUser);
}
