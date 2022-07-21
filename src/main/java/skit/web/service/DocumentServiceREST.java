package skit.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import skit.web.entity.Document;

@RestController
@RequestMapping("/api/document")
public class DocumentServiceREST {
    @Autowired
    private DocumentService documentService;

    @PostMapping
    public void addDocument(@RequestBody Document document) {
        documentService.addDocument(document);
    }

    @PostMapping("/delete")
    public void deleteDocument(@RequestBody String document) {
        documentService.deleteDocument(document);
    }
}
