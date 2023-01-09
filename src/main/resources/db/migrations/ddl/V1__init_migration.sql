CREATE TABLE contract
(
    id         BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name       VARCHAR(255) NOT NULL,
    surname    VARCHAR(255) NOT NULL,
    patronymic VARCHAR(255),
    CONSTRAINT pk_contract PRIMARY KEY (id)
);

CREATE TABLE contract_attribute
(
    id                  BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    attribute_type      VARCHAR(255) NOT NULL,
    attribute_value     VARCHAR(255) NOT NULL,
    contract_id         BIGINT,
    parent_attribute_id BIGINT,
    CONSTRAINT pk_contract_attribute PRIMARY KEY (id)
);

ALTER TABLE contract_attribute
    ADD CONSTRAINT FK_CONTRACT_ATTRIBUTE_ON_CONTRACT FOREIGN KEY (contract_id) REFERENCES contract (id);

ALTER TABLE contract_attribute
    ADD CONSTRAINT FK_CONTRACT_ATTRIBUTE_ON_PARENTATTRIBUTE FOREIGN KEY (parent_attribute_id) REFERENCES contract_attribute (id);