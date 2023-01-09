package com.example.uad.controller;

import com.example.uad.model.ContractDto;
import com.example.uad.service.ContractService;
import com.example.uad.common.Endpoints;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;

@RestController
public class ContractController {

    private final ContractService contractService;

    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @PostMapping(value = Endpoints.Contract.CONTRACT)
    public Long addContract(@Valid @RequestBody ContractDto contractDto){
        return contractService.addContract(contractDto);
    }

    @GetMapping(value = Endpoints.Contract.CONTRACT_ID)
    public ContractDto getContract(@PathVariable("contractId") Long contractId){
        return contractService.getContract(contractId);
    }

}
