package com.mas.manageIT.mapper;

import com.mas.manageIT.entity.DocumentEntity;
import com.mas.manageIT.model.Document;
import com.mas.manageIT.model.Order;

public class DocumentMapper {

    public static Document toModel(DocumentEntity documentEntity) {
        Long id = (documentEntity.getId());
        String name = (documentEntity.getName());
        String description = (documentEntity.getDescription());
        Order order = OrderMapper.toModel(documentEntity.getOrder());
        return Document.createDocument(id, order, name, description);
    }

    public static DocumentEntity toEntity(Document document){
        DocumentEntity documentEntity = new DocumentEntity();
        documentEntity.setId(document.getId());
        documentEntity.setName(document.getName());
        documentEntity.setDescription(document.getDescription());
        documentEntity.setOrder(OrderMapper.toEntity(document.getOrder()));
        return documentEntity;
    }

}
