package com.mas.manageIT.controller;

import com.mas.manageIT.model.Document;
import com.mas.manageIT.service.DocumentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/documents")
public class DocumentController{

    private final DocumentService documentService;


    public DocumentController(DocumentService documentService){
        this.documentService = documentService;
    }

    @PostMapping("/add/{orderId}")
    public ResponseEntity<Document> add(@RequestBody Document document, @PathVariable long orderId){
        Document newDocument = documentService.add(document, orderId);
        return ResponseEntity.ok(newDocument);
    }

}
