package com.example.uad.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;

import java.util.List;

@Entity(name = "contract_attribute")
public class ContractAttribute {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contract_id", referencedColumnName = "id")
    private Contract contract;

    @Column(name = "attribute_type")
    @Enumerated(EnumType.STRING)
    private AttributeType attributeType;

    @Column(name = "attribute_value")
    private String attributeValue;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private ContractAttribute parentAttribute;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, mappedBy = "parentAttribute")
    private List<ContractAttribute> subAttributes;

    public ContractAttribute() {
    }

    public ContractAttribute(AttributeType attributeType, String attributeValue, Contract contract) {
        this.attributeType = attributeType;
        this.attributeValue = attributeValue;
        this.contract = contract;
    }

    public Long getId() {
        return id;
    }

    public void setParentAttribute(ContractAttribute parentAttribute) {
        this.parentAttribute = parentAttribute;
    }

    public AttributeType getAttributeType() {
        return attributeType;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public List<ContractAttribute> getSubAttributes() {
        return subAttributes;
    }

}
