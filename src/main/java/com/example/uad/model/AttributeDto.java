package com.example.uad.model;

import com.example.uad.domain.Contract;
import com.example.uad.domain.ContractAttribute;
import com.example.uad.domain.AttributeType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class AttributeDto {

    private Long id;

    @NotNull(message = "Значение аттрибута не может быть пустым")
    @Size(min = 5, max = 255, message = "Значение аттрибута должно быть в диапазоне от 5 до 300 символов")
    private String value;

    @NotNull(message = "Тип аттрибута не может быть пустым")
    private AttributeType attributeType;

    public AttributeDto() {
    }

    public AttributeDto(Long id, String value, AttributeType attributeType) {
        this.id = id;
        this.value = value;
        this.attributeType = attributeType;
    }

    public String getValue() {
        return value;
    }

    public AttributeType getAttributeType() {
        return attributeType;
    }

    public static AttributeDto convertToDto(ContractAttribute attribute){
        return new AttributeDto(
                attribute.getId(),
                attribute.getAttributeValue(),
                attribute.getAttributeType()
        );
    }

    public static ContractAttribute convertToEntity(AttributeDto attributeDto, Contract contract){
        return new ContractAttribute(
                attributeDto.getAttributeType(),
                attributeDto.getValue(),
                contract
        );
    }
}
