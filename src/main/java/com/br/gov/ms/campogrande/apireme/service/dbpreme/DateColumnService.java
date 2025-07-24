package com.br.gov.ms.campogrande.apireme.service.dbpreme;

import java.time.DayOfWeek;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface DateColumnService {
    List<String> generateDateColumns(Date from, Date to, Map<DayOfWeek, Set<Long>> dayClassTimes);
}
