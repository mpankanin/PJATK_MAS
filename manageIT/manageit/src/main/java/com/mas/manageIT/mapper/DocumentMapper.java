package com.mas.manageIT.mapper;

import com.mas.manageIT.associacion_manager.ObjectPlus;
import com.mas.manageIT.associacion_manager.ObjectPlusPlus;
import com.mas.manageIT.entity.DocumentEntity;
import com.mas.manageIT.entity.OrderEntity;
import com.mas.manageIT.model.Customer;
import com.mas.manageIT.model.Document;
import com.mas.manageIT.model.Order;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class DocumentMapper {

    private static final Logger logger = LoggerFactory.getLogger(OrderMapper.class);


    public static Document toModel(DocumentEntity documentEntity) {
        Document document = new Document();

        document.setId(documentEntity.getId());
        document.setType(documentEntity.getType());
        document.setDescription(documentEntity.getDescription());
        addDocumentOrderLink(document, documentEntity.getOrder().getId()); //link
        return document;
    }

    public static DocumentEntity toEntity(Document document){
        DocumentEntity documentEntity = new DocumentEntity();

        documentEntity.setId(document.getId());
        documentEntity.setType(document.getType());
        documentEntity.setDescription(document.getDescription());
        documentEntity.setOrder(getDocumentLink(document)); //foreign key
        return documentEntity;
    }

    private static void addDocumentOrderLink(Document document, Long orderId) {
        try {
            List<Document> documentExtent = (List<Document>) ObjectPlus.getExtent(Document.class);
            Optional<Document> theDocument = documentExtent.stream()
                    .filter(d-> d.getId().equals(orderId))
                    .findFirst();
            if (theDocument.isPresent()){
                document.addLink("DocumentOrder", "OrderDocument", theDocument.get());
            } else {
                logger.error(() -> "Getting order: " + orderId + " from extent failed.");
            }
        } catch (ClassNotFoundException e) {
            logger.error(() -> "Getting order's extent failed.");
        }
    }

    private static OrderEntity getDocumentLink(Document document) {
        try {
            ObjectPlusPlus[] links = document.getLinks("DocumentOrder");
            Order order = (Order) links[0];
            return OrderMapper.toEntity(order);
        } catch (Exception e) {
            logger.error(() -> "Getting order from a link failed.");
        }
        return null;
    }

}
