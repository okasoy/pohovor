package skit.web.entity;

import javax.persistence.*;

@Entity
public class DiskSpace {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int capacity;
    @OneToOne
    private Account user;

    public DiskSpace(){}

    public DiskSpace(int capacity, Account user){
        this.capacity = capacity;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Account getUser() {
        return user;
    }

    public void setUser(Account user) {
        this.user = user;
    }
}
