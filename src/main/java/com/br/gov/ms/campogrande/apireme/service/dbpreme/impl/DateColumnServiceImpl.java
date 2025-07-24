package com.br.gov.ms.campogrande.apireme.service.dbpreme.impl;

import com.br.gov.ms.campogrande.apireme.service.dbpreme.DateColumnService;
import com.br.gov.ms.campogrande.apireme.util.DateUtil;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class DateColumnServiceImpl implements DateColumnService {

    @Override
    public List<String> generateDateColumns(Date from, Date to, Map<DayOfWeek, Set<Long>> dayClassTimes) {
        List<String> result = new ArrayList<>();
        LocalDate current = DateUtil.convertToLocalDate(from);
        LocalDate end = DateUtil.convertToLocalDate(to);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM");

        while (!current.isAfter(end)) {
            DayOfWeek dow = current.getDayOfWeek();
            if (dayClassTimes.containsKey(dow)) {
                String formatted = current.format(formatter);
                for (Long ctId : dayClassTimes.get(dow)) {
                    result.add(ctId + " - " + formatted);
                }
            }
            current = current.plusDays(1);
        }

        return result;
    }
}

