package skit.web.service;

import skit.web.entity.Document;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class DocumentServiceJPA implements DocumentService{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addDocument(Document document) {
        if (document == null) throw new DocumentServiceException("No document to add");
        entityManager.persist(document);
    }

    @Override
    public void deleteDocument(String document) {
        if (document == null || this.getDocumentID(document) < 1) throw new DocumentServiceException("Invalid document");
        entityManager.createNamedQuery("Document.deleteDocument").setParameter("document", document).executeUpdate();
    }

    @Override
    public int getDocumentID(String document) {
        try {
            return (int) entityManager.createNamedQuery("Document.getDocument").setParameter("document", document).getSingleResult();
        } catch (Exception e) {
            return 0;
        }
    }
}
