package serverTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import skit.web.entity.Account;
import skit.web.entity.DiskSpace;
import skit.web.entity.Document;
import skit.web.service.DocumentService;
import skit.web.service.DocumentServiceException;
import skit.web.service.DocumentServiceJPA;

public class DocumentServiceTest {
    private final DocumentService documentService = new DocumentServiceJPA();

    @Test
    public void thatNullDocumentCannotBeInserted() {
        Exception exception = assertThrows(DocumentServiceException.class, () -> {
            documentService.addDocument(null);
        });
        String expectedMessage = "No document to add";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void test() {
        Document document = new Document("first", new DiskSpace(15, new Account()));
        document.setId(1);
        documentService.addDocument(document);
        assertEquals(documentService.getDocumentID("first"), 1);
        documentService.deleteDocument("first");
    }
}
