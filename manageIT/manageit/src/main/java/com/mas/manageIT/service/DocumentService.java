package com.mas.manageIT.service;

import com.mas.manageIT.model.Document;

public interface DocumentService {
    Document add(Document document, long orderId);
}
