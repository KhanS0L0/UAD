INSERT INTO
    contract(name, surname, patronymic)
VALUES
    ('Vlad', 'Tarasenko', 'Herrington'),
    ('Khan', 'Zholdoshov', 'Darkholme');

INSERT INTO
    contract_attribute(attribute_type, attribute_value, contract_id, parent_attribute_id)
VALUES
    ('PHONE', '+7(950)012-12-12', 1, null),
    ('PHONE_CONFIRMATION', 'true', 1, 1),
    ('EMAIL', 'vlad@email.com', 1, null),
    ('EMAIL_CONFIRMATION', 'true', 1, 3),
    ('ACCOUNT_NUMBER', 'e51de6e6-8ec0-11ed-a1eb-0242ac120002', 1, null),
    ('LOCATION', 'Saint-Petersburg', 1, null),
    ('LOCATION', 'Lomonosova street 2', 1, 6),
    ('LOCATION', 'Nevskiy Prospekt 43', 1, 6);

INSERT INTO
    contract_attribute(attribute_type, attribute_value, contract_id, parent_attribute_id)
VALUES
    ('PHONE', '+7(950)048-16-29', 2, null),
    ('PHONE_CONFIRMATION', 'true', 2, 9),
    ('EMAIL', 'vlad@email.com', 2, null),
    ('EMAIL_CONFIRMATION', 'true', 2, 12),
    ('ACCOUNT_NUMBER', 'c73537aa-8ec1-11ed-a1eb-0242ac120002', 2, null),
    ('LOCATION', 'Saint-Petersburg', 2, null),
    ('LOCATION', 'Vyazemskiy street 5-7', 2, 14);
