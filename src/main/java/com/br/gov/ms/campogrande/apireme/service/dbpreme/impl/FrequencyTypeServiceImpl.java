package com.br.gov.ms.campogrande.apireme.service.dbpreme.impl;

import com.br.gov.ms.campogrande.apireme.model.dbpreme.FrequencyType;
import com.br.gov.ms.campogrande.apireme.repository.dbpreme.FrequencyTypeRepository;
import com.br.gov.ms.campogrande.apireme.service.dbpreme.FrequencyTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FrequencyTypeServiceImpl implements FrequencyTypeService {

    private final FrequencyTypeRepository frequencyTypeRepository;

    @Override
    public String resolveAcronym(Long frequencyTypeId) {
        if (frequencyTypeId == null) return "";
        return frequencyTypeRepository.findById(frequencyTypeId)
                .map(FrequencyType::getAcronym)
                .orElse("");
    }
}
