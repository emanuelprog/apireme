package com.br.gov.ms.campogrande.apireme.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class DateUtil {

    public static LocalDate convertToLocalDate(Date date) {
        return date.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
    }

    public static String formatDate(Date date) {
        if (date == null) return "";
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    public static Date parseDateFromDisplayFormat(String displayDate) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(displayDate);
        } catch (Exception e) {
            return null;
        }
    }
}
