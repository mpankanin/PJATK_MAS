package com.mas.manageIT.model;

import com.mas.manageIT.associacion_manager.ObjectPlusPlus;
import com.mas.manageIT.mapper.OrderMapper;
import com.mas.manageIT.model.enums.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Document extends ObjectPlusPlus {

    private Long id;

    private DocumentType type;

    private String description;


    public static Document createDocument(long id, DocumentType type, String description, Order order) {
        Document document = new Document(id, type, description);
        document.addLink("DocumentOrder", "OrderDocument", order);
        return new Document(id, type, description);
    }

}
