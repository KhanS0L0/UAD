package com.example.uad.repository;

import com.example.uad.domain.Contract;
import com.example.uad.domain.AttributeType;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {

    Optional<Contract> findById(@NotNull Long id);

    @Query(value = "select distinct c from contract c " +
                "inner join contract_attribute as ca on c.id = ca.contract.id " +
                "where ca.attributeType = :attribute_type")
    List<Contract> findAllByContractAttributes(@Param("attribute_type") AttributeType attributeType);
}