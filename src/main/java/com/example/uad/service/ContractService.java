package com.example.uad.service;

import com.example.uad.model.ContractDto;
import com.example.uad.model.AttributeDto;
import com.example.uad.domain.AttributeType;

import java.util.List;

public interface ContractService {

    Long addContract(ContractDto contractDto);

    void addAttributeToContract(Long contractId, AttributeDto attributeDto);

    ContractDto getContract(Long contractId);

    List<ContractDto> getContractsByAttributeType(AttributeType attributeType);

    void addSubAttribute(Long contractId, Long attributeId, AttributeDto attributeDto);
}
