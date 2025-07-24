package com.br.gov.ms.campogrande.apireme.service.dbpreme.impl;

import com.br.gov.ms.campogrande.apireme.service.dbpreme.FrequencyCellService;
import com.br.gov.ms.campogrande.apireme.util.FrequencyUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FrequencyCellServiceImpl implements FrequencyCellService {

    @Override
    public Map<String, String> buildDefaultFrequencies(List<String> dateColumns, boolean hasOccurrence) {
        return dateColumns.stream()
                .collect(Collectors.toMap(
                        d -> d,
                        d -> hasOccurrence ? "" : "-"
                ));
    }

    @Override
    public Map<String, Map<String, Boolean>> buildDefaultEditableMap(List<String> dateColumns, boolean hasOccurrence) {
        return dateColumns.stream()
                .collect(Collectors.toMap(
                        d -> d,
                        d -> FrequencyUtil.buildCellInfo(hasOccurrence, false)
                ));
    }
}

