package com.example.uad.controller;

import com.example.uad.domain.AttributeType;
import com.example.uad.model.ContractDto;
import com.example.uad.model.AttributeDto;
import com.example.uad.service.ContractService;
import com.example.uad.common.Endpoints;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AttributeController {

    private final ContractService contractService;

    public AttributeController(ContractService contractService) {
        this.contractService = contractService;
    }

    @PostMapping(value = Endpoints.Attribute.ATTRIBUTE)
    public void addAttribute(@PathVariable("contractId") Long contractId, @Valid @RequestBody AttributeDto attributeDto){
        contractService.addAttributeToContract(contractId, attributeDto);
    }

    @PostMapping(value = Endpoints.Attribute.ATTRIBUTE_SUBCONTRACT)
    public void addSubContractAttribute(
            @PathVariable("contractId") Long contractId,
            @PathVariable("attributeId") Long attributeId,
            @Valid @RequestBody AttributeDto attributeDto
    ){
        contractService.addSubAttribute(contractId, attributeId, attributeDto);
    }

    @GetMapping(value = Endpoints.Attribute.ATTRIBUTE_TYPE)
    public List<ContractDto> getContractsByType(@PathVariable("attributeType") String type){
        return contractService.getContractsByAttributeType(AttributeType.valueOf(type));
    }
}
