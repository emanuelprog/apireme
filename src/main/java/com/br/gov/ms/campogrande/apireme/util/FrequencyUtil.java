package com.br.gov.ms.campogrande.apireme.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FrequencyUtil {

    public static String formatDateKey(Long classTimeId, Date date) {
        String formatted = new SimpleDateFormat("dd/MM/yyyy").format(date);
        return classTimeId + " - " + formatted;
    }
}