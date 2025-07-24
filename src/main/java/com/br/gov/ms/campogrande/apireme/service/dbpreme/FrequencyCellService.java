package com.br.gov.ms.campogrande.apireme.service.dbpreme;

import java.util.List;
import java.util.Map;

public interface FrequencyCellService {
    Map<String, String> buildDefaultFrequencies(List<String> dateColumns, boolean hasOccurrence);
    Map<String, Map<String, Boolean>> buildDefaultEditableMap(List<String> dateColumns, boolean hasOccurrence);
}
