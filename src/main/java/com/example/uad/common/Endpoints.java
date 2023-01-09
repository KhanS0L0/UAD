package com.example.uad.common;

public interface Endpoints {

    interface Contract{
        String CONTRACT = "/contract";
        String CONTRACT_ID = "/contract/{contractId}";
    }

    interface Attribute{
        String ATTRIBUTE = "/contract/{contractId}/attribute";
        String ATTRIBUTE_SUBCONTRACT = "/contract/{contractId}/{attributeId}";
        String ATTRIBUTE_TYPE = "/contract/type/{attributeType}";
    }

    interface File{
        String FILE = "/file";
        String FILE_UUID = "/file/{uuid}";
    }
}
