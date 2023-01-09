package com.example.uad.model;

import com.example.uad.domain.Contract;
import com.example.uad.domain.ContractAttribute;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;

public class ContractDto {
    private Long id;

    @NotNull(message = "Имя не может быть пустым")
    @Size(min = 5, max = 255, message = "Имя должно быть в диапазоне от 5 до 30 символов")
    private String name;

    @NotNull(message = "Фамилия не может быть пустым")
    @Size(min = 5, max = 255, message = "Фамилия должно быть в диапазоне от 5 до 30 символов")
    private String surname;

    private String patronymic;

    private List<AttributeDto> attributes;

    public ContractDto() {
    }

    public ContractDto(Long id, String name, String surname, String patronymic, List<AttributeDto> attributes) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public List<AttributeDto> getAttributes() {
        return attributes;
    }

    public Long getId() {
        return id;
    }

    public ContractDto setId(Long id) {
        this.id = id;
        return this;
    }

    public static ContractDto convertToDto(Contract contract){
        return new ContractDto(
                contract.getId(),
                contract.getName(),
                contract.getSurname(),
                contract.getPatronymic(),
                contract.getContractAttributes()
                        .stream().map(AttributeDto::convertToDto).toList()
        );
    }

    public static Contract convertToEntity(ContractDto contractDto){
        var result = new Contract(
                contractDto.getName(),
                contractDto.getSurname(),
                contractDto.getPatronymic()
        );

        List<ContractAttribute> attributes = null;
        if (contractDto.getAttributes() != null) {
            attributes = contractDto.getAttributes()
                    .stream()
                    .map(it -> AttributeDto.convertToEntity(it, result))
                    .toList();
        }

        result.setContractAttributes(attributes);

        return result;
    }
}
