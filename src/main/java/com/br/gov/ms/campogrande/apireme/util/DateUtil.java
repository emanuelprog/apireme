package com.br.gov.ms.campogrande.apireme.util;

import java.time.LocalDate;
import java.util.Date;

public class DateUtil {

    public static LocalDate convertToLocalDate(Date date) {
        return date.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
    }
}
