package com.mas.manageIT.service.implementation;

import com.mas.manageIT.associacion_manager.ObjectPlus;
import com.mas.manageIT.exception.OrderNotFoundException;
import com.mas.manageIT.model.Document;
import com.mas.manageIT.model.Order;
import com.mas.manageIT.repository.DocumentRepository;
import com.mas.manageIT.service.DocumentService;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;
    private final Logger logger = LoggerFactory.getLogger(DocumentServiceImpl.class);


    public DocumentServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public Document add(Document document, long orderId) {
        try {
            List<Order> extent = (List<Order>) ObjectPlus.getExtent(Order.class);
            Optional<Order> optional = extent.stream().filter(o -> o.getId().equals(orderId)).findFirst();

            List<Document> documentExtent = (List<Document>) ObjectPlus.getExtent(Document.class);

            if (optional.isPresent()) {
                documentExtent.remove(document);
                Document createdDocument = Document.createDocument(documentExtent.size() + 1, document.getType(), document.getDescription(), optional.get());
                return createdDocument;
            } else {
                throw new OrderNotFoundException("Order: " + orderId + " doesn't exist.");
            }
        } catch (ClassNotFoundException e) {
            logger.error(() -> "Couldn't get a order's extent.");
        }
        return null;
    }

}
