package com.example.uad.service.impl;

import com.example.uad.domain.ContractAttribute;
import com.example.uad.domain.Contract;
import com.example.uad.domain.AttributeType;
import com.example.uad.error.ErrorDescription;
import com.example.uad.model.ContractDto;
import com.example.uad.model.AttributeDto;
import com.example.uad.repository.ContractAttributeRepository;
import com.example.uad.repository.ContractRepository;
import com.example.uad.service.ContractService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {

    private final ContractRepository contractRepository;
    private final ContractAttributeRepository contractAttributeRepository;

    public ContractServiceImpl(ContractRepository contractRepository, ContractAttributeRepository contractAttributeRepository) {
        this.contractRepository = contractRepository;
        this.contractAttributeRepository = contractAttributeRepository;
    }

    @Override
    @Transactional
    public Long addContract(ContractDto contractDto) {
        return contractRepository.save(ContractDto.convertToEntity(contractDto)).getId();
    }

    @Override
    @Transactional
    public void addAttributeToContract(Long contractId, AttributeDto attributeDto) {
        Contract contract = contractRepository.findById(contractId)
                .orElseThrow(ErrorDescription.CONTRACT_NOT_FOUND::exception);
        ContractAttribute attribute = AttributeDto.convertToEntity(attributeDto, contract);
        contract.getContractAttributes().add(attribute);
        contractAttributeRepository.save(attribute);
        contractRepository.save(contract);
    }

    @Override
    public ContractDto getContract(@NotNull Long contractId) {
        var entity = contractRepository.findById(contractId)
                .orElseThrow(ErrorDescription.CONTRACT_NOT_FOUND::exception);
        return ContractDto.convertToDto(entity);
    }

    @Override
    public List<ContractDto> getContractsByAttributeType(AttributeType attributeType) {
        var entities = contractRepository.findAllByContractAttributes(attributeType);
        return entities.stream().map(ContractDto::convertToDto).toList();
    }

    @Override
    @Transactional
    public void addSubAttribute(Long contractId, Long attributeId, AttributeDto attributeDto) {
        var contract = contractRepository.findById(contractId)
                .orElseThrow(ErrorDescription.CONTRACT_NOT_FOUND::exception);

        var attributes = contract.getContractAttributes();

        ContractAttribute attribute;
        if (attributes != null && !attributes.isEmpty()) {
            attribute = attributes.stream()
                    .filter(attr -> attributeId.equals(attr.getId()))
                    .findAny()
                    .orElseThrow(ErrorDescription.ATTRIBUTE_NOT_FOUND::exception);

            ContractAttribute subContract = AttributeDto.convertToEntity(attributeDto, contract);
            subContract.setParentAttribute(attribute);
            subContract = contractAttributeRepository.save(subContract);
            attribute.getSubAttributes().add(subContract);
            contractAttributeRepository.save(attribute);
        }

    }
}
