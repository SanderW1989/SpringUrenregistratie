package com.rotterdam.groep1.Urenregistratie.fileUpload.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FileUploadResponse {

    private final String identifier;

    public FileUploadResponse(String identifier) {
        this.identifier = identifier;
    }

    @JsonProperty("identifier")
    public String getIdentifier() {
        return identifier;
    }
}