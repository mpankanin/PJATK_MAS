package com.mas.manageIT.mapper;

import com.mas.manageIT.entity.DocumentEntity;
import com.mas.manageIT.model.Document;

public class DocumentMapper {

    public static Document toModel(DocumentEntity documentEntity) {
        Document document = new Document();

        document.setId(documentEntity.getId());
        document.setType(documentEntity.getType());
        document.setDescription(documentEntity.getDescription());
        return document;
    }

    public static DocumentEntity toEntity(Document document){
        DocumentEntity documentEntity = new DocumentEntity();

        documentEntity.setId(document.getId());
        documentEntity.setType(document.getType());
        documentEntity.setDescription(document.getDescription());
        return documentEntity;
    }

}
