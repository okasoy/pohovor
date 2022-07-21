package skit.web.service;

import skit.web.entity.Document;

public interface DocumentService {
    void addDocument(Document document);
    void deleteDocument(String document);
    int getDocumentID(String document);
}
