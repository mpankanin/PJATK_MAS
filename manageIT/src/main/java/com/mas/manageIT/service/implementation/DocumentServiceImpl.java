package com.mas.manageIT.service.implementation;

import com.mas.manageIT.repository.DocumentRepository;
import com.mas.manageIT.service.DocumentService;
import org.springframework.stereotype.Service;

@Service
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;


    public DocumentServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

}
