package com.br.gov.ms.campogrande.apireme.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FrequencyUtil {

    public static final String EDITABLE = "editable";
    public static final String OBSERVATION = "observation";

    public static String formatDateKey(Long classTimeId, Date date) {
        String formatted = new SimpleDateFormat("dd/MM").format(date);
        return classTimeId + " - " + formatted;
    }

    public static Map<String, Boolean> buildCellInfo(boolean editable, boolean observation) {
        Map<String, Boolean> info = new HashMap<>();
        info.put(EDITABLE, editable);
        info.put(OBSERVATION, observation);
        return info;
    }
}