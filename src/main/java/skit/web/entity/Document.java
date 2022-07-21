package skit.web.entity;

import javax.persistence.*;

@Entity
@NamedQuery(name = "Document.deleteDocument",
            query = "DELETE FROM Document d WHERE d.document=:document")
@NamedQuery(name = "Document.getDocument",
            query = "SELECT d.id FROM Document d WHERE d.document=:document")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String document;
    @OneToOne
    private DiskSpace diskSpace;

    public Document(){}

    public Document(String document, DiskSpace diskSpace){
        this.document = document;
        this.diskSpace = diskSpace;
    }

    public DiskSpace getDiskSpace() {
        return diskSpace;
    }

    public void setDiskSpace(DiskSpace diskSpace) {
        this.diskSpace = diskSpace;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}
