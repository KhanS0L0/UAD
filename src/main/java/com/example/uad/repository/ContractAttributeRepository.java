package com.example.uad.repository;

import com.example.uad.domain.ContractAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractAttributeRepository extends JpaRepository<ContractAttribute, Long> {
}