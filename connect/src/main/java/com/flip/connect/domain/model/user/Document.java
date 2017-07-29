package com.flip.connect.domain.model.user;

/**
 * Created by ltorres on 28/07/2017.
 */

public class Document {
    private String documentType, documentNumber;

    public Document(String documentType, String documentNumber) {
        this.documentType = documentType;
        this.documentNumber = documentNumber;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }
}
